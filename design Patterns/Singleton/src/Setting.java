public class Setting {
    private static volatile Setting instance;
    private String level;
    private int volume;
    private String resolution;

    private Setting() {
        // Default values
        this.level = "easy";
        this.volume = 100;
        this.resolution = "1500*1500";
    }

    public static Setting getInstance() {
        Setting result = instance;

        if (result == null) {
            synchronized (Setting.class) {
                if (result == null) {
                    instance =result= new Setting();
                }
            }
        }
        return instance;
    }

    public void setLevel(String level) {
        synchronized (Setting.class) {
            this.level = level;
        }
    }

    public void setVolume(int volume) {
        synchronized (Setting.class) {
            this.volume = volume;
        }
    }

    public void setResolution(String resolution) {
        synchronized (Setting.class) {
            this.resolution = resolution;
        }
    }

    public String getLevel() {
        return level;
    }

    public int getVolume() {
        return volume;
    }

    public String getResolution() {
        return resolution;
    }
}

