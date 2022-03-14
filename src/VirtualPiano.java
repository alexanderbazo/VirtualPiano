import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.events.MousePressedEvent;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class VirtualPiano extends GraphicsApp {

    private static final int CANVAS_WIDTH = 1070;
    private static final int CANVAS_HEIGHT = 400;
    private static final Color BACKGROUND_COLOR = new Color(30, 30, 30);

    @Override
    public void initialize() {
        initCanvas();
        initPiano();
    }

    private void initCanvas() {
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
    }

    private void initPiano() {

    }

    @Override
    public void draw() {
        drawBackground(BACKGROUND_COLOR);
    }


    @Override
    public void onMousePressed(MousePressedEvent event) {
        super.onMousePressed(event);
        int mouseX = event.getXPos();
        int mouseY = event.getYPos();
        System.out.println("Clicked at: " + mouseX + "/" + mouseY);
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}
