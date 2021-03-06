package subito.parlato.retroroutepuzzle.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
public class Room {

    private Long id;
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String name;
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Long north;
    private Long south;
    private Long west;
    private Long east;
    @SerializedName("objects")
    private Set<Item> items;
    public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@Getter
    private Set<Room> neighbors;

    public Set<Room> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(Set<Room> neighbors) {
		this.neighbors = neighbors;
	}

	public Room() {
        this.items = Collections.emptySet();
    }

    public void calculateNeighbors(Map<Long, Room> mazeMap) {
        neighbors = Stream.of(north, south, east, west)
                .filter(Objects::nonNull)
                .map(roomId -> Maze.getRoom(mazeMap, roomId))
                .collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + " " + name;
    }


}
