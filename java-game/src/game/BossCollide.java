package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class BossCollide  implements CollisionListener {

    private Knight knight;
    GameLevel currentLevel;
    Game game;

    public BossCollide(Knight k, GameLevel level, Game game) {
        this.knight = k;
        currentLevel = level;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Enemy3) {
            knight.setLives(knight.getLives() - 1);
            knight.setHit(knight.getHit());
            if (currentLevel.death())
                game.endGame();

        }
    }
}

