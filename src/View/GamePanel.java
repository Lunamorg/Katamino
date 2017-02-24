package View;

import StateManager.StateManager;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel {

    // CONSTANTES

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    // ATTRIBUTS

    private StateManager stateManager;

    // CONSTRUCTEUR

    GamePanel() {
        super();
        createModel();
        createView();
    }

    private void createView() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    private void createModel() {
        stateManager = new StateManager();
    }

    public void paintComponent(Graphics g) {
        stateManager.draw(g, 0, 0);
    }

    public void keyPressed(int k) {
        stateManager.keyPressed(k);
        repaint();
    }

    void keyReleased(int k) {

    }

    void mousePressed(int button, int x, int y) {
        System.out.println("Pressed in Game Panel");
        stateManager.mousePressed(button, x, y);
    }


}
