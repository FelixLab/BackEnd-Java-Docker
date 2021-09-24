package subito.parlato.retroroutepuzzle;

import subito.parlato.retroroutepuzzle.exception.RoomNotFoundException;
import subito.parlato.retroroutepuzzle.model.Item;
import subito.parlato.retroroutepuzzle.model.Maze;
import subito.parlato.retroroutepuzzle.model.Route;
import subito.parlato.retroroutepuzzle.service.CommandLineParser;
import subito.parlato.retroroutepuzzle.service.MazeService;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class App {

    public static void main(String[] args) throws IOException {
        try {
        	
            Optional<CommandLineParser> commandLineParser = CommandLineParser.parse(args);
            if (!commandLineParser.isPresent()) {
                System.exit(1);
            }
            //arguments
            System.out.println(Arrays.toString(args));
            //number of items passed
            System.out.println("Item passed: " + commandLineParser.get().getItems().length);
            Maze maze = MazeService.load(commandLineParser.get().getMapFile());

            Set<Item> itemsToCollect = Arrays.asList(commandLineParser.get().getItems())
                    .stream()
                    .map(Item::new)
                    .collect(toSet());

            Route route = new MazeService().solve(maze, commandLineParser.get().getRoomId(), itemsToCollect);
            route.printMoves(System.out, itemsToCollect.isEmpty());
        } catch (RoomNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
