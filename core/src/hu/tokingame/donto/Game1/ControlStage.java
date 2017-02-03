package hu.tokingame.donto.Game1;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.donto.Global.Globals;
import hu.tokingame.donto.MenuScreen.MenuScreen;
import hu.tokingame.donto.MyBaseClasses.BackgroundTextButton;
import hu.tokingame.donto.MyBaseClasses.MyLabel;
import hu.tokingame.donto.MyBaseClasses.MyStage;
import hu.tokingame.donto.MyBaseClasses.MyTextButton;
import hu.tokingame.donto.MyGdxGame;

/**
 * Created by davimatyi on 2017. 01. 18..
 */

public class ControlStage extends MyStage {

    GameStage gameStage;
    MyLabel pontLabel, hpLabel;

    public ControlStage(MyGdxGame game, GameStage sg) {
        super(new ExtendViewport(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT,new OrthographicCamera(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT)),new SpriteBatch(), game);
        gameStage = sg;

        addActor(pontLabel = new MyLabel("Pont: "+ gameStage.getScore(), MyLabel.style2){
            @Override
            public void init() {
                super.init();
                setPosition(0, Globals.WORLD_HEIGHT-this.getHeight());
            }
        });
        addActor(hpLabel = new MyLabel("Hápé: "+ gameStage.getHp(), MyLabel.style2){
            @Override
            public void init() {
                super.init();
                setPosition(0, Globals.WORLD_HEIGHT-this.getHeight()*2);
            }
        });

    }


    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setPontLabel(gameStage.getScore());
        setHpLabel(gameStage.getHp());
    }

    @Override
    public void init() {
        addActor(new BackgroundTextButton("Kilépés"){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH-this.getWidth(), Globals.WORLD_HEIGHT-this.getHeight());
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
    public void setPontLabel(int sc){
        pontLabel.setText("Pont: "+sc);
    }
    public void setHpLabel(int h){
        hpLabel.setText("Hápé: "+h);
    }

}
