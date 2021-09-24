package subito.parlato.retroroutepuzzle.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Move {

    private Room room;
    public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Set<Item> getCollectedItems() {
		return collectedItems;
	}
	public Move(Room room, Set<Item> collectedItems) {
		super();
		this.room = room;
		this.collectedItems = collectedItems;
	}
	public Move() {
		super();
	}
	public void setCollectedItems(Set<Item> collectedItems) {
		this.collectedItems = collectedItems;
	}
	private Set<Item> collectedItems;

}
