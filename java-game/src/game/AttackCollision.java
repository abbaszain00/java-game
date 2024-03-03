package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class AttackCollision implements CollisionListener {

    private static SoundClip hitSound;
    Knight knight;
    GameLevel currentLevel;
    Game game;

    static {
        try {
            hitSound = new SoundClip("data/damage.wav");
            System.out.println("Loading hit sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }


    public AttackCollision(Knight knight, GameLevel level, Game game) {
        this.knight = knight;
        currentLevel = level;
        this.game = game;

    }


    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Enemy) {
            collisionEvent.getOtherBody().destroy();
            hitSound.play();
            knight.setScore(knight.getScore() + 10);
            if (currentLevel.isComplete())
                game.goToNextLevel();


        }
        if (collisionEvent.getOtherBody() instanceof Enemy2) {
            collisionEvent.getOtherBody().destroy();
            hitSound.play();
            knight.setScore(knight.getScore() + 10);
            if (currentLevel.isComplete())
                game.goToNextLevel();

        }
        if (collisionEvent.getOtherBody() instanceof Enemy3) {
            collisionEvent.getOtherBody().destroy();
            hitSound.play();
            knight.setScore(knight.getScore() + 10);
            if (currentLevel.isComplete())
                game.goToNextLevel();

        }
    }
}
