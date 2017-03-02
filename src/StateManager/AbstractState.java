package StateManager;

import java.awt.*;
import java.awt.event.KeyListener;

public abstract class AbstractState {

    StateManager stateManager;

    protected abstract void init();
    protected abstract void draw(Graphics g, int x, int y);

    protected void keyPressed(int k) {

    }

    protected void keyReleased(int k) {

    }

    protected void mousePressed(int button, int x, int y) {

    }

    protected void mouseReleased(int button, int x, int y) {

    }
}
