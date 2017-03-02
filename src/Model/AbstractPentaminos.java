package Model;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class AbstractPentaminos {

    // ATTRIBUTS

    private Set<Coord> coords;
    private Color color;

    AbstractPentaminos(Set<Coord> coords, Color color) {
        this.color = color;
        this.coords = new HashSet<>(coords);
    }
}
