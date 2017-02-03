package hu.tokingame.donto.Game1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.donto.Global.Globals;
import hu.tokingame.donto.MenuScreen.MenuStage;
import hu.tokingame.donto.MyBaseClasses.MyScreen;
import hu.tokingame.donto.MyGdxGame;

/**
 * Created by Zoli on 2017.02.03..
 */

public class DeathScreen extends MyScreen{

    private DeathStage stage;
    private Preferences preferences;
    private Preferences preferences2;

    public DeathScreen(MyGdxGame game, int score) {
        super(game);
        stage = new DeathStage(new ExtendViewport(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT,new OrthographicCamera(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT)),new SpriteBatch(),game,score);

        preferences = Gdx.app.getPreferences(Globals.SCORE1);
        preferences.putInteger("size",Globals.MaxScores1.size());
        for (int i = 0; i < Globals.MaxScores1.size(); i++) {
            preferences.putInteger(i+"",Globals.MaxScores1.get(i));
        }

        preferences.flush();

        preferences2 = Gdx.app.getPreferences(Globals.SCORE2);
        preferences2.putInteger("size",Globals.MaxScores2.size());
        for (int i = 0; i < Globals.MaxScores2.size(); i++) {
            preferences2.putInteger(i+"",Globals.MaxScores2.get(i));
        }

        preferences2.flush();

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void init() {
        super.init();
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
