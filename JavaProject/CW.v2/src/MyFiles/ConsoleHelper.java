package MyFiles;

import java.util.Scanner;

public class ConsoleHelper {
    public String getString(String prompt){
        Scanner in = new Scanner(System.in);
        String s;
        out(prompt);
        try {
            s = in.next();
        } catch (Exception e){
            return getString(prompt);
        }
        return s;
    }
    public int getInt(String prompt){
        Scanner in = new Scanner(System.in);
        int i;
        out(prompt);
        try {
            i = in.nextInt();
        } catch (Exception e){
            //extra messages
            return getInt(prompt);
        }
        return i;
    }
    public void out(String message){ System.out.println(message);}


    public void populateSmartHome(SmartHome home){
        createRooms(home.getSizeOfRoom(), home);
        printRooms(home);
        createPlugs(home.getSizeOfPlug(), home);
        connectDevices(home);
    }

    public void connectDevices(SmartHome home){
        out("AVAILABLE DEVICE LIST OPTIONS\n" +
                "These are standard devices that can be attached to\n" +
                "the smart plug:\n");
        for(int i=0; i< home.getSizeOfAD(); i++){
            out(home.getAttachedDevice(i).toString()+"\n");
        }
        for(int i=0; i< home.getSizeOfPlug();i++){
            int plugDeviceId = getInt("Please select the device to attach to smart plug: "
                    +home.getPlug(i).getID()+ " (integer only)");
            home.getPlug(i).setAD(home.getAttachedDevice(plugDeviceId-1));
        }

    }

    public void createRooms(int numberOfRooms, SmartHome home){
        for(int i=0; i< numberOfRooms; i++){
            String roomName = getString("Enter the name of room number: "+(i+1));
            home.roomAdder(roomName);
        }
    }
    public void addMoreRooms( SmartHome home){
        for(int i=home.getRoomsIndex(); i< home.getSizeOfRoom(); i++) {
            String roomName = getString("Enter the name of room number: " + (i + 1));
            home.roomAdder(roomName);
        }
    }

    public void createPlugs(int numberOfSmartPlugs, SmartHome home){
        for(int i=0; i<numberOfSmartPlugs; i++){
            int plugsRoomID = getInt("Using the above list, please select the room for this plug (integer only)" );
            home.plugAdder(home.getRoom(plugsRoomID-1));
        }
    }
    public void addMorePlugs( SmartHome home){
        for(int i=home.getPlugIndex(); i< home.getSizeOfPlug(); i++){
            int plugsRoomID = getInt("Using the above list, please select the room for this plug (integer only)" );
            home.plugAdder(home.getRoom(plugsRoomID-1));
        }
    }
    public void addMoreAttachedDevices(SmartHome home){
        for(int i=home.getADIndex(); i<home.getSizeOfAD();i++){
            String adName = getString("Enter the name of the attached device: ");
            home.ADAdder(adName);
        }
    }
    public void printRooms(SmartHome home){
        out("ROOMS AVAILABLE:");
        for(int i=0; i<home.getSizeOfRoom();i++){
            out(home.getRoom(i).toString());
        }
    }
    public void menuOptions(SmartHome home) {

        out("MENU OPTIONS");
        out("please select option:");
        out("1 - House level options");
        out("2 - Room level options");
        out("3 - Plug level options");
        out("4 - System options");
        out("0 - Exit");
        int optionLevel = getInt("");

        switch (optionLevel) {
            case 1:
                out("HOUSE LEVEL OPTIONS");
                out("0 - Switch all plugs off");
                out("1 - Switch all plugs on");
                out("Select an option");
                int houseLevelOption = getInt("");
                home.houseLevel(houseLevelOption);
                break;
            case 2:
                out("ROOM LEVEL OPTIONS");
                printRooms(home);
                out("Select an option");
                int roomLevelOption = getInt("");
                plugsInRoom(home,roomLevelOption);
                break;
            case 3:
                plugsOption(home);
                break;
            case 4:
                out(("SYSTEM LEVEL OPTIONS\n" +
                        "1 - add plugs\n" +
                        "2 - add attached devices\n" +
                        "3 - add rooms \n" ));
                int systemOption = getInt("Enter option: ");
                systemOption(home,systemOption);
            case 0:
                System.exit(0);
            default:
                out("please enter a valid option");

        }
    }
    public void plugsOption(SmartHome home){
        for(int i=0; i< home.getSizeOfPlug();i++){
            out(home.getPlug(i).toString());
        }
        int plugLeveOption = getInt("Please select plug (integer only)");

        out("PLUG LEVEL OPTIONS\n" +
                "1 - Switch plug off\n" +
                "2 - Switch plug on\n" +
                "3 - Change attached device\n" +
                "4 - Move plug to different room\n");
        int plugLevelMenu = getInt("Select an option");
        home.plugLevelI(plugLevelMenu,plugLeveOption);
        switch(plugLevelMenu){
            case 3:
                out("AVAILABLE DEVICE LIST OPTIONS\n" +
                        "These are standard devices attached to the smart plug, unless otherwise stated\n" +
                        "1-Lamp\n" +
                        "2-TV\n" +
                        "3-Computer\n" +
                        "4-Phone Recharger\n" +
                        "5-Heater\n");
                int plugLeveDC = getInt("Enter device to attach to smart plug (integer only)\n");
                home.plugDC(plugLeveDC,plugLeveOption);
                break;
            case 4:
                printRooms(home);
                int roomSelect = getInt("Please select a room for the device, from the list (integer only)");
                home.plugRM(roomSelect,plugLeveOption);
                break;
        }

    }

    public void plugsInRoom(SmartHome home,int roomLevelOption) {
        for (int i = 0; i < home.getSizeOfPlug(); i++) {
            if (home.getPlug(i).getRoom().getRoomId() == roomLevelOption) {
                out(home.getPlug(i).toString());
            }
        }
        out("ROOM LEVEL OPTIONS");
        out("1 - Switch all plugs off in room");
        out("2 - Switch all plugs on in room");
        out("3 - Select a plug in the room and toggle its on/off status");
        int rlOption = getInt("Select an option");
        home.roomLevel(rlOption,roomLevelOption);

    }

    public void dashBoard(SmartHome home){
        for(int i=0; i<home.getSizeOfRoom();i++){
            out(home.getRoom(i).toString());
            for(int j=0; j< home.getSizeOfPlug();j++){
                if(i+1==home.getPlug(j).getRoom().getRoomId()){
                    out(home.getPlug(j).toString());
                    out(home.getAttachedDevice(j).toString());
                }
            }
        }
    }

    public void systemOption(SmartHome home,int systemOption){
        switch(systemOption){
            case 1:
                int numberOfPlugsAdded = getInt("Enter the amount of new plugs: ");
                home.systemPlugAdder(numberOfPlugsAdded);
                printRooms(home);
                addMorePlugs(home);
                break;
            case 2:
                int numberOfAttachedDeviceAdded = getInt("Enter the amount of new devices");
                home.systemAttachedDeviceAdder(numberOfAttachedDeviceAdded);
                addMoreAttachedDevices(home);
                break;
            case 3:
                int numberOfRoomsAdded = getInt("Enter the amount of new rooms: ");
                home.systemRoomAdder(numberOfRoomsAdded);
                addMoreRooms(home);
                break;
        }

    }
}