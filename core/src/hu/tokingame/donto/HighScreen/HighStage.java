package hu.tokingame.donto.HighScreen;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Collections;
import java.util.Vector;

import hu.tokingame.donto.Global.Assets;
import hu.tokingame.donto.Global.Globals;
import hu.tokingame.donto.MenuScreen.MenuScreen;
import hu.tokingame.donto.MyBaseClasses.BackgroundTextButton;
import hu.tokingame.donto.MyBaseClasses.MyLabel;
import hu.tokingame.donto.MyBaseClasses.MyStage;
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

        Collections.sort(Globals.MaxScores1);
        Collections.reverse(Globals.MaxScores1);

        Collections.sort(Globals.MaxScores2);
        Collections.reverse(Globals.MaxScores2);

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
        addActor(new MyLabel("Disznó eső\n", MyLabel.style2) {
            @Override
            public void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH / 2 - this.getWidth() / 2-300, 500);
            }
        });
        if (Globals.MaxScores1.size() > 0) {
            hsV = new Vector();

            for (int i = 0; i < Globals.MaxScores1.size(); i++) {
                int k = Globals.MaxScores1.get(i);
                int b = Math.round(k * 100) / 100;
                final int finalI = i;
                hsV.add(new MyLabel(i + 1 + ". " + b + " pont", MyLabel.style2) {
                    @Override
                    public void init() {
                        super.init();
                        setPosition(Globals.WORLD_WIDTH / 2 - this.getWidth() / 2-300, finalI > 0 ? hsV.get(finalI - 1).getY() - 75 : 500);
                    }
                });
                addActor(hsV.get(i));
            }
            hsV.clear();
        } else {
            addActor(new MyLabel("Még nincs elért eredmény", MyLabel.style2) {
                @Override
                public void init() {
                    super.init();
                    setPosition(Globals.WORLD_WIDTH / 2 - this.getWidth() / 2-300, 500);
                }
            });
        }
        addActor(new MyLabel("Disznó vadászat\n", MyLabel.style2) {
            @Override
            public void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH / 2 - this.getWidth() / 2+300, 500);
            }
        });
        if (Globals.MaxScores2.size() > 0) {
            hsV = new Vector();

            for (int i = 0; i < Globals.MaxScores2.size(); i++) {
                int k = Globals.MaxScores2.get(i);
                int b = Math.round(k * 100) / 100;
                final int finalI = i;
                hsV.add(new MyLabel(i + 1 + ". " + b + " pont", MyLabel.style2) {
                    @Override
                    public void init() {
                        super.init();
                        setPosition(Globals.WORLD_WIDTH / 2 - this.getWidth() / 2+300, finalI > 0 ? hsV.get(finalI - 1).getY() - 75 : 500);
                    }
                });
                addActor(hsV.get(i));
            }
            hsV.clear();
        } else {
            addActor(new MyLabel("Még nincs elért eredmény", MyLabel.style2) {
                @Override
                public void init() {
                    super.init();
                    setPosition(Globals.WORLD_WIDTH / 2 - this.getWidth() / 2+300, 500);
                }
            });
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

}
