public class VideoSettingsTest {
    public static void main(String[] args) {
        // Create a VideoSettings object with specific settings
        VideoSettings initialSettings = new VideoSettings(50, 1.5);
        String filePath = "videoSettings.ser";

        // Print initial settings
        System.out.println("Initial Settings:");
        System.out.println("Volume Level: " + initialSettings.getVolumeLevel());
        System.out.println("Playback Speed: " + initialSettings.getPlaybackSpeed());

        // Serialize the settings to a file
        VideoSettings.serializeSettings(initialSettings, filePath);

        // Deserialize the settings from the file
        VideoSettings loadedSettings = VideoSettings.deserializeSettings(filePath);

        // Print loaded settings
        System.out.println("\nLoaded Settings:");
        System.out.println("Volume Level: " + loadedSettings.getVolumeLevel());
        System.out.println("Playback Speed: " + loadedSettings.getPlaybackSpeed());

        // Check if the settings match
        if (initialSettings.getVolumeLevel() == loadedSettings.getVolumeLevel() &&
                initialSettings.getPlaybackSpeed() == loadedSettings.getPlaybackSpeed()) {
            System.out.println("\nTest passed: The loaded settings match the initial settings.");
        } else {
            System.out.println("\nTest failed: The loaded settings do not match the initial settings.");
        }
    }
}
