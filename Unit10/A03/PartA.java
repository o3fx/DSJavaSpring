import javax.sound.sampled.LineUnavailableException;
import sound.ToneGenerator;
import sound.ToneGenerator.Note;


public class PartA {
    public static void main(String[] args) throws LineUnavailableException {
        ToneGenerator tg = new ToneGenerator();
        tg.init();
        tg.play(Note.C4, 200);
        tg.play(Note.REST, 50);
        tg.play(Note.C4, 200);
        tg.play(Note.REST, 50);
        tg.play(Note.G4, 200);
        tg.play(Note.REST, 50);
        tg.play(Note.G4, 200);
        tg.play(Note.REST, 50);
        tg.play(Note.A4, 200);
        tg.play(Note.REST, 50);
        tg.play(Note.A4, 200);
        tg.play(Note.REST, 50);
        tg.play(Note.G4, 400);
        tg.play(Note.REST, 50);
        tg.close();
    }
}
