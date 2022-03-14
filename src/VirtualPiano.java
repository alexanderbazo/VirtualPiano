import de.mi.ur.midi.Note;
import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.events.MousePressedEvent;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;
import piano.Piano;
import piano.keys.Key;
import piano.keys.KeyListener;
import utils.Config;

import java.util.ArrayList;

public class VirtualPiano extends GraphicsApp implements KeyListener {

    private Piano piano;
    private ArrayList<Key> keys;

    @Override
    public void initialize() {
        setCanvasSize(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
        piano = new Piano();
        keys = Piano.getKeysForListener(Config.KEY_MARGIN, 0, this);
    }

    @Override
    public void draw() {
        drawBackground(Config.BACKGROUND_COLOR);
        for (Key key : keys) {
            key.draw();
        }
    }

    @Override
    public void onMousePressed(MousePressedEvent event) {
        super.onMousePressed(event);
        for (Key key : keys) {
            key.handleMouseClick(event.getXPos(), event.getYPos());
        }
    }

    @Override
    public void onKeyPressed(Note note) {
        piano.playNote(note);
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }

}
