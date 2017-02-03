package hu.tokingame.donto.Bodies;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.tokingame.donto.Game1.GameStage;
import hu.tokingame.donto.Global.Assets;
import hu.tokingame.donto.MyBaseClasses.OneSpriteAnimatedActor;
import hu.tokingame.donto.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.donto.MyBaseClasses.WorldActorGroup;
import hu.tokingame.donto.MyBaseClasses.WorldBodyEditorLoader;

/**
 * Created by davim on 2017. 02. 03..
 */

public class HealthActor extends WorldActorGroup {
    OneSpriteStaticActor actor;
    GameStage gameStage;

    public HealthActor(World world, WorldBodyEditorLoader loader, float x, float y, GameStage gs) {
        super(world, loader, "sample", BodyDef.BodyType.DynamicBody, 0, 0.2f, 5, false);
        gameStage = gs;
        addActor(actor = new OneSpriteStaticActor(Assets.manager.get(Assets.BL)));
        actor.setSize(1,1);
        setSize(1,1);
        addToWorld();
        setPosition(x,y);
        addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                gameStage.incrementHP();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

}
