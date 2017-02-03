package hu.tokingame.donto.Game1;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.donto.LoadingScreen.LoadingStage;
import hu.tokingame.donto.MyBaseClasses.MyStage;
import hu.tokingame.donto.MyGdxGame;

/**
 * Created by Zoli on 2017.02.03..
 */

public class DeathStage extends MyStage {

    private DeathStage DeathStage;

    public DeathStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }


    @Override
    public void init() {
        DeathStage = this;

    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}

