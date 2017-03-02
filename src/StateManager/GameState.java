package StateManager;

import Audio.Audio;
import View.Board;

import java.awt.Graphics;

public class GameState extends AbstractState {

    // ATTRIBUTS

    private Board board;
    private Audio selectedClic;

    // CONSTRUCTEUR

    GameState(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public void init() {
        board = new Board();
        selectedClic = new Audio("click.wav");
    }

    public void draw(Graphics g, int x, int y) {
        board.draw(g);
    }

    public void mousePressed(int button, int x, int y) {
        board.mousePressed(button, x, y);
        selectedClic.play();
    }

    public void mouseReleased(int button, int x, int y) {
        board.mouseReleased(button, x, y);
        selectedClic.stop();
    }

    public void keyPressed(int key) {
        board.keyPressed(key);
    }
}
