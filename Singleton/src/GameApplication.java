public class GameApplication {
    public static void main(String[] args) {

        Setting setting1 = Setting.getInstance();
        Print.printSetting(setting1);
        System.out.println("------------------------------------------------");
        // Update the settings
        setting1.setLevel("hard");
        setting1.setVolume(95);
        setting1.setResolution("1920*1080");

        Print.printSetting(setting1);
        System.out.println("------------------------------------------------");


        // Verifying that both setting1 and setting2 are the same instance
        Setting setting2 = Setting.getInstance();
        Print.printSetting(setting2);

        System.out.println(setting2 == setting1);

    }
}
