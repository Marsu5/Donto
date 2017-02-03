package hu.tokingame.donto.Bodies;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.tokingame.donto.Game1.GameStage;
import hu.tokingame.donto.Global.Assets;
import hu.tokingame.donto.Global.Globals;
import hu.tokingame.donto.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.donto.MyBaseClasses.WorldActorGroup;
import hu.tokingame.donto.MyBaseClasses.WorldBodyEditorLoader;

/**
 * Created by M on 2/3/2017.
 */

public class PigActor extends WorldActorGroup {
    private OneSpriteStaticActor actor;
    private GameStage gameStage;
    private float rotateRef;

    private float deadX;
    private float deadY;
    private boolean addDead = false;
    private Vector2 deadVol;
    private float deadRotation;

    private World world;
    private WorldBodyEditorLoader loader;




    public PigActor(World world, WorldBodyEditorLoader loader, float x, float y, GameStage stage) {
        super(world, loader, "sample", BodyDef.BodyType.DynamicBody, 0, 0.2f, 5, false);
        addToWorld();
        gameStage = stage;
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.MALAC));
        setSize(2f,1f);
        actor.setSize(2f,1f);
        addActor(actor);
        setPosition(x,y);

        this.loader = loader;
        this.world = world;

        rotateRef = Globals.randomF(-150, 150) * 10;

        addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                die();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    public void die(){
        deadX = getX();
        deadY = getY();
        deadVol = getBody().getLinearVelocity();
        gameStage.incrementScore();
        gameStage.minusPigCount();
        deadRotation = getBody().getAngle();
        addDead = true;
        removeFromWorld();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(addDead){
            DeadPigButt butt;
            DeadPigHead head;
            gameStage.addActor(butt = new DeadPigButt(world,loader,deadX,deadY));
            gameStage.addActor(head = new DeadPigHead(world,loader,deadX,deadY));
            head.getBody().applyTorque(rotateRef * delta, true);
            butt.getBody().applyTorque(-rotateRef * delta, true);
            head.getBody().setLinearVelocity(deadVol);
            butt.getBody().setLinearVelocity(deadVol);
            addDead = false;
        }
        if(getBody() == null) return;
        getBody().applyTorque(rotateRef * delta, true);
}

}