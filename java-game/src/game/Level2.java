package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level2 extends GameLevel {

    Image background;
    private Enemy2 enemy2;

    public Level2(Game game) {
        super(game);

        background = new ImageIcon("data/background2.jpg").getImage();

        //make platforms
        Shape platform2Shape = new PolygonShape(-3.235f,0.432f, 3.308f,0.417f, 3.468f,0.271f, 3.497f,-0.122f, 3.351f,-0.224f, -3.22f,-0.282f, -3.337f,-0.122f, -3.351f,0.242f);
        BodyImage platform2Image = new BodyImage("data/platform2.png", 2f);
        //top 2 platforms
        StaticBody platform = new StaticBody(this, platform2Shape);
        platform.addImage(platform2Image);
        platform.setPosition(new Vec2(-10f, 0f));
        StaticBody platform2 = new StaticBody(this, platform2Shape);
        platform2.addImage(platform2Image);
        platform2.setPosition(new Vec2(10f, 0f));
        //middle platform
        StaticBody platform3 = new StaticBody(this, platform2Shape);
        platform3.addImage(platform2Image);
        platform3.setPosition(new Vec2(0f, -5f));
        //bottom 2 platforms
        StaticBody platform4 = new StaticBody(this, platform2Shape);
        platform4.addImage(platform2Image);
        platform4.setPosition(new Vec2(-10f, -8f));
        StaticBody platform5 = new StaticBody(this, platform2Shape);
        platform5.addImage(platform2Image);
        platform5.setPosition(new Vec2(10f, -8f));

        //make coins
        for (float i = 0; i < 5; i = i + 1.15f) {
            Coins coin = new Coins(this);
            coin.setPosition(new Vec2(2.5f-i, -4f));
        }

        //knight position
        getKnight().setPosition(new Vec2(2, -7));

        //enemy positions
        //top 2 enemies
        enemy2 = new Enemy2(this);
        enemy2.setPosition(new Vec2(-10, 8f));
        enemy2 = new Enemy2(this);
        enemy2.setPosition(new Vec2(10, 8f));
        //bottom 2 enemies
        enemy2 = new Enemy2(this);
        enemy2.setPosition(new Vec2(-10, 0f));
        enemy2 = new Enemy2(this);
        enemy2.setPosition(new Vec2(10, 0f));



    }
    @Override
    public boolean death() {
        if (getKnight().getLives() == 0)
            return true;
        else
            return false;
    }

    @Override
    public Image getBackground() {
        return background;
    }

    @Override
    public String getLevelName() {
        return "Level2";
    }

    @Override
    public boolean isComplete() {
        if (getKnight().getScore() >= 70)
            return true;
        else
            return false;
    }
}

