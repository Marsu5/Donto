package hu.tokingame.donto.Game1;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.donto.Global.Assets;
import hu.tokingame.donto.Global.Globals;
import hu.tokingame.donto.LoadingScreen.LoadingStage;
import hu.tokingame.donto.MenuScreen.MenuScreen;
import hu.tokingame.donto.MyBaseClasses.MyLabel;
import hu.tokingame.donto.MyBaseClasses.MyStage;
import hu.tokingame.donto.MyBaseClasses.MyTextButton;
import hu.tokingame.donto.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.donto.MyGdxGame;
import jdk.nashorn.internal.objects.Global;

/**
 * Created by Zoli on 2017.02.03..
 */

public class DeathStage extends MyStage {

    private DeathStage DeathStage;

    public DeathStage(Viewport viewport, Batch batch, MyGdxGame game, int score) {
        super(viewport, batch, game);

        addActor(new MyLabel("Meghaltál.\nA pontszámod: "+score, MyLabel.style2){
            @Override
            public void init() {
                super.init();
                this.setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2f, Globals.WORLD_HEIGHT/2-this.getHeight()/2f);
            }
        });

    }


    @Override
    public void init() {
        DeathStage = this;

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.MENUHATTER)){
            @Override
            public void init() {
                super.init();
                setPosition(0,0);
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
            }
        });

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.HALAL_HATTER)){
            @Override
            public void init() {
                super.init();
                setPosition(0,0);
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
            }
        });

        addActor(new MyTextButton("Play again"){
            @Override
            protected void init() {
                super.init();
                setPosition(10, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new GameScreen(game));
                    }
                });
            }
        });

        addActor(new MyTextButton("Exit"){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH-100, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new MenuScreen(game));
                    }
                });
            }
        });


    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}

