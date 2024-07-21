public class Main {
    public static void main(String[] args) {
        DVDplayer dvdPlayer = new DVDplayer();
        Projector projector = new Projector();
        LightSystem lightSystem = new LightSystem();
        SoundSystem soundSystem = new SoundSystem();

        Screen screen = new Screen();


        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, projector, lightSystem, screen, soundSystem);

        System.out.println("-----------------------------------------------");

        homeTheater.watchMovie(100,"see",720,20);


        System.out.println("-----------------------------------------------");
        homeTheater.endMovie();

    }
}