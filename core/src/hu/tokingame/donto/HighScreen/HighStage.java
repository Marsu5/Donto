package hu.tokingame.donto.HighScreen;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Vector;

import hu.tokingame.donto.Game1.DeathStage;
import hu.tokingame.donto.Game1.GameScreen;
import hu.tokingame.donto.Global.Assets;
import hu.tokingame.donto.Global.Globals;
import hu.tokingame.donto.MenuScreen.MenuScreen;
import hu.tokingame.donto.MyBaseClasses.BackgroundTextButton;
import hu.tokingame.donto.MyBaseClasses.MyLabel;
import hu.tokingame.donto.MyBaseClasses.MyStage;
import hu.tokingame.donto.MyBaseClasses.MyTextButton;
import hu.tokingame.donto.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.donto.MyGdxGame;

/**
 * Created by Zoli on 2017.02.03..
 */

public class HighStage extends MyStage {

    private hu.tokingame.donto.HighScreen.HighStage HighStage;

    Vector<MyLabel> hsV;
    public HighStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);


    }


    @Override
    public void init() {
        HighStage = this;

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.MENUHATTER)){
            @Override
            public void init() {
                super.init();
                setPosition(0,0);
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
            }
        });

        addActor(new BackgroundTextButton("Vissza"){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH-this.getWidth()-30, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new MenuScreen(game));
                    }
                });
            }
        });

        if (Globals.MaxScores.size() > 0) {
            hsV = new Vector();
            for (int i = 0; i < Globals.MaxScores.size(); i++) {
                int k = Globals.MaxScores.get(i);
                int b = Math.round(k * 100) / 100;
                final int finalI = i;
                hsV.add(new MyLabel(i + 1 + ". " + b + "", MyLabel.style1) {
                    @Override
                    public void init() {
                        super.init();
                        setPosition(Globals.WORLD_WIDTH / 2 - this.getWidth() / 2, finalI > 0 ? hsV.get(finalI - 1).getY() - 75 : 500);
                    }
                });
                addActor(hsV.get(i));
            } // Egy megérett a meggy. Kettő megérett a meggy. Három megérett a meggy...
            hsV.clear();
        } else {
            addActor(new MyLabel("There are no scores yet.", MyLabel.style1) {
                @Override
                public void init() {
                    super.init();
                    setPosition(Globals.WORLD_WIDTH / 2 - this.getWidth() / 2, 500);
                }
            });
        }

    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

}
