package MyFiles;

public class SmartHome {
    private SmartPlug[] plugs;
    private Room[] rooms;
    private AttachedDevice[] AD;
    private int plugIndex;
    private int roomsIndex;
    private int ADIndex;


    public void roomAdder(String roomName){
        roomsIndex++;
        rooms[roomsIndex-1] = new Room(roomName,roomsIndex);
    }
    public void ADAdder(String deviceName){
        ADIndex++;
        AD[ADIndex-1] = new AttachedDevice(deviceName,ADIndex);
    }

    public Room getRoom(int index){return rooms[index];}

    public SmartPlug getPlug(int index){return plugs[index];}

    public AttachedDevice getAttachedDevice(int index){
        return AD[index];
    }

    public void plugAdder(Room rm){
        plugIndex++;
        plugs[plugIndex-1] = new SmartPlug(rm, plugIndex);
    }

    //Constructor
    public SmartHome(int numberOfSmartPlugs, int numberOfRooms){

        plugs = new SmartPlug[numberOfSmartPlugs];
        rooms = new Room[numberOfRooms];
        AD = new AttachedDevice[5];
        AttachedDeviceConstruction();
        plugIndex = 0;
        roomsIndex = 0;
        ADIndex = 5;
    }

    public int getSizeOfPlug(){return plugs.length;}
    public int getSizeOfRoom(){return rooms.length;}
    public int getSizeOfAD(){return AD.length;}

    public int getPlugIndex() {return plugIndex;}
    public int getADIndex() {return ADIndex;}
    public int getRoomsIndex() {return roomsIndex;}

    private void AttachedDeviceConstruction(){
        AD[0] = new AttachedDevice("lamp",1);
        AD[1] = new AttachedDevice("TV",2);
        AD[2] = new AttachedDevice("Computer",3);
        AD[3] = new AttachedDevice("Phone Recharger",4);
        AD[4] = new AttachedDevice("Heater",5);
    }

    public void houseLevel(int houseLevelOption) {
        switch(houseLevelOption){
            case 1:
                for(int i=0; i<getSizeOfPlug();i++){
                    plugs[i].setStatus(true);
                }
                break;

            case 0:
                for(int i=0; i<getSizeOfPlug();i++){
                    plugs[i].setStatus(false);
                }
        }
    }
    public void roomLevel(int rlOption,int roomLevelOption) {
        switch(rlOption){
            case 1:
                for(int i=0; i<getSizeOfPlug();i++){
                    if(plugs[i].getRoom().getRoomId()==roomLevelOption)
                        plugs[i].setStatus(false);
                }
                break;
            case 2:
                for(int i=0; i<getSizeOfPlug();i++){
                    if(plugs[i].getRoom().getRoomId()==roomLevelOption)
                    plugs[i].setStatus(true);
                }
                break;
            case 3:
                for(int i=0; i<getSizeOfPlug();i++) {
                    if(plugs[i].getRoom().getRoomId()==roomLevelOption)
                    plugs[i].toggle();
                }
                break;
        }
    }
    //plugLevelI = plug level initial
    public void plugLevelI(int plugLevelMenu, int plugLeveOption){
        switch(plugLevelMenu){
            case 1:
                plugs[plugLeveOption-1].setStatus(false);
                break;
            case 2:
                plugs[plugLeveOption-1].setStatus(true);
                break;
        }
    }
    public void plugDC(int plugLeveDC,int plugLeveOption){
        plugs[plugLeveOption-1].setAD(AD[plugLeveDC-1]);
    }
    public void plugRM(int roomSelect,int plugLeveOption){
        plugs[plugLeveOption-1].setRoom(rooms[roomSelect-1]);
    }

    public void systemPlugAdder(int numberOfPlugsAdded){
        SmartPlug[] newPlugs = new SmartPlug[plugs.length+numberOfPlugsAdded];
        for(int i=0;i<plugs.length;i++){
            newPlugs[i] = new SmartPlug();
            newPlugs[i]=plugs[i];
        }
        plugs = newPlugs;
    }
    public void systemAttachedDeviceAdder(int numberOfAttachedDeviceAdded){
        AttachedDevice[] newAttachedDevices = new AttachedDevice[AD.length+numberOfAttachedDeviceAdded];
        for(int i=0;i<AD.length;i++){
            newAttachedDevices[i] = new AttachedDevice();
            newAttachedDevices[i] = AD[i];
        }
        AD = newAttachedDevices;
    }
    public void systemRoomAdder(int numberOfRoomsAdded){
        Room[] newRooms = new Room[rooms.length+numberOfRoomsAdded];
        for(int i=0;i<rooms.length;i++){
            newRooms[i] = new Room();
            newRooms[i]= rooms[i];
        }
        rooms = newRooms;
    }


}
