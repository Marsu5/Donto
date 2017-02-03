package hu.tokingame.donto.MenuScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;


import hu.tokingame.donto.Game1.GameScreen;
import hu.tokingame.donto.Global.Assets;
import hu.tokingame.donto.Global.Globals;
import hu.tokingame.donto.MyBaseClasses.BackgroundTextButton;
import hu.tokingame.donto.MyBaseClasses.MyStage;
import hu.tokingame.donto.MyBaseClasses.MyTextButton;
import hu.tokingame.donto.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.donto.MyGdxGame;

/**
 * Created by M on 11/14/2016.
 */

public class MenuStage extends MyStage {


    public MenuStage(Viewport viewport, Batch batch, MyGdxGame game) {
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

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.MENUHATTER)){
            @Override
            public void init() {
                super.init();
                setPosition(0,0);
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
            }
        });

        addActor(new BackgroundTextButton("Játék"){
            @Override
            protected void init() {
                super.init();
                this.setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2,500);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new GameScreen(game));
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

