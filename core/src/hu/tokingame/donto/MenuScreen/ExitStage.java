package hu.tokingame.donto.MenuScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.donto.MyBaseClasses.MyStage;
import hu.tokingame.donto.Global.Globals;
import hu.tokingame.donto.MyBaseClasses.MyLabel;
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

    }
}

