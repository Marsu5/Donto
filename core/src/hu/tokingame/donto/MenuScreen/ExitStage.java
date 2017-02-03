package hu.tokingame.donto.MenuScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.donto.Global.Assets;
import hu.tokingame.donto.MyBaseClasses.BackgroundTextButton;
import hu.tokingame.donto.MyBaseClasses.MyStage;
import hu.tokingame.donto.Global.Globals;
import hu.tokingame.donto.MyBaseClasses.MyLabel;
import hu.tokingame.donto.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.donto.MyGdxGame;

/**
 * Created by davimatyi on 2016. 12. 06..
 */

public class ExitStage extends MyStage {
    public ExitStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
        Gdx.input.setCatchBackKey(true);



    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK){
            game.setScreenBackByStackPop();
        }
        return false;
    }


    @Override
    public void init() {

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.MENUHATTER)){
            @Override
            public void init() {
                super.init();
                setPosition(0,0);
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
            }
        });

        addActor(new MyLabel("Biztosan kilépsz?",MyLabel.style1){
            @Override
            public void init() {
                super.init();
                this.setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2f, Globals.WORLD_HEIGHT/2-this.getHeight()/2f+200);
            }
        });

        addActor(new BackgroundTextButton("  Igen  "){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2f-200, Globals.WORLD_HEIGHT/2-this.getWidth()/2f);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        System.exit(0);
                    }
                });
            }
        });

        addActor(new BackgroundTextButton("  Nem  "){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2f+200, Globals.WORLD_HEIGHT/2-this.getWidth()/2f);
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
}

