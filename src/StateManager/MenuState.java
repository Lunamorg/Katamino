package StateManager;

import Audio.Audio;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.event.KeyEvent.VK_ENTER;

public class MenuState extends AbstractState {

    // ATTRIBUTS

    private BufferedImage image;
    private Audio audio;

    // CONSTRUCTEUR

    MenuState(StateManager stateManager) {
        this.stateManager = stateManager;
        init();
    }

    // COMMANDES

    public void init() {
        try {
            image = ImageIO.read(new File("Resources/Intro.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        audio = new Audio("intro.wav");
        audio.play();
    }

    public void draw(Graphics g, int x, int y) {
        g.drawImage(image, x, y, null);
    }

    public void keyPressed(int k) {
        switch(k) {
            case VK_ENTER:
                audio.stop();
                stateManager.setState(StateManager.GAME_STATE);
                break;
        }
    }
}
