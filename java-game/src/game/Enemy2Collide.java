package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class Enemy2Collide  implements CollisionListener {

    private Knight knight;
    GameLevel currentLevel;
    Game game;

    public Enemy2Collide(Knight k, GameLevel level, Game game) {
        this.knight = k;
        currentLevel = level;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Enemy2) {
            knight.setLives(knight.getLives() - 1);
            knight.setHit(knight.getHit());
            if (currentLevel.death())
                game.endGame();

        }
    }
}

