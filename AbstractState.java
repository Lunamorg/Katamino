package StateManager;

import java.awt.*;
import java.awt.event.KeyListener;

public abstract class AbstractState {

    StateManager stateManager;

    protected abstract void init();
    protected abstract void draw(Graphics g, int x, int y);
    protected abstract void keyPressed(int k);
    protected abstract void keyReleased(int k);
    protected abstract void mousePressed(int button, int x, int y);
}
