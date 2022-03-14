package piano.keys;

import de.mi.ur.midi.Note;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.Rectangle;
import utils.Config;

public class BlackKey extends Key {

    public BlackKey(int x, int y, Note note, KeyListener listener) {
        super(x, y, note, listener);
    }

    @Override
    protected Rectangle createBody(int x, int y) {
        return new Rectangle(x - Config.KEY_WIDTH / 2 - Config.KEY_MARGIN / 2, y, Config.KEY_WIDTH, Config.KEY_HEIGHT / 2, Colors.BLACK);
    }

    @Override
    public void handleMouseClick(int mouseX, int mouseY) {
        if (getBody().hitTest(mouseX, mouseY)) {
            getListener().onKeyPressed(getNote());
        }
    }
}
