package hu.tokingame.donto.Game2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.donto.Bodies.KinematicPig;
import hu.tokingame.donto.Bodies.LevelBottomSensor;
import hu.tokingame.donto.Bodies.PigActor;
import hu.tokingame.donto.Game1.ControlStage;
import hu.tokingame.donto.Game1.DeathScreen;
import hu.tokingame.donto.Global.Assets;
import hu.tokingame.donto.Global.Globals;
import hu.tokingame.donto.MenuScreen.MenuScreen;
import hu.tokingame.donto.MyBaseClasses.MyStage;
import hu.tokingame.donto.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.donto.MyBaseClasses.WorldBodyEditorLoader;
import hu.tokingame.donto.MyGdxGame;

/**
 * Created by tuskeb on 2017. 01. 30..
 */

public class Game2Stage extends MyStage {
    protected InputMultiplexer inputMultiplexer = new InputMultiplexer();

    private ControlStage controlStage;
    World world;
    Box2DDebugRenderer box2DDebugRenderer;
    WorldBodyEditorLoader loader;

    KinematicPig pig1, pig2, pig3, pig4;

    float elapsedTime = 0;

    private int hp = 3;
    private int score = 0;

    private int pigCount = 0;
    private float lastPigTime = 0;


    int rdm(int a, int b){return (int)(Math.random()*(b-a+1)+a);}
    float randomF(float a, float b){return (float) (Math.random()*(b-a+1)+a);}


    public Game2Stage(MyGdxGame game) {
        super(new ExtendViewport(16,9,new OrthographicCamera(16,9)), new SpriteBatch(), game);
        controlStage = new ControlStage(game, this);
        inputMultiplexer.addProcessor(this);
        inputMultiplexer.addProcessor(controlStage);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }
    @Override
    public void init() {
        world = new World(new Vector2(0, -2.5f), false);
        box2DDebugRenderer = new Box2DDebugRenderer();
        loader = new WorldBodyEditorLoader(Gdx.files.internal("phys.json"));

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.GAME2_HATTER)){
            @Override
            public void init() {
                super.init();
                setSize(16, 9);
                setPosition(0,0);
            }
        });

        addActor(pig1 = new KinematicPig(world, loader, 10, 6, this));

        //addActor(new TakaroActor(world, loader, 1));
        addActor(pig2 = new KinematicPig(world, loader, 0, 1, this));

        //addActor(new TakaroActor(world, loader, 2));
        addActor(pig3 = new KinematicPig(world, loader, 0, 4, this));

        //addActor(new TakaroActor(world, loader, 3));
        addActor(pig4 = new KinematicPig(world, loader, 4, 5, this));

        addActor(new TakaroActor(world, loader, 4));








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

        /*if(lastPigTime == 0) lastPigTime = elapsedTime;
        while(pigCount < 3 && elapsedTime - lastPigTime >= randomF(0.5f,3f)){
            lastPigTime = elapsedTime;
            addActor(new PigActor(world, loader,rdm(1,14),11,this));
            pigCount++;
        }*/

        if(hp == 0){
            game.setScreen(new DeathScreen(game,score));
            Globals.MaxScores1.add(score);
            System.out.println("dead");
        }
        box2DDebugRenderer.render(world,getCamera().combined);

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

    public void minusPigCount(){
        pigCount--;
    }

    public int getScore(){
        return score;
    }

    public void incrementScore(){
        System.out.println("k"+score);
        score++;
        System.out.println("v"+score);
    }
    public void incrementHP(){
        hp++;
    }

    public int getHp() {
        return hp;
    }

    public void pigTapped(){

    }

}
