package animate;

public class PlayAudio {
    private SoundClip soundBlip;
    private SoundClip soundBlop;
    
    public void Play(){
        soundBlip = new SoundClip("media/blip.wav");
        soundBlip.open();
        soundBlop = new SoundClip("media/blop.wav");
        soundBlop.open();
    }
    public void pBlip(){
        System.out.println("Mouse has been pressed");
        soundBlip.play();
    }
    public void pBlop(){
        System.out.println("SPACE button is pressed");
        soundBlop.play();
    }

}
