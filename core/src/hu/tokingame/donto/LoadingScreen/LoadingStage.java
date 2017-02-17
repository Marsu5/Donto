package hu.tokingame.donto.LoadingScreen;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.donto.Global.Assets;
import hu.tokingame.donto.Global.Globals;
import hu.tokingame.donto.MyBaseClasses.MyStage;
import hu.tokingame.donto.MyBaseClasses.OneSpriteAnimatedActor;
import hu.tokingame.donto.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.donto.MyGdxGame;

/**
 * Created by M on 11/14/2016.
 */

public class LoadingStage extends MyStage {

    private LoadingStage loadingStage;
    private OneSpriteAnimatedActor palinka;

    public LoadingStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }


    @Override
    public void init() {
        loadingStage = this;

        addActor(new OneSpriteStaticActor("textures/PEN.png"){
            @Override
            public void init() {
                super.init();
                setSize(200, 200);
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 50);
            }
        });

        addActor(palinka = new OneSpriteAnimatedActor("atlas/loading.txt"){
            @Override
            public void init() {
                super.init();
                stop();
                setFrame(0);
                setSize(300, 300);
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 300);
            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        palinka.setFramePercent(Assets.manager.getProgress());
    }
}
