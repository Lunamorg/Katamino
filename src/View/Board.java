package View;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Board {

    private static final int TILES_SIZE = 30;
    private static final int MARGIN = 10;
    private static final int MIN_POS_CROSS_BAR = 10;

    // ATTRIBUTS

    private BufferedImage background;
    private BufferedImage board;
    private BufferedImage crossBar;
    private int posCrossBar;

    // CONSTRUCTEUR

    public Board() {
        try {
            background = ImageIO.read(new File("Resources/table.jpg"));
            board = ImageIO.read(new File("Resources/Board.png"));
            crossBar = ImageIO.read(new File("Resources/CrossBar.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        posCrossBar = MIN_POS_CROSS_BAR;
    }

    // COMMANDES

    public void draw(Graphics g) {
        g.clearRect(0, 0 , GamePanel.WIDTH, GamePanel.HEIGHT);
        g.drawImage(background, 0, 0, null);
        g.drawImage(board, 6 * TILES_SIZE + MARGIN, 6 * TILES_SIZE, null);
        g.drawImage(crossBar, posCrossBar * TILES_SIZE + MARGIN, 7 * TILES_SIZE, null);

        for (int i = 0; i < GamePanel.HEIGHT; i += 30) {
            g.drawLine(0, i, GamePanel.WIDTH, i);
        }
        for (int i = MARGIN; i < GamePanel.WIDTH; i += 30) {
            g.drawLine(i, 0, i, 600);
        }
        //g.drawImage(board, 0, 0, null);


    }

}
