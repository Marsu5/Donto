package hu.tokingame.donto.Bodies;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.donto.Global.Assets;
import hu.tokingame.donto.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.donto.MyBaseClasses.WorldActorGroup;
import hu.tokingame.donto.MyBaseClasses.WorldBodyEditorLoader;

/**
 * Created by M on 2/3/2017.
 */

public class DeadPigHead extends WorldActorGroup {
    private OneSpriteStaticActor actor;

    public DeadPigHead(World world, WorldBodyEditorLoader loader, float x, float y) {
        super(world, loader, "sample", BodyDef.BodyType.DynamicBody, 0, 0.2f, 5, false);
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.MALAC_FEJ));
        setSize(2f,1f);
        actor.setSize(2f,1f);
        addActor(actor);
        setPosition(x,y);
        addToWorld();
    }
}
