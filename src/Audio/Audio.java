package Audio;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;

public class Audio {

    // ATTRIBUTS

    private String path;
    private Clip clip;

    // CONSTRUCTEUR

    public Audio(String resource) {
        this.path = resource;
        createAudio();
    }

    // COMMANDES

    public void play() {
        if (clip.isActive()) {
            clip.stop();
        }
        reset();
        clip.loop(0);
    }

    public void stop() {
        clip.stop();
        clip.setFramePosition(0);
    }

    public void reset() {
        clip.setFramePosition(0);
    }

    // OUTILS

    private void createAudio() {
        InputStream buffer = getBufferedInputStream();
        AudioInputStream audioStream;
        try {
            audioStream = AudioSystem.getAudioInputStream(buffer);
            if (audioStream.markSupported()) {
                audioStream.mark(Integer.MAX_VALUE);
            }
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            if (AudioSystem.isLineSupported(info)) {
                clip = (Clip) AudioSystem.getLine(info);
                clip.open(audioStream);
            }
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            System.err.println("Audio file unsupported : " + path);
        } catch (IOException e) {
            System.err.println("Error reading file : " + path);
        }

    }

    private BufferedInputStream getBufferedInputStream() {
        InputStream in = getClass().getResourceAsStream(path);
        if (in == null) {
            System.err.println("Error loading music : " + path);
            System.exit(1);
        }
        return new BufferedInputStream(in);
    }

}