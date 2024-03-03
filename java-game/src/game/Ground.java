package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Ground extends StaticBody {

    private static final Shape groundShape = new BoxShape(1.6f, 0.5f);

    private static final BodyImage groundImage = new BodyImage("data/ground.png", 1f);

    public Ground(World w) {
        super(w, groundShape);
        addImage(groundImage);
    }
}

