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
        boolean showing = false;
        float showTime, elapsedTime = 0;
    float X, Y;



    public KinematicPig(World world, WorldBodyEditorLoader loader, float x, float y, Game2Stage gs) {
        super(world, loader, "malac.PNG", BodyDef.BodyType.KinematicBody, 0, 0.2f, 5, false);
        game2Stage = gs;
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.MALAC));
        actor.setSize(2,1);
        addActor(actor);
        setSize(2,1);
        setPosition(x, y);
        addToWorld();
        X = x; Y = y;

        addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("nyomi malac");
                game2Stage.pigTapped();
                tapped();
                return super.touchDown(event, x, y, pointer, button);
            }
        });


    }

    @Override
    public void act(float delta) {
        super.act(delta);
        elapsedTime += delta;
        if(showing){
            if(elapsedTime > showTime){
                showing = false;
                elapsedTime = 0;
                game2Stage.decreaseHP();
            }
            if(getY() < Y + 2) setY(getY() + 0.05f);
        }
        else{
            if(getY() > Y) setY(getY() - 0.05f);
        }
    }

    public void show(float upTime){
        showTime = upTime;
        showing = true;
        elapsedTime = 0;
    }

    public void tapped(){
        showing = false;
        showTime = 0;
        setY(Y);
        game2Stage.showAll();
    }
}
