package subito.parlato.retroroutepuzzle.exception;

public class RoomNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long roomId;

    public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public RoomNotFoundException(Long roomId) {
        super(String.format("Room %d does not exist in the map.", roomId));
        this.roomId = roomId;
    }

}
