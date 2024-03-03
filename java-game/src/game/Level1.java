package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level1 extends GameLevel{

    Image background;
    private Enemy enemy;


    public Level1(Game game){
        super(game);

        background = new ImageIcon("data/background.png").getImage();

        //make platforms
        Shape platformShape = new BoxShape(3.2f, 0.5f);
        BodyImage platformImage = new BodyImage("data/platform.png", 1f);
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(-2f,-8f));
        platform.addImage(platformImage);
        StaticBody platform1 = new StaticBody(this,platformShape);
        platform1.setPosition(new Vec2(-10.5f,-3f));
        platform1.addImage(platformImage);

        for (float i=0; i<9f; i = i + 7.25f) {
            StaticBody platform3 = new StaticBody(this, platformShape);
            platform3.setPosition(new Vec2(14 - i, -5.25f));
            platform3.addImage(platformImage);
        }
        for (float i=0; i<9f; i = i + 7.25f) {
            StaticBody platform3 = new StaticBody(this, platformShape);
            platform3.setPosition(new Vec2(5- i, 2f));
            platform3.addImage(platformImage);
        }

        //make coins
        for (float i=0; i<5; i = i + 1.15f) {
            Coins coin = new Coins(this);
            coin.setPosition(new Vec2((0f)-i, -7f));
        }

        for (float i=0; i<5; i = i + 1.15f) {
            Coins coin = new Coins(this);
            coin.setPosition(new Vec2((-8f)-i, -2f));
        }

        //knight position
        getKnight().setPosition(new Vec2(-10, -7));

        //enemy positions
        enemy = new Enemy(this);
        enemy.setPosition(new Vec2(10, -8));
        enemy = new Enemy(this);
        enemy.setPosition(new Vec2(12, -2));
        enemy = new Enemy(this);
        enemy.setPosition(new Vec2(2, 8));

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

    public String getLevelName(){
        return "Level1";
    }


    @Override
    public boolean isComplete() {
        if (getKnight().getScore() >= 30)
            return true;
        else
            return false;
    }
}
