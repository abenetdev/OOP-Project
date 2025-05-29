public class SecurityCamera {
    private String cameraId;
    private String resolution;
    private boolean recording = false;

    public SecurityCamera(String cameraId, String resolution) {
        this.cameraId = cameraId;
        this.resolution = resolution;
    }

    public boolean isRecording() {
        return recording;
    }

    public void startRecording() {
        recording = true;
    }

    public void stopRecording() {
        recording = false;
    }
}