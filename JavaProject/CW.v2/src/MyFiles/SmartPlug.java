package MyFiles;

public class SmartPlug {

    //Room
    private Room room;
    //Attached Devices
    private AttachedDevice AD;

    //Smart Plug
    private boolean status;
    private int ID;

    //Constructor
    public SmartPlug(Room rm, int ID) {
        this.status = false;
        this.ID = ID;
        this.room = rm;
    }

    public SmartPlug(){

    }

    public void setAD(AttachedDevice AD) {
        this.AD = AD;
    }

    //Getter and setter methods
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    public Room getRoom() {return room;}
    public void setRoom(Room room) {this.room = room; }

    //Display
    @Override
    public String toString() {return  "ID: " + ID + "| status: " + (convert(status)) + '|'+"room: "+room;}


    public void toggle(){
        setStatus(!getStatus());
    }
    public String convert(boolean value){
        if(value)
        {
            return "On";
        }
        return "Off";
    }
}
