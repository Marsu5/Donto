package hu.tokingame.donto.Bodies;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.tokingame.donto.Game2.Game2Stage;
import hu.tokingame.donto.Global.Assets;
import hu.tokingame.donto.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.donto.MyBaseClasses.WorldActorGroup;
import hu.tokingame.donto.MyBaseClasses.WorldBodyEditorLoader;

/**
 * Created by davim on 2017. 02. 03..
 */

public class KinematicPig extends WorldActorGroup {
        private OneSpriteStaticActor actor;
        Game2Stage game2Stage;

    public KinematicPig(World world, WorldBodyEditorLoader loader, float x, float y, Game2Stage gs) {
        super(world, loader, "malac.PNG", BodyDef.BodyType.KinematicBody, 0, 0.2f, 5, false);
        game2Stage = gs;
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.MALAC));
        actor.setSize(1,1);
        setSize(1,1);
        addToWorld();

        addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game2Stage.pigTapped();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }
}
