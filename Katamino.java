package View;

import StateManager.StateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Katamino {

    // ATTRIBUTS

    private JFrame mainFrame;
    private GamePanel gamePanel;

    // CONSTRUCTEUR

    private Katamino() {
        createView();
        placeComponents();
        createController();
    }

    // COMMANDE

    private void display() {
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    // OUTILS

    private void createView() {
        mainFrame = new JFrame("Katamino");
    }

    private void placeComponents() {
        gamePanel = new GamePanel();
        mainFrame.add(gamePanel);
    }

    private void createController() {
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                gamePanel.keyPressed(e.getKeyCode());
            }

            public void keyReleased(KeyEvent e) {
                gamePanel.keyReleased(e.getKeyCode());
            }
        });

        mainFrame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                gamePanel.mousePressed(e.getButton(), e.getX(), e.getY());
            }
        });
    }

    // POINT D'ENTREE

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Katamino().display();
            }
        });
    }


}
