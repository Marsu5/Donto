package hu.tokingame.donto.Game1;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.donto.Game2.Game2Stage;
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
    Game2Stage game2Stage;
    MyLabel pontLabel, hpLabel, powerup;
    boolean secondGame;

    public ControlStage(MyGdxGame game, GameStage sg) {
        super(new ExtendViewport(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT,new OrthographicCamera(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT)),new SpriteBatch(), game);
        gameStage = sg;
        secondGame = false;
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
        addActor(powerup = new MyLabel("Pálinka eddig tart: "+ Math.rint(gameStage.getPowerUPLeft()*10)/10.0f, MyLabel.style2){
            @Override
            public void init() {
                super.init();
                setPosition(0, Globals.WORLD_HEIGHT-this.getHeight()*3);
                setVisible(false);
            }
        });


    }

    public ControlStage(MyGdxGame game, Game2Stage sg) {
        super(new ExtendViewport(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT,new OrthographicCamera(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT)),new SpriteBatch(), game);
        game2Stage = sg;
        secondGame = true;
        addActor(pontLabel = new MyLabel("Pont: "+ game2Stage.getScore(), MyLabel.style2){
            @Override
            public void init() {
                super.init();
                setPosition(0, Globals.WORLD_HEIGHT-this.getHeight());
            }
        });
        addActor(hpLabel = new MyLabel("Hápé: "+ game2Stage.getHp(), MyLabel.style2){
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
        if(secondGame){
            setPontLabel(game2Stage.getScore());
            setHpLabel(game2Stage.getHp());
        }else{
            setPontLabel(gameStage.getScore());
            setHpLabel(gameStage.getHp());
            if(gameStage.isPowerUP()){
                setPowerup(gameStage.getPowerUPLeft());
                if(!powerup.isVisible()) powerup.setVisible(true);
            }else{
                if(powerup.isVisible()) powerup.setVisible(false);
            }
        }

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

    public void setPowerup(float h){
        powerup.setText("Pálinka eddig tart: "+ Math.rint(h*10)/10.0f);
    }

}
