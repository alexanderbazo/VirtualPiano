package piano.keys;

import de.mi.ur.midi.Note;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.Rectangle;
import utils.Config;

public class Key {

    private final Rectangle body;
    private final Note note;
    private final KeyListener listener;

    public Key(int x, int y, Note note, KeyListener listener) {
        this.body = createBody(x, y);
        this.note = note;
        this.listener = listener;
    }

    protected Rectangle createBody(int x, int y) {
        return new Rectangle(x, y, Config.KEY_WIDTH, Config.KEY_HEIGHT, Colors.WHITE);
    }

    protected Rectangle getBody() {
        return this.body;
    }

    protected KeyListener getListener() {
        return this.listener;
    }

    protected Note getNote() {
        return this.note;
    }

    public void draw() {
        body.draw();
    }

    public void handleMouseClick(int mouseX, int mouseY) {
        if(body.hitTest(mouseX, mouseY) && mouseY > this.body.getYPos() + Config.KEY_HEIGHT/2) {
            listener.onKeyPressed(note);
        }
    }
}
