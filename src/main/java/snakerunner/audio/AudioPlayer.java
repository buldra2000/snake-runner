package snakerunner.audio;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {

    private static boolean soundEnable = true;

    public AudioPlayer(){}

    public static void setSoundEnabled(boolean enable){
        soundEnable = enable;
    }

    public static boolean isSoundEnable() {
        return soundEnable;
    }

    public static void playSound(String fileName){

        if (!soundEnable) {
            return;
        }

        try {
            URL soundURL = AudioPlayer.class.getResource("/" + fileName);
            System.out.println("URL: " + soundURL);

            if (soundURL == null) {
                System.out.println("Sound not found.");
                return;
            }

            AudioInputStream AudioStream = AudioSystem.getAudioInputStream(soundURL);
            Clip clip = AudioSystem.getClip();
            clip.open(AudioStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("Error playing sound.");
            e.printStackTrace();
        }
    }
}
