package Model;

public class Coord {

    // ATTRIBUTS

    private int x;
    private int y;

    // CONSTRUCTEUR

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // REQUETES

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        Coord c = (Coord) o;
        return this.getX() == c.getX() && this.getY() == c.getY();
    }

    public int hashCode() {
        return (getY() << 3) + getX();
    }

}
