package hu.tokingame.donto.MenuScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.donto.Game1.GameScreen;
import hu.tokingame.donto.Game2.Game2Screen;
import hu.tokingame.donto.Global.Assets;
import hu.tokingame.donto.Global.Globals;
import hu.tokingame.donto.HighScreen.HighScreen;
import hu.tokingame.donto.MyBaseClasses.BackgroundTextButton;
import hu.tokingame.donto.MyBaseClasses.MyLabel;
import hu.tokingame.donto.MyBaseClasses.MyStage;
import hu.tokingame.donto.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.donto.MyGdxGame;

/**
 * Created by Zoli on 2017.02.03..
 */

public class CreditsStage extends MyStage {

    public CreditsStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK){
            game.setScreen(new ExitScreen(game));
        }
        return false;
    }

    @Override
    public void init() {

        String s = "Bálint Dániel - Grafika\nDávid Mátyás - Kódolás\nKovács Zoltán - Kódolás\nSchuh Marcell - Kódolás";

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.KEK_HATTER)){
            @Override
            public void init() {
                super.init();
                setPosition(0,0);
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
            }

        });

        addActor(new MyLabel(s, MyLabel.style2) {
            @Override
            public void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH / 2f - this.getWidth() / 2f, Globals.WORLD_HEIGHT/2f-this.getHeight()/2f+200);
            }
        });

        addActor(new MyLabel("Köszönjünk a Pannon Egyetem Nagykanizsai Kampuszának,\n hogy részt vehettünk a versenyen,\n valamint felkészítő tanárunknak, Tüske Balázsnak.", MyLabel.style3) {
            @Override
            public void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH / 2f - this.getWidth() / 2f, 100);
            }
        });

        addActor(new BackgroundTextButton("  Vissza  "){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH-this.getWidth(), 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new MenuScreen(game));
                    }
                });
            }
        });
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.PEN)) {
            @Override
            public void init() {
                super.init();
                setSize(100, 100);
                setPosition(10, Globals.WORLD_HEIGHT - this.getWidth() - 10);
                this.setPosition(10, Globals.WORLD_HEIGHT - this.getHeight() - 10);

            }
        });


    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

}
