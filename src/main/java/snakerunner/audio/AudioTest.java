package snakerunner.audio;

import java.net.URL;

public class AudioTest {
    public static void main(String[] args) {
        String fileName = "eat.wav";

        URL soundURL = AudioPlayer.class.getResource("/" + fileName);
        System.out.println("URL: " + soundURL);

        if (soundURL != null) {
            AudioPlayer.playSound(fileName);
        } else {
            System.out.println("File non trovato nel classpath!");
        }

        try { Thread.sleep(2000); } catch (InterruptedException e) {}
    }
}
