package View;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
