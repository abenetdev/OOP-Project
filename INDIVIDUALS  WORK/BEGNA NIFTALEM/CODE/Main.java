public class Main {
    public static void main(String[] args) {
        // Creating a user
        User admin = new User("adminUser", "password123", "admin");

        // Creating and controlling a light
        Light light = new Light("light001", 70, "Warm White");
        light.turnOn();
        light.setBrightness(90);

        // Output status
        System.out.println("User Logged In: " + admin.login("adminUser", "password123"));
        System.out.println("Light Status: " + light.getStatus());
        System.out.println("Brightness Level: " + light.getBrightness());

        // Temperature sensor reading
        TemperatureSensor sensor = new TemperatureSensor("temp001", 26.5);
        System.out.println("Current Temperature: " + sensor.getTemperature());

        // Camera control
        SecurityCamera camera = new SecurityCamera("cam001", "1080p");
        camera.startRecording();
        System.out.println("Camera Recording: " + camera.isRecording());
    }
}