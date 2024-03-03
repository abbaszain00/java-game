package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Enemy3 extends Walker implements StepListener{

    private static final BodyImage bossIdleLeft2 = new BodyImage("data/bossLeft2.gif", 15f);
    //private static final BodyImage enemyIdleRight = new BodyImage("data/skeletonIdle2.gif", 4.5f);
    private static final BodyImage bossLeft2 = new BodyImage("data/bossWalkLeft2.gif", 15f);
    private static final BodyImage bossRight2 = new BodyImage("data/bossWalkRight2.gif", 15f);
    private static final BodyImage enemyAttack = new BodyImage("data/enemyAttack.gif", 4.5f);


    private static final Shape enemyShape = new PolygonShape(-2.21f,-7.3f, 3.46f,-7.3f, 3.46f,-4.27f, 1.35f,-0.76f, -2.38f,-0.92f);
    private final int SPEED = 5;

    /*
    This implementation of moving is useful for multiple enemies with independent movement as
    each instance you create moves relative to its starting position. The range value can be
    increased to increase the amount of movement.
     */

    private float left, right;
    private final int RANGE = 10;

    public Enemy3(World world) {
        super(world, enemyShape);
        addImage(bossIdleLeft2);
        world.addStepListener(this);
        startWalking(SPEED);
        jump(13);
    }

    @Override
    public void setPosition(Vec2 position) {
        super.setPosition(position);
        left = position.x-RANGE;
        right = position.x+RANGE;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x > right){
            startWalking(-SPEED);
            jump(13);
            this.removeAllImages();
            addImage(bossLeft2);
        }
        if (getPosition().x < left){
            startWalking(SPEED);
            jump(13);
            this.removeAllImages();
            addImage(bossRight2);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
