public class TemperatureSensor {
    private String sensorId;
    private double currentTemperature;

    public double getTemperature() {
        return currentTemperature;
    }

    public boolean isTemperatureAbove(double threshold) {
        return currentTemperature > threshold;
    }
}