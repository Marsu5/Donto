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

        addActor(new BackgroundTextButton(" Játék "){
            @Override
            protected void init() {
                super.init();
                this.setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2,400);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new GameScreen(game));
                    }
                });
            }
        });
        addActor(new BackgroundTextButton(" Disznóvadászat "){
            @Override
            protected void init() {
                super.init();
                this.setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2,300);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new Game2Screen(game));
                    }
                });
            }
        });
        addActor(new BackgroundTextButton(" Hogyan játsz "){
            @Override
            protected void init() {
                super.init();
                this.setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2,200);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new HowToPlayScreen(game));
                    }
                });
            }
        });
        addActor(new BackgroundTextButton(" Készítők "){
            @Override
            protected void init() {
                super.init();
                this.setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2,100);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new CreditsScreen(game));
                    }
                });
            }
        });
        addActor(new BackgroundTextButton("  Legjobb eredmények  "){
            @Override
            protected void init() {
                super.init();
                setPosition(10, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new HighScreen(game));
                    }
                });
            }
        });

        addActor(new BackgroundTextButton("  Kilépés  "){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH-250, Globals.WORLD_HEIGHT-100);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new ExitScreen(game));
                    }
                });
            }
        });
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.SPEAKER)) {
            @Override
            public void init() {
                super.init();
                setSize(100, 100);
                setPosition(10, Globals.WORLD_HEIGHT - this.getWidth() - 10);
                this.setPosition(10, Globals.WORLD_HEIGHT - this.getHeight() - 10);
                if (!Globals.music) setTexture(Assets.manager.get(Assets.NOSPEAKER));
                addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        musicToggle = !musicToggle;
                        Globals.music = !Globals.music;

                        if (musicToggle) {
                            setTexture(Assets.manager.get(Assets.SPEAKER));
                            Assets.manager.get(Assets.MAIN_MUSIC).play();
                        } else {
                            setTexture(Assets.manager.get(Assets.NOSPEAKER));
                            Assets.manager.get(Assets.MAIN_MUSIC).pause();
                        }
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

