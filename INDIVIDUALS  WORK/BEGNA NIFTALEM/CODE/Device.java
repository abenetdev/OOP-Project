public class Device {
    private String deviceId;
    private String deviceType;
    private boolean status;

    public Device(String deviceId, String deviceType) {
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.status = false;
    }

    public void turnOn() {
        status = true;
    }

    public void turnOff() {
        status = false;
    }

    public boolean getStatus() {
        return status;
    }
}