package Model;

import View.Board;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Pentaminos {

    // ATTRIBUTS

    /**
     * Les différentes coordonnées du pentaminos.
     */
    private Set<Coord> coords;
    /**
     * La couleur du pentaminos.
     */
    private BufferedImage image;

    /**
     * La position de la pieces à l'écran.
     */
    private int x;
    private int y;

    // CONSTRUCTEUR

    public Pentaminos(String pathname) {
        try {
            image = ImageIO.read(new File(pathname));
        } catch (IOException e) {
            e.printStackTrace();
        }
        coords = new HashSet<>();
        coords.add(new Coord(0, 0));
        coords.add(new Coord(0, 1));
        coords.add(new Coord(0, 2));
        coords.add(new Coord(0, 3));
        coords.add(new Coord(1, 3));
        x = 10;
        y = 0;
    }

    // REQUETES

    /**
     * Renvoie l'ensemble des coordonnées des tiles associées à la piece.
     */
    public Set<Coord> getCoords() {
        return coords;
    }

    public Pentaminos getPentaminos(Coord coord) {
        if (coord == null) {
            throw new AssertionError("Error in getPentaminos");
        }

        for (Coord c : coords) {
            if (c.equals(coord)) {
                return this;
            }
        }
        return null;
    }

    // COMMANDES

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setCoords(Set<Coord> s) {
        this.coords = new HashSet<>(s);
    }

    /**
     * Dessine le pentaminos à l'écran.
     */
    public void draw(Graphics g) {
        g.drawImage(image, x, y, null);
    }

    public void leftRotate() {
        Set<Coord> s = new HashSet<>();

        for (Coord c : getCoords()) {
            int x = c.getY();
            s.add(new Coord(x, y));
        }

        coords = s;
    }

    public void rightRotate() {
        Set<Coord> s = new HashSet<>();

        for (Coord c : getCoords()) {
            int y = c.getX();
            s.add(new Coord(x, y));
        }

        coords = new HashSet<>(s);
        //getTexture().rightRotate();
    }

    public void transposed() {
        //getTexture().transposed();
    }

    public void printCoords() {
        for (Coord c : getCoords()) {
            System.out.println(c.toString());
        }
    }
}
