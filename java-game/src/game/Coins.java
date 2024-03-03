package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLOutput;

public class Coins extends StaticBody {

    private static final Shape coinsShape = new CircleShape(0.5f);

    private static final BodyImage coinsImage =
            new BodyImage("data/coin.png", 2f);

    private static SoundClip coinSound;

    static {
        try{
            coinSound = new SoundClip("data/sound1.wav");
            System.out.println("Loading coin sound");
        } catch (UnsupportedAudioFileException |IOException |LineUnavailableException e) {
            System.out.println(e);
        }
    }


    public Coins(World w) {
        super(w, coinsShape);
        addImage(coinsImage);
    }

    @Override
    public void destroy() {
        coinSound.play();
        super.destroy();
    }

}