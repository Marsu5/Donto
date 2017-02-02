package hu.tokingame.donto.LoadingScreen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.donto.Global.Assets;
import hu.tokingame.donto.MenuScreen.MenuScreen;
import hu.tokingame.donto.MyBaseClasses.MyScreen;
import hu.tokingame.donto.MyGdxGame;

/**
 * Created by M on 10/7/2016.
 */

public class LoadingScreen extends MyScreen {

    LoadingStage stage;


    private float elapsedTime = 0;

    public LoadingScreen(MyGdxGame game) {
        super(game);
        setBackGroundColor(0.498f, 0.498f, 0.498f);

    }

    @Override
    public void show() {
        Assets.manager.finishLoading();
        Assets.load();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        //if (elapsedTime > 2.0 && Assets.manager.update()) {
        if (Assets.manager.update() && elapsedTime > 0.5) {
            Assets.afterLoaded();
            game.setScreen(new MenuScreen(game));
        }
        elapsedTime += delta;
        stage.act(delta);
        stage.draw();

    }

    @Override
    public void hide() {

    }

    @Override
    public void init() {
        super.init();
        stage = new LoadingStage(new ExtendViewport(1280,720,new OrthographicCamera(1280,720)), new SpriteBatch(), game);
    }

    @Override
    public void dispose() {
        stage.dispose();
        super.dispose();
    }
}
