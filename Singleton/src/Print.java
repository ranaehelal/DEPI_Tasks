public class Print {
    public static void printSetting(Setting setting) {
        System.out.println("Setting state:");
        System.out.println("Level: " + setting.getLevel());
        System.out.println("Volume: " + setting.getVolume());
        System.out.println("Resolution: " + setting.getResolution());
    }
}

