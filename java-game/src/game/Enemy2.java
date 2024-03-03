package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Enemy2 extends Walker implements StepListener{

    private static final BodyImage enemyIdleLeft2 = new BodyImage("data/enemyLeft2.png", 10f);
    //private static final BodyImage enemyIdleRight = new BodyImage("data/skeletonIdle2.gif", 4.5f);
    private static final BodyImage enemyLeft2 = new BodyImage("data/enemyWalkLeft2.gif", 10f);
    private static final BodyImage enemyRight2 = new BodyImage("data/enemyWalkRight2.gif", 10f);
    private static final BodyImage enemyAttack = new BodyImage("data/enemyAttack.gif", 4.5f);


    private static final Shape enemyShape = new PolygonShape(-0.02f,-1.7f, 0.6f,-2.82f, 0.64f,-4.96f, -0.94f,-4.94f, -0.96f,-2.64f, -0.5f,-1.74f
    );
    private final int SPEED = 10;

    /*
    This implementation of moving is useful for multiple enemies with independent movement as
    each instance you create moves relative to its starting position. The range value can be
    increased to increase the amount of movement.
     */

    private float left, right;
    private final int RANGE = 2;

    public Enemy2(World world) {
        super(world, enemyShape);
        addImage(enemyIdleLeft2);
        world.addStepListener(this);
        startWalking(SPEED);
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
            this.removeAllImages();
            addImage(enemyLeft2);
        }
        if (getPosition().x < left){
            startWalking(SPEED);
            this.removeAllImages();
            addImage(enemyRight2);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
