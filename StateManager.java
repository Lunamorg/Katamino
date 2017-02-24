package StateManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.ArrayList;

public class StateManager {

    // CONSTANTES

    public static final int MENU_STATE = 0;
    public static final int GAME_STATE = 1;

    // ATTRIBUTS

    private List<AbstractState> stateManager;
    private int currentState;

    // CONSTRUCTEUR

    public StateManager() {
        stateManager = new ArrayList<>();
        stateManager.add(new MenuState(this));
        stateManager.add(new GameState((this)));
        currentState = MENU_STATE;
    }

    // COMMANDES

    public void setState(int state) {
        currentState = state;
        stateManager.get(currentState).init();
    }

    public void draw(Graphics g, int x, int y) {
        stateManager.get(currentState).draw(g, x, y);
    }

    public void keyPressed(int k) {
        stateManager.get(currentState).keyPressed(k);
    }

    public void keyReleased(int k) {
        stateManager.get(currentState).keyReleased(k);
    }

    public void mousePressed(int button, int x, int y) {
        stateManager.get(currentState).mousePressed(button, x, y);
    }

}
