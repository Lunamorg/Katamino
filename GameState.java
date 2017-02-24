package StateManager;

import View.Board;

import java.awt.Graphics;

public class GameState extends AbstractState {

    // ATTRIBUTS

    private Board board;

    // CONSTRUCTEUR

    GameState(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public void init() {
        board = new Board();
    }

    public void draw(Graphics g, int x, int y) {
        board.draw(g);
    }

    public void keyPressed(int k) {

    }

    public void keyReleased(int k) {

    }

    public void mousePressed(int button, int x, int y) {
        System.out.println("Clic in GameState : " + x + " ; " + y);
        System.out.println("Tiles : " + x / 30 + " ; " + y / 30);
    }
}
