package hu.tokingame.donto.Game1;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.donto.LoadingScreen.LoadingStage;
import hu.tokingame.donto.MyBaseClasses.MyLabel;
import hu.tokingame.donto.MyBaseClasses.MyStage;
import hu.tokingame.donto.MyGdxGame;

/**
 * Created by Zoli on 2017.02.03..
 */

public class DeathStage extends MyStage {

    private DeathStage DeathStage;

    public DeathStage(Viewport viewport, Batch batch, MyGdxGame game, int score) {
        super(viewport, batch, game);

        addActor(new MyLabel("You Died. \n Your score was:"+score, MyLabel.style1){
            @Override
            public void init() {
                super.init();
                this.setPosition(200, 600);
            }
        });
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

