package View;

import Model.Coord;
import Model.Pentaminos;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;

public class Board {

    private static final int TILES_SIZE = 30;
    public static final int MARGIN = 10;
    private static final int MIN_POS_CROSS_BAR = 10;
    private static final int MAX_POS_CROSS_BAR = 19;

    // ATTRIBUTS

    private BufferedImage background;
    private BufferedImage board;
    private BufferedImage crossBar;
    private Set<Coord> boardCoords;
    private int posCrossBar;

    private Pentaminos penta1;
    private Pentaminos penta2;
    private Pentaminos penta3;
    private Pentaminos penta4;
    private Pentaminos penta5;
    private Pentaminos penta6;
    private Pentaminos penta7;
    private Pentaminos penta8;
    private Pentaminos penta9;
    private Pentaminos penta10;
    private Pentaminos penta11;
    private Pentaminos penta12;

    private Pentaminos selectedPentaminos;

    // CONSTRUCTEUR

    public Board() {
        try {
            background = ImageIO.read(new File("Resources/table.jpg"));
            board = ImageIO.read(new File("Resources/Board.png"));
            crossBar = ImageIO.read(new File("Resources/CrossBar.png"));
            penta1 = new Pentaminos("Resources/Penta_1.png");
            penta2 = new Pentaminos("Resources/Penta_2.png");
            penta3 = new Pentaminos("Resources/Penta_3.png");
            penta4 = new Pentaminos("Resources/Penta_4.png");
            penta5 = new Pentaminos("Resources/Penta_5.png");
            penta6 = new Pentaminos("Resources/Penta_6.png");
            penta7 = new Pentaminos("Resources/Penta_7.png");
            penta8 = new Pentaminos("Resources/Penta_8.png");
            penta9 = new Pentaminos("Resources/Penta_9.png");
            penta10 = new Pentaminos("Resources/Penta_10.png");
            penta11 = new Pentaminos("Resources/Penta_11.png");
            penta12 = new Pentaminos("Resources/Penta_12.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        boardCoords = new HashSet<>();
        init();
        initPentaminos();
    }

    // REQUETES

    public Set<Coord> getBoardCoords() {
        return boardCoords;
    }

    public boolean isValidBoardCoord(Coord c) {
        return  c != null && boardCoords.contains(c);
    }

    // COMMANDES

    public void draw(Graphics g) {
        g.clearRect(0, 0 , GamePanel.WIDTH, GamePanel.HEIGHT);
        g.drawImage(background, 0, 0, null);
        g.drawImage(board, 6 * TILES_SIZE + MARGIN, 6 * TILES_SIZE, null);
        g.drawImage(crossBar, posCrossBar * TILES_SIZE + MARGIN, 7 * TILES_SIZE, null);
        penta1.draw(g);
        penta2.draw(g);
        penta3.draw(g);
        penta4.draw(g);
        penta5.draw(g);
        penta6.draw(g);
        penta7.draw(g);
        penta8.draw(g);
        penta9.draw(g);
        penta10.draw(g);
        penta11.draw(g);
        penta12.draw(g);
    }

    /**
     * Augmente la taille du plateau de jeu.
     */
    public void moveUpCrossBar() {
        if (posCrossBar == MAX_POS_CROSS_BAR) {
            return;
        }

        for (int i = 7; i < 12; ++i) {
            boardCoords.add(new Coord(posCrossBar, i));
        }
        posCrossBar += 1;
    }

    /**
     * Diminue la taille du plateau de jeu.
     */
    public void moveDownCrossBar() {
        if (posCrossBar == MIN_POS_CROSS_BAR) {
            return;
        }

        for (int i = 7; i < 12; ++i) {
            boardCoords.remove(new Coord(posCrossBar, i));
        }

        posCrossBar -= 1;
    }

    public void mousePressed(int button, int x, int y) {
        System.out.println("Clic in board " + x + " ; " + y);

        int xtiles = (x - MARGIN) / TILES_SIZE;
        int yTiles = y / TILES_SIZE;

        for (Coord c : penta2.getCoords()) {
            if (c.getX() == xtiles && c.getY() == yTiles) {
                System.out.println("Penta2 ici");
                selectedPentaminos = penta2;
            }
        }
    }

    public void mouseReleased(int button, int x, int y) {
        System.out.println("Mouse relacher");
        if (selectedPentaminos != null) {
            selectedPentaminos.setPosition(x, y);
        }
    }

    public void keyPressed(int key) {
        switch (key) {
            case VK_LEFT:
                moveDownCrossBar();
                break;
            case VK_RIGHT:
                moveUpCrossBar();
                break;
        }
    }

    // OUTILS

    private void init() {
        boardCoords.clear();

        boardCoords.add(new Coord(7, 7));
        boardCoords.add(new Coord(7, 8));
        boardCoords.add(new Coord(7, 9));
        boardCoords.add(new Coord(7, 10));
        boardCoords.add(new Coord(7, 11));

        boardCoords.add(new Coord(8, 7));
        boardCoords.add(new Coord(8, 8));
        boardCoords.add(new Coord(8, 9));
        boardCoords.add(new Coord(8, 10));
        boardCoords.add(new Coord(8, 11));

        boardCoords.add(new Coord(9, 7));
        boardCoords.add(new Coord(9, 8));
        boardCoords.add(new Coord(9, 9));
        boardCoords.add(new Coord(9, 10));
        boardCoords.add(new Coord(9, 11));

        posCrossBar = MIN_POS_CROSS_BAR;
    }

    private void initPentaminos() {
        Set<Pentaminos> set = new HashSet<>();

        Set<Coord> c = new HashSet<>();
        c.add(new Coord(2, 5));
        c.add(new Coord(2, 6));
        c.add(new Coord(2, 7));
        c.add(new Coord(2, 8));
        c.add(new Coord(2, 9));
        penta1.setCoords(c);
        penta1.setPosition(2 * TILES_SIZE + MARGIN, 5 * TILES_SIZE);
        set.add(penta1);

        c = new HashSet<>();
        c.add(new Coord(6, 15));
        c.add(new Coord(6, 16));
        c.add(new Coord(6, 17));
        c.add(new Coord(6, 18));
        c.add(new Coord(7, 18));
        penta2.setCoords(c);
        penta2.setPosition(6 * TILES_SIZE + MARGIN, 15 * TILES_SIZE);
        set.add(penta2);

        c = new HashSet<>();
        c.add(new Coord(11, 15));
        c.add(new Coord(11, 16));
        c.add(new Coord(10, 16));
        c.add(new Coord(11, 17));
        c.add(new Coord(11, 18));
        penta3.setCoords(c);
        penta3.setPosition(10 * TILES_SIZE + MARGIN, 15 * TILES_SIZE);
        set.add(penta3);

        c = new HashSet<>();
        c.add(new Coord(15, 15));
        c.add(new Coord(15, 16));
        c.add(new Coord(15, 17));
        c.add(new Coord(14, 17));
        c.add(new Coord(14, 18));
        penta4.setCoords(c);
        penta4.setPosition(14 * TILES_SIZE + MARGIN, 15 * TILES_SIZE);
        set.add(penta4);

        c = new HashSet<>();
        c.add(new Coord(18, 15));
        c.add(new Coord(18, 16));
        c.add(new Coord(18, 17));
        c.add(new Coord(19, 17));
        c.add(new Coord(20, 17));
        penta5.setCoords(c);
        penta5.setPosition(18 * TILES_SIZE + MARGIN, 15 * TILES_SIZE);
        set.add(penta5);

        c = new HashSet<>();
        c.add(new Coord(23, 11));
        c.add(new Coord(24, 11));
        c.add(new Coord(23, 12));
        c.add(new Coord(24, 12));
        c.add(new Coord(23, 13));
        penta6.setCoords(c);
        penta6.setPosition(23 * TILES_SIZE + MARGIN, 11 * TILES_SIZE);
        set.add(penta6);

        c = new HashSet<>();
        c.add(new Coord(2, 11));
        c.add(new Coord(2, 12));
        c.add(new Coord(3, 12));
        c.add(new Coord(4, 12));
        c.add(new Coord(4, 11));
        penta7.setCoords(c);
        penta7.setPosition(2 * TILES_SIZE + MARGIN, 11 * TILES_SIZE);
        set.add(penta7);

        c = new HashSet<>();
        c.add(new Coord(18, 2));
        c.add(new Coord(19, 2));
        c.add(new Coord(19, 3));
        c.add(new Coord(19, 4));
        c.add(new Coord(20, 4));
        penta8.setCoords(c);
        penta8.setPosition(18 * TILES_SIZE + MARGIN, 2 * TILES_SIZE);
        set.add(penta8);

        c = new HashSet<>();
        c.add(new Coord(14, 3));
        c.add(new Coord(15, 2));
        c.add(new Coord(16, 2));
        c.add(new Coord(15, 3));
        c.add(new Coord(15, 4));
        penta9.setCoords(c);
        penta9.setPosition(14 * TILES_SIZE + MARGIN, 2 * TILES_SIZE);
        set.add(penta9);

        c = new HashSet<>();
        c.add(new Coord(10, 2));
        c.add(new Coord(11, 2));
        c.add(new Coord(12, 2));
        c.add(new Coord(11, 3));
        c.add(new Coord(11, 4));
        penta10.setCoords(c);
        penta10.setPosition(10 * TILES_SIZE + MARGIN, 2 * TILES_SIZE);
        set.add(penta10);

        c = new HashSet<>();
        c.add(new Coord(6, 2));
        c.add(new Coord(6, 3));
        c.add(new Coord(7, 3));
        c.add(new Coord(7, 4));
        c.add(new Coord(8, 4));
        penta11.setCoords(c);
        penta11.setPosition(6 * TILES_SIZE + MARGIN, 2 * TILES_SIZE);
        set.add(penta11);

        c = new HashSet<>();
        c.add(new Coord(22, 6));
        c.add(new Coord(23, 6));
        c.add(new Coord(24, 6));
        c.add(new Coord(23, 5));
        c.add(new Coord(23, 7));
        penta12.setCoords(c);
        penta12.setPosition(22 * TILES_SIZE + MARGIN, 5 * TILES_SIZE);
        set.add(penta12);
    }

    /**
     * Permet d'afficher la grille de tiles.
     */
    private void drawGrid(Graphics g) {
        for (int i = 0; i < GamePanel.HEIGHT; i += 30) {
            g.drawLine(0, i, GamePanel.WIDTH, i);
        }
        for (int i = MARGIN; i < GamePanel.WIDTH; i += 30) {
            g.drawLine(i, 0, i, 600);
        }
    }
}
