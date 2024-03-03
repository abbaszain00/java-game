package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Enemy extends Walker implements StepListener{

    private static final BodyImage enemyIdleLeft = new BodyImage("data/skeletonIdle1.gif", 4.5f);
   //private static final BodyImage enemyIdleRight = new BodyImage("data/skeletonIdle2.gif", 4.5f);
    private static final BodyImage enemyLeft = new BodyImage("data/skeletonWalk.gif", 4.5f);
    private static final BodyImage enemyRight = new BodyImage("data/skeletonWalk2.gif", 4.5f);
    private static final BodyImage enemyAttack = new BodyImage("data/enemyAttack.gif", 4.5f);


    private static final Shape enemyShape = new BoxShape(1,2f);
    private final int SPEED = 3;

    /*
    This implementation of moving is useful for multiple enemies with independent movement as
    each instance you create moves relative to its starting position. The range value can be
    increased to increase the amount of movement.
     */

    private float left, right;
    private final int RANGE = 2;

    public Enemy(World world) {
        super(world, enemyShape);
        addImage(enemyIdleLeft);
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
            addImage(enemyRight);
        }
        if (getPosition().x < left){
            startWalking(SPEED);
            this.removeAllImages();
            addImage(enemyLeft);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
