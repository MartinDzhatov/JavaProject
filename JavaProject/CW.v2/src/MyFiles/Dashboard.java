package MyFiles;

public class Dashboard {

    public static void main(String[] args) {

        // BUILD CONSOLE HELPER OBJECT
        ConsoleHelper console = new ConsoleHelper();

        int numberOfRooms = console.getInt("Please enter the number of Rooms inside the property: ");
        int numberOfSmartPlugs = console.getInt("Please enter the number of Smart plugs inside the property: ");

        //BUILD SMART HOME OBJECT
        SmartHome home = new SmartHome(numberOfSmartPlugs,numberOfRooms);

        // POPULATE SMART HOME
        console.populateSmartHome(home);

        while(true){
            // DISPLAY DASHBOARD
            // DISPLAY OPTIONS
            // PROCESS OPTIONS/ACTIONS

            console.dashBoard(home);
            console.menuOptions(home);

            // request update options from console

        }
    }
}
