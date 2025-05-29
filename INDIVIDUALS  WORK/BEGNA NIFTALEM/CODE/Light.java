public class Light {
    private String lightId;
    private int brightness;
    private String color;
    private boolean status;

    public void turnOn() {
        status = true;
    }

    public void turnOff() {
        status = false;
    }

    public void setBrightness(int level) {
        brightness = level;
    }
}