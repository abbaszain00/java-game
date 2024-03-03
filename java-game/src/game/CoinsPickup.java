package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class CoinsPickup  implements CollisionListener {

    private Knight knight;
    GameLevel currentLevel;
    Game game;
    public CoinsPickup(Knight k, GameLevel level, Game game) {
        this.knight = k;
        currentLevel = level;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Coins) {
            knight.setCoins(knight.getCoins()+1 );
            e.getOtherBody().destroy();
            if (currentLevel.isComplete())
                game.goToNextLevel();
        }
    }
}
