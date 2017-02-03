package hu.tokingame.donto.Game2;

import hu.tokingame.donto.Game1.GameStage;
import hu.tokingame.donto.MyBaseClasses.MyScreen;
import hu.tokingame.donto.MyGdxGame;

/**
 * Created by davimatyi on 2017. 01. 18..
 */

public class Game2Screen extends MyScreen {

    private Game2Stage stage;

    public Game2Screen(MyGdxGame game) {
        super(game);
        stage = new Game2Stage(game);
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


    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act(delta);
        stage.draw();

    }


    @Override
    public void init() {
        super.init();
    }

    @Override
    public void resume() {
        super.resume();
    }

}
