public class HomeTheaterFacade {
    private DVDplayer dvdplayer;
    private Projector projector;

    private LightSystem lightSystem;
    private Screen screen;
    private SoundSystem soundSystem;
    public HomeTheaterFacade(DVDplayer dvdplayer, Projector projector, LightSystem lightSystem, Screen screen, SoundSystem soundSystem) {
        this.dvdplayer = dvdplayer;
        this.projector = projector;
        this.lightSystem = lightSystem;
        this.screen = screen;
        this.soundSystem = soundSystem;
    }
    void watchMovie (int soundLevel ,String movieName,int resolutionLevel,int lightLevel){
        System.out.println("Start Watching movie ..");
        lightSystem.on();
        lightSystem.setLightLevel(lightLevel);
       projector.on();
       projector.setResolution(resolutionLevel);
        soundSystem.on();
        soundSystem.setVolume(soundLevel);
       dvdplayer.on();
       dvdplayer.play(movieName);

    }
    public void endMovie() {
        System.out.println("ending movie ...");
        lightSystem.off();
        dvdplayer.off();
        soundSystem.off();
        projector.off();

    }
}
