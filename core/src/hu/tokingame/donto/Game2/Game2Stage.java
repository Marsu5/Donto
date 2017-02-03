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

import hu.tokingame.donto.Bodies.DeadPigHead;
import hu.tokingame.donto.Bodies.KinematicPig;
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

    KinematicPig pig1, pig2, pig3;
    TakaroActor takaro1, takaro2, takaro3;

    boolean shouldHide = false;
    int hideWhat = 0;
    float notHiddenSince = 0;

    boolean hidden = false;


    float elapsedTime = 0, upTime = 3, hiddenSince = 0;

    private int hp = 3;
    private int score = 0;

    private int pigCount = 0;
    private float lastPigTime = 0;


    int rdm(int a, int b){return (int)(Math.random()*(b-a+1)+a);}
    float randomF(float a, float b){return (float) (Math.random()*(b-a+1)+a);}


    public Game2Stage(MyGdxGame game) {
        super(new ExtendViewport(16,9,new OrthographicCamera(16,9)), new SpriteBatch(), game);
        controlStage = new ControlStage(game, this);
        inputMultiplexer.addProcessor(0, this);
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

        addActor(pig1 = new KinematicPig(world, loader, 4, 4.5f, this));
        pig1.setZIndex(100);

        addActor(takaro1 = new TakaroActor(world, loader, 4));

        addActor(pig2 = new KinematicPig(world, loader, 0, 3, this));
        pig2.setZIndex(100);

        addActor(takaro2 = new TakaroActor(world, loader, 2));

        addActor(pig3 = new KinematicPig(world, loader, 11, 3.5f, this));
        pig3.setZIndex(100);

        addActor(takaro3 = new TakaroActor(world, loader, 1));






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

        if(lastPigTime == 0) lastPigTime = elapsedTime;
        if(elapsedTime - lastPigTime >= randomF(3,6)){
            lastPigTime = elapsedTime;
            switch(Globals.random(1,3)){
                case 1: pig1.show(upTime); h(1); break;
                case 2: pig2.show(upTime); h(2); break;
                case 3: pig3.show(upTime); h(3); break;
            }
        }
        if(!hidden && shouldHide && notHiddenSince + 0.8f < elapsedTime){
            hideTakaro(hideWhat);
        }
        if(hidden && hiddenSince + upTime-1 < elapsedTime){
            showAll();
        }

        if(hp == 0){
            game.setScreen(new DeathScreen(game,score));
            Globals.MaxScores2.add(score);
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


    public int getScore(){
        return score;
    }

    public void incrementScore(){
        System.out.println("k"+score);
        score++;
        System.out.println("v"+score);
    }

    public int getHp() {
        return hp;
    }

    public void decreaseHP(){
        hp--;
    }

    public void pigTapped(){
        incrementScore();
    }

    public void hideTakaro(int k){
        hidden = true;
        hiddenSince = elapsedTime;
        switch(k){
            case 1: takaro1.setVisible(false);
                takaro2.setVisible(false);
                takaro3.setVisible(false);
                pig2.setVisible(false);
                pig3.setVisible(false);
                break;
            case 2: takaro2.setVisible(false);
                takaro3.setVisible(false);
                pig3.setVisible(false);
                break;
            case 3: takaro3.setVisible(false);
                break;
            default: break;
        }
    }
    public void showAll(){
        takaro1.setVisible(true);
        takaro2.setVisible(true);
        takaro3.setVisible(true);
        pig1.setVisible(true);
        pig2.setVisible(true);
        pig3.setVisible(true);
        shouldHide = false;
        hideWhat = 0;
        hidden = false;
    }

    public void h(int o){
        shouldHide = true; hideWhat = o;
        notHiddenSince =  elapsedTime;

    }

    public void spawnHead(float x, float y){
        addActor(new DeadPigHead(world, loader, x, y));
    }
}
