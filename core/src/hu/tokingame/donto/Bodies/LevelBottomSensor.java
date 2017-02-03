package hu.tokingame.donto.Bodies;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.donto.MyBaseClasses.ShapeType;
import hu.tokingame.donto.MyBaseClasses.WorldActorGroup;
import hu.tokingame.donto.MyBaseClasses.WorldBodyEditorLoader;

/**
 * Created by davim on 2017. 02. 03..
 */

public class LevelBottomSensor extends WorldActorGroup {
    public LevelBottomSensor(World world, WorldBodyEditorLoader loader, float x, float y) {
        super(world, loader,"csik", BodyDef.BodyType.StaticBody, 0, 0, 0, true);
        setSize(16,1);
        setPosition(x, y);
        addToWorld();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
