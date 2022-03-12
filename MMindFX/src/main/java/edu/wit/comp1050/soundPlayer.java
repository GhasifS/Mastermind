package edu.wit.comp1050;

import javax.sound.sampled.*;
import java.io.File;

public class soundPlayer implements Runnable {
    @Override
    public void run() {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void playSound(String sound) {
        try {
            File musicPath = new File(sound);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            } else {
                System.out.println("Can't find file");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
