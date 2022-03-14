package piano;

import de.mi.ur.midi.Instrument;
import de.mi.ur.midi.Note;
import de.mi.ur.midi.Synthesizer;
import piano.keys.BlackKey;
import piano.keys.Key;
import piano.keys.KeyListener;
import utils.Config;

import javax.sound.midi.MidiUnavailableException;
import java.util.ArrayList;
import java.util.Comparator;

public class Piano {

    private static final Instrument DEFAULT_INSTRUMENT = Instrument.PIANO;

    private Synthesizer synthesizer;

    public Piano() {
        try {
            synthesizer = new Synthesizer();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
        synthesizer.setInstrument(DEFAULT_INSTRUMENT);
    }

    public void playNote(Note note) {
        int octave = Config.DEFAULT_OCTAVE + (note.ordinal() / 12);
        try {
            synthesizer.playNote(note, Config.DEFAULT_VELOCITY, octave);
        } catch (Synthesizer.NoteOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Key> getKeysForListener(int startX, int startY, KeyListener listener) {
        ArrayList<Key> keys = new ArrayList<>();
        int keyXPos = startX;
        for (Note note : Note.values()) {
            if (note.name().contains("SHARP")) {
                keys.add(new BlackKey(keyXPos, startY, note, listener));
            } else {
                keys.add(new Key(keyXPos, startY, note, listener));
                keyXPos += Config.KEY_WIDTH + Config.KEY_MARGIN;
            }
        }
        keys.sort(new Comparator<Key>() {
            @Override
            public int compare(Key key1, Key key2) {
                if (key1 instanceof BlackKey) {
                    return 1;
                }
                if (key2 instanceof BlackKey) {
                    return -1;
                }
                return 0;
            }
        });
        return keys;
    }
}
