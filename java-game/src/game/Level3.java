package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level3 extends GameLevel {

    Image background;
    private Enemy3 enemy3;

    public Level3(Game game) {
        super(game);

        background = new ImageIcon("data/background3.png").getImage();

        //make platforms
        Shape platform3Shape = new PolygonShape(3.121f,0.987f, -3.133f,0.987f, -3.108f,-0.98f, 3.121f,-0.98f);
        BodyImage platform3Image = new BodyImage("data/platform3.png", 2f);

        for (float i=0; i<13f; i = i + 5.5f) {
            StaticBody platform = new StaticBody(this, platform3Shape);
            platform.setPosition(new Vec2(5- i, 2f));
            platform.addImage(platform3Image);
        }

        //knight position
        getKnight().setPosition(new Vec2(2, 10f));

        /*enemy positions
        //top 2 enemies
        enemy2 = new Enemy2(this);
        enemy2.setPosition(new Vec2(-10, 8f));
        enemy2 = new Enemy2(this);
        enemy2.setPosition(new Vec2(10, 8f));
        //bottom 2 enemies
        enemy2 = new Enemy2(this);
        enemy2.setPosition(new Vec2(-10, 0f));
        enemy2 = new Enemy2(this);
        enemy2.setPosition(new Vec2(10, 0f));*/
        enemy3 = new Enemy3(this);
        enemy3.setPosition(new Vec2(0,0));



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
        return "Level3";
    }

    @Override
    public boolean isComplete() {
        if (getKnight().getScore() >= 10)
            return true;
        else
            return false;
    }
}

