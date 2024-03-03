package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public abstract class GameLevel extends World {

    private Knight knight;
    private Ground ground;
    //private Platform platform;
    private Wall wall;
    private Enemy enemy;
    private Coins coin;
    //private Slope slope;

    public GameLevel(Game game) {

        knight = new Knight(this, this, game);
        //enemy = new Enemy(this);


        //make the ground

        for (float i=0; i<38; i = i + 3.25f) {
            ground = new Ground(this);
            ground.setPosition(new Vec2(-18.5f+i, -13.25f));
        }

        /*for (float i=0; i<9f; i = i + 3.25f) {
            ground = new Ground(this);
            ground.setPosition(new Vec2(16-i, -5.25f));
        }

        for (float i=0; i<10; i = i + 3.25f) {
            ground = new Ground(this);
            ground.setPosition(new Vec2(6.75f-i, 2f));
        }*/

        //make walls
        wall = new Wall(this);



        /* make platform
        Shape platformShape = new BoxShape(3.2f, 0.5f);
        BodyImage platformImage = new BodyImage("data/platform.png", 1f);
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(2f,-8f));
        platform.addImage(platformImage);
        StaticBody platform1 = new StaticBody(this,platformShape);
        platform1.setPosition(new Vec2(-10.5f,-3f));
        platform1.addImage(platformImage);*/

        // make the knight
        //knight = new Knight(this);
        //knight.setPosition(new Vec2(-10, -7));
        CoinsPickup pickup = new CoinsPickup(knight, this, game);
        knight.addCollisionListener(pickup);
        EnemyCollide collide = new EnemyCollide(knight, this, game);
        knight.addCollisionListener(collide);
        Enemy2Collide collide2 = new Enemy2Collide(knight, this, game);
        knight.addCollisionListener(collide2);
        BossCollide collide3 = new BossCollide(knight, this, game);
        knight.addCollisionListener(collide3);
        //knight.addCollisionListener(attackCollision);

        //make the enemy
        //enemy = new Enemy(this);
        //enemy.setPosition(new Vec2(14, -8));
        //enemy.setPosition(new Vec2(14, -2));
        //enemy.setPosition(new Vec2(2, 8));
        }


        /* make the coins
        for (float i=0; i<5; i = i + 1.15f) {
            coin = new Coins(this);
            coin.setPosition(new Vec2(i, -6f));
        }

        for (float i=0; i<5; i = i + 1.15f) {
            coin = new Coins(this);
            coin.setPosition(new Vec2((-8f)-i, -2.5f));
        }*/





    public Knight getKnight() {
        return knight;
    }

    //public Enemy getEnemy() {
        //return enemy;
    //}

    public Coins getCoin() {
        return coin;
    }

    public abstract boolean isComplete();
    public abstract boolean death();
    public abstract Image getBackground();
    public abstract String getLevelName();
}


