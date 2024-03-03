package game;

import city.cs.engine.*;
import org.jbox2d.common.Timer;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.geom.RectangularShape;
import java.io.IOException;

public class Knight extends Walker {
    private static final Shape knightShape = new PolygonShape(0.0f, -0.17f, 0.51f, -0.76f, 0.9f, -2.3f, 0.82f, -3.94f, -0.97f, -3.94f, -1.2f, -2.09f, -0.97f, -1.35f

    );

    private static final BodyImage leftIdle =
            new BodyImage("data/knightIdleLeft.gif", 8f);

    private static final BodyImage rightIdle =
            new BodyImage("data/knightIdleRight.gif", 8f);

    private static final BodyImage leftImage =
            new BodyImage("data/knightLeft2.gif", 8f);

    private static final BodyImage rightImage =
            new BodyImage("data/knightRight2.gif", 8f);

    private static final BodyImage deathImage =
            new BodyImage("data/knightDeath.gif", 8f);

    private static final BodyImage knightHit =
            new BodyImage("data/knightHit.gif", 8f);

    private static final BodyImage swordRight =
            new BodyImage("data/swordRight.png", 5f);
    private static final BodyImage swordLeft =
            new BodyImage("data/swordLeft.png", 5f);

    private static SoundClip hitSound;

    static {
        try{
            hitSound = new SoundClip("data/damage.wav");
            System.out.println("Loading hit sound");
        } catch (UnsupportedAudioFileException |IOException |LineUnavailableException e) {
            System.out.println(e);
        }
    }



    private String direction;

    private int coins;
    private int lives;
    private int score;
    private boolean hit;
    GameLevel currentLevel;
    Game game;


    public Knight(World world, GameLevel level, Game game) {
        super(world, knightShape);
        addImage(rightIdle);
        direction = "right";
        coins = 0;
        lives = 3;
        score = 0;
        hit = false;
        currentLevel = level;
        this.game = game;
    }

    public void attack() {

        DynamicBody projectile = new DynamicBody(this.getWorld(), new PolygonShape(0.93f,-0.15f, 0.6f,0.18f, -0.18f,0.38f, -0.75f,0.0f, -0.27f,-0.36f
        ));
        if (direction.equals("left")) {
            projectile.setPosition(new Vec2(this.getPosition().x-1, this.getPosition().y));
            projectile.setLinearVelocity(new Vec2(-35, 0));
            projectile.addImage(swordLeft);

        }

        if (direction.equals("right")) {
            projectile.setPosition(new Vec2(this.getPosition().x+1, this.getPosition().y));
            projectile.setLinearVelocity(new Vec2(35, 0));
            projectile.addImage(swordRight);

        }
        projectile.addCollisionListener(new AttackCollision(this, currentLevel, game));
        projectile.addCollisionListener(new NoHitCollision());


    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLives() {
        return lives;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getCoins() {
        return coins;
    }

    public void setHit(boolean hit) {
        this.hit = true;
        this.removeAllImages();
        this.addImage(knightHit);
        hitSound.play();
    }

    public boolean getHit() {
        return hit;
    }



    @Override
    public void startWalking(float speed) {
        super.startWalking(speed);
        if (speed < 0) {
            this.removeAllImages();
            this.addImage(leftImage);
            direction = "left";
        } else {
            this.removeAllImages();
            this.addImage(rightImage);
            direction = "right";
        }
    }

    public void stop(float speed) {
        super.startWalking(0);
        if (this.direction == "left") {
            this.removeAllImages();
            this.addImage(leftIdle);
        } else {
            this.removeAllImages();
            this.addImage(rightIdle);
        }
    }

    /*public void jump(float speed) {
        super.jump(speed);
        if (speed > 0 && this.direction == "right") {
            this.removeAllImages();
            this.addImage(knightJump);
        } else if (speed == 0) {
            this.removeAllImages();
            this.addImage(rightIdle);
        }
        }*/

    }








