package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import org.jbox2d.pooling.arrays.Vec2Array;

public class Wall {


    Shape wallShape = new BoxShape(1f, 7.5f);

    BodyImage wallImage = new BodyImage("data/wall.png", 15f);

    public Wall(World world) {
        StaticBody wall = new StaticBody(world, wallShape);
        wall.setPosition(new Vec2(-18.75f, -6f));
        wall.addImage(wallImage);
        StaticBody wall1 = new StaticBody(world, wallShape);
        wall1.setPosition(new Vec2(-18.75f, 9f));
        wall1.addImage(wallImage);
        StaticBody wall2 = new StaticBody(world, wallShape);
        wall2.setPosition(new Vec2(18.75f, 9f));
        wall2.addImage(wallImage);
        StaticBody wall3 = new StaticBody(world, wallShape);
        wall3.setPosition(new Vec2(18.75f, -6f));
        wall3.addImage(wallImage);

    }
}


