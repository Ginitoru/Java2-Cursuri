package media;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SoundPlay2 {

//ptrneu mpr file
   static  String soundFile = "./src/main/resources/sound/123.mp3";

    public static void playMusic(){

        try {
            FileInputStream file = new FileInputStream(soundFile);
            Player player = new Player(file);
            player.play();
            System.out.println(123);

        } catch (FileNotFoundException |JavaLayerException e) {
            e.printStackTrace();

        }


    }
}
