package MyFiles;

public class AttachedDevice {
    private String deviceName;
    private int deviceID;

    //Constructor
    public AttachedDevice(String deviceName, int deviceID) {
        this.deviceName = deviceName;
        this.deviceID = deviceID;
    }
    public AttachedDevice(){

    }
    //Getter and Setter methods

    public String getDeviceName() {
        return deviceName;
    }
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getDeviceID() {
        return deviceID;
    }
    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }

    //Display

    @Override
    public String toString() {
        return "Device Name: " + deviceName + "| Device ID: " + deviceID + '|';
    }
}
