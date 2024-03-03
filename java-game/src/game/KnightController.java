package game;

import city.cs.engine.BodyImage;
import com.sun.java.accessibility.util.TopLevelWindowListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.security.Key;

public class KnightController implements KeyListener {

    private static float WALKING_SPEED = 7;
    private Knight knight;
    private Game game;

    public KnightController(Game game, Knight knight) {
        this.knight = knight;
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            knight.startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_D) {
            knight.startWalking(WALKING_SPEED);
        } else if (code == KeyEvent.VK_W) {
            knight.jump(11f);
        } else if (code == KeyEvent.VK_SPACE) {
            knight.attack();
        } else if (code == KeyEvent.VK_O) {
            game.setGameOver(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            knight.stopWalking();
            knight.stop(0);
        } else if (code == KeyEvent.VK_D) {
            knight.stopWalking();
            knight.stop(0);
        } else if (code == KeyEvent.VK_SPACE) {
            knight.stop(0);
        } else if (code == KeyEvent.VK_ESCAPE){
            game.toggleMenu();
        } else if (code == KeyEvent.VK_S)   {
            try {
                GameSaverLoader.save(game.currentLevel, "data/save.txt");
            } catch (IOException ee){
                ee.printStackTrace();
            }

        } else if (code == KeyEvent.VK_S) {

        }

    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void updateKnight(Knight newKnight){
        knight = newKnight;
    }
}
