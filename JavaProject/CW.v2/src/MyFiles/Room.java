package MyFiles;

public class Room {
    private String roomName;
    private int roomId;

    //Constructor
    public Room(String roomName, int roomId) {
        this.roomName = roomName;
        this.roomId = roomId;
    }
    public Room(){

    }

    //Getter and setter methods
    public String getRoomName() {
        return roomName;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }


    public int getRoomId() {return roomId;}
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    //Display
    @Override
    public String toString() {
        return "Room Name:" + roomName + "| Room Id:" + roomId + '|';
    }
}
