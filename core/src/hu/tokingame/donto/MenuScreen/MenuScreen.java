package hu.tokingame.donto.MenuScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.donto.Global.Globals;
import hu.tokingame.donto.MyBaseClasses.MyScreen;
import hu.tokingame.donto.MyGdxGame;


/**
 * Created by M on 11/14/2016.
 */

public class MenuScreen extends MyScreen {
    private MenuStage stage;

    private static boolean firstLoad = true;
    private Preferences preferences;

    public MenuScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void init() {
        super.init();
        stage = new MenuStage(new ExtendViewport(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT,new OrthographicCamera(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT)),new SpriteBatch(),game);

        preferences = Gdx.app.getPreferences(Globals.SCORE1);
        stage = new MenuStage(new ExtendViewport(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT,new OrthographicCamera(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT)),new SpriteBatch(),game);
        if(firstLoad){
            for (int i = 0; i < preferences.getInteger("size",0); i++) {
                Globals.MaxScores1.add(preferences.getInteger(i+"",0));
            }
            firstLoad = false;
        }else{
            preferences.putInteger("size",Globals.MaxScores1.size());
            for (int i = 0; i < Globals.MaxScores1.size(); i++) {
                preferences.putInteger(i+"",Globals.MaxScores1.get(i));
            }
        }

        preferences.flush();

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        stage.resize(width, height);
    }

    @Override
    public void dispose() {
        stage.dispose();
        super.dispose();
    }
}
