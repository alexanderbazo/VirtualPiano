package piano.keys;

import de.mi.ur.midi.Note;

public interface KeyListener {

    void onKeyPressed(Note note);

}
