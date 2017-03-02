package View;

import StateManager.StateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JComponent {

    // CONSTANTES

    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    // ATTRIBUTS

    private StateManager stateManager;

    // CONSTRUCTEUR

    GamePanel() {
        super();
        createModel();
        createView();
        createController();
    }

    private void createView() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    private void createModel() {
        stateManager = new StateManager();
    }

    private void createController() {
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                stateManager.mousePressed(e.getButton(), e.getX(), e.getY());
                repaint();
            }

            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                stateManager.mouseReleased(e.getButton(), e.getX(), e.getY());
                repaint();
            }
        });
    }

    public void paintComponent(Graphics g) {
        stateManager.draw(g, 0, 0);
    }

    void keyPressed(int k) {
        stateManager.keyPressed(k);
        repaint();
    }

}
