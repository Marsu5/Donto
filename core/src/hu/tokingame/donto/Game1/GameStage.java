package hu.tokingame.donto.Game1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.donto.Bodies.LevelBottomSensor;
import hu.tokingame.donto.Bodies.PigActor;
import hu.tokingame.donto.MenuScreen.MenuScreen;
import hu.tokingame.donto.MyBaseClasses.MyStage;
import hu.tokingame.donto.MyBaseClasses.WorldBodyEditorLoader;
import hu.tokingame.donto.MyGdxGame;

/**
 * Created by tuskeb on 2017. 01. 30..
 */

public class GameStage extends MyStage {
    protected InputMultiplexer inputMultiplexer = new InputMultiplexer();

    private ControlStage controlStage;
    private PigActor character;
    World world;
    Box2DDebugRenderer box2DDebugRenderer;
    WorldBodyEditorLoader loader;

    float elapsedTime = 0;

    private int hp = 3;
    private int score = 0;

    int rdm(int a, int b){return (int)(Math.random()*(b-a+1)+a);}


    public GameStage(MyGdxGame game) {
        super(new ExtendViewport(16,9,new OrthographicCamera(16,9)), new SpriteBatch(), game);
        controlStage = new ControlStage(game, this);
        inputMultiplexer.addProcessor(this);
        inputMultiplexer.addProcessor(controlStage);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }
    @Override
    public void init() {
        world = new World(new Vector2(0, -5), false);
        box2DDebugRenderer = new Box2DDebugRenderer();
        loader = new WorldBodyEditorLoader(Gdx.files.internal("phys.json"));
        addActor(character = new PigActor(world, loader,5,9,this));



        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                if (contact.getFixtureA().getUserData() instanceof PigActor && contact.getFixtureB().getUserData() instanceof LevelBottomSensor ||
                        contact.getFixtureA().getUserData() instanceof LevelBottomSensor && contact.getFixtureB().getUserData() instanceof PigActor) {
                    System.out.println("collision");

                }

            }

            @Override
            public void endContact(Contact contact) {

            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {

            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {

            }
        });





    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK){
            game.setScreen(new MenuScreen(game));
        }
        return false;
    }



    @Override
    public void act(float delta) {
        super.act(delta);
        controlStage.act();
        world.step(delta, 10, 10);
        elapsedTime  += delta;
        if(hp == 0){
            //// TODO: 2/3/2017 halál képernyő
        }
    }

    @Override
    public void draw() {
        super.draw();
        controlStage.draw();
    }


    @Override
    public void resize(int screenWidth, int screenHeight) {
        super.resize(screenWidth, screenHeight);
    }


    @Override
    public void dispose() {
        controlStage.dispose();
        super.dispose();
    }

    public int getScore(){
        return score;
    }

    public void incrementScore(){
        System.out.println("k"+score);
        score++;
        System.out.println("v"+score);
    }
}
