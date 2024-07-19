public class Main {
    public static void main(String[] args) {
        // use old interface
        Player cassettePlayer = new Cassette();
        cassettePlayer.playCassette("Old Cassette Tape");

        // Using new interface
        MediaPlayer mp3Player = new Mp3();
        mp3Player.playMedia("New MP3 Tape");

        // Using  adapter to play old interface through the new interface
        MediaPlayer adaptedPlayer = new CassetteAdapter(cassettePlayer);
        adaptedPlayer.playMedia("Adapted Cassette Tape");


    }
}


