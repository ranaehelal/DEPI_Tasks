// Adapter Class*
//to make the old interface works on the new interface
class CassetteAdapter implements MediaPlayer {
    private final Player player;

    CassetteAdapter(Player player) {
        this.player = player;
    }

    public void playMedia(String oldTape) {
        player.playCassette(oldTape);
    }


}
