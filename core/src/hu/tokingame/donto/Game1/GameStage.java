package hu.tokingame.donto.Game1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.donto.MenuScreen.MenuScreen;
import hu.tokingame.donto.MyBaseClasses.MyStage;
import hu.tokingame.donto.MyGdxGame;

/**
 * Created by tuskeb on 2017. 01. 30..
 */

public class GameStage extends MyStage {
    protected InputMultiplexer inputMultiplexer = new InputMultiplexer();

    private ControlStage controlStage;

    int rdm(int a, int b){return (int)(Math.random()*(b-a+1)+a);}


    public GameStage(MyGdxGame game) {
        super(new ExtendViewport(16,9,new OrthographicCamera(16,9)), new SpriteBatch(), game);
        controlStage = new ControlStage(game, this);
        inputMultiplexer.addProcessor(this);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK){
            game.setScreen(new MenuScreen(game));
        }
        return false;
    }

    @Override
    public void init() {
    }


    @Override
    public void act(float delta) {
        super.act(delta);
        controlStage.act();
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
}
