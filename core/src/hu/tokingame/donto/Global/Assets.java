package hu.tokingame.donto.Global;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;

/**
 * Created by M on 10/7/2016.
 */

public class Assets {

    public static AssetManager manager;

    static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
    static {
        fontParameter.fontFileName = "fonts/Anton-Regular.ttf";
        fontParameter.fontParameters.size = 55;
        fontParameter.fontParameters.characters = hu.tokingame.donto.Global.Globals.CHARS;
        fontParameter.fontParameters.color = Color.WHITE;
    }

    static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter2 = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
    static {
        fontParameter2.fontFileName = "fonts/Anton-Regular.ttf";
        fontParameter2.fontParameters.size = 45;
        fontParameter2.fontParameters.characters = hu.tokingame.donto.Global.Globals.CHARS;
        fontParameter2.fontParameters.color = Color.BLACK;
    }

    static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter3 = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
    static {
        fontParameter3.fontFileName = "fonts/Anton-Regular.ttf";
        fontParameter3.fontParameters.size = 25;
        fontParameter3.fontParameters.characters = hu.tokingame.donto.Global.Globals.CHARS;
        fontParameter3.fontParameters.color = Color.BLACK;
    }

    // Fonts
    public static final AssetDescriptor<BitmapFont> ANTON_FONT = new AssetDescriptor<BitmapFont>("Fonts/Anton-Regular.ttf", BitmapFont.class, fontParameter);
    public static final AssetDescriptor<BitmapFont> ANTON_FONT_B = new AssetDescriptor<BitmapFont>("Fonts/Anton-Regular.ttf", BitmapFont.class, fontParameter2);
    public static final AssetDescriptor<BitmapFont> ANTON_FONT_B_P = new AssetDescriptor<BitmapFont>("Fonts/Anton-Regular.ttf", BitmapFont.class, fontParameter3);




    //<editor-fold desc="nem">
    public static final AssetDescriptor<Texture> BL = new AssetDescriptor<Texture>("badlogic.jpg", Texture.class);
    public static final AssetDescriptor<Texture> RONK = new AssetDescriptor<Texture>("textures/fa.png", Texture.class);
    public static final AssetDescriptor<Texture> HATTER = new AssetDescriptor<Texture>("textures/hatter.png", Texture.class);
    public static final AssetDescriptor<Texture> MALAC = new AssetDescriptor<Texture>("textures/malac.PNG", Texture.class);
    public static final AssetDescriptor<Texture> MALAC_FEJ = new AssetDescriptor<Texture>("textures/malac-fej.png", Texture.class);
    public static final AssetDescriptor<Texture> MALAC_SEGG = new AssetDescriptor<Texture>("textures/malac-segg.png", Texture.class);
    public static final AssetDescriptor<Texture> MENUHATTER = new AssetDescriptor<Texture>("textures/menuhatter.png", Texture.class);
    public static final AssetDescriptor<Texture> HALAL_HATTER = new AssetDescriptor<Texture>("textures/reszeg_csavo.JPG", Texture.class);
    public static final AssetDescriptor<Texture> GOMB_HATTER = new AssetDescriptor<Texture>("textures/gomb.png", Texture.class);
    public static final AssetDescriptor<Texture> KEK_HATTER = new AssetDescriptor<Texture>("textures/kekhatter.jpg", Texture.class);
    public static final AssetDescriptor<Texture> PIA1 = new AssetDescriptor<Texture>("textures/palesz.png", Texture.class);
    public static final AssetDescriptor<Texture> PIA2 = new AssetDescriptor<Texture>("textures/pia.png", Texture.class);
    public static final AssetDescriptor<Texture> PIA3 = new AssetDescriptor<Texture>("textures/pohar.png", Texture.class);
    public static final AssetDescriptor<Texture> SPEAKER = new AssetDescriptor<Texture>("textures/speaker_icon.png", Texture.class);
    public static final AssetDescriptor<Texture> NOSPEAKER = new AssetDescriptor<Texture>("textures/speaker_icon_disabled.png", Texture.class);
    public static final AssetDescriptor<Texture> KENYER = new AssetDescriptor<Texture>("textures/kenyer.png", Texture.class);
    public static final AssetDescriptor<Texture> PEN = new AssetDescriptor<Texture>("textures/PEN.png", Texture.class);
    public static final AssetDescriptor<Texture> GAME2_HATTER = new AssetDescriptor<Texture>("textures/game2hatter.jpg", Texture.class);
    public static final AssetDescriptor<Texture> GAME2_TAKAR1 = new AssetDescriptor<Texture>("textures/takaro1.png", Texture.class);
    public static final AssetDescriptor<Texture> GAME2_TAKAR2 = new AssetDescriptor<Texture>("textures/takaro2.png", Texture.class);
    public static final AssetDescriptor<Texture> GAME2_TAKAR3 = new AssetDescriptor<Texture>("textures/takaro3.png", Texture.class);
    public static final AssetDescriptor<Texture> GAME2_TAKAR4 = new AssetDescriptor<Texture>("textures/takaro4.png", Texture.class);

    //</editor-fold>

    //<editor-fold desc="sound">
    public static final AssetDescriptor<Sound> VISITAS1 = new AssetDescriptor<Sound>("sounds/squeal1.mp3", Sound.class);
    public static final AssetDescriptor<Sound> VISITAS2 = new AssetDescriptor<Sound>("sounds/squeal2.mp3", Sound.class);
    public static final AssetDescriptor<Sound> VISITAS3 = new AssetDescriptor<Sound>("sounds/squeal3.mp3", Sound.class);
    public static final AssetDescriptor<Music> MUSIC = new AssetDescriptor<Music>("sounds/zene.mp3", Music.class);
    //</editor-fold>




    public static void prepare() {
        manager = new AssetManager();
        Texture.setAssetManager(manager);
    }

    public static void load(){
        FileHandleResolver resolver = new InternalFileHandleResolver();
        manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
        manager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));

        //<editor-fold desc="Loading">
        manager.load(ANTON_FONT);
        manager.load(ANTON_FONT_B);
        manager.load(ANTON_FONT_B_P);
        manager.load(BL);
        manager.load(RONK);
        manager.load(HATTER);
        manager.load(MALAC);
        manager.load(MALAC_FEJ);
        manager.load(MALAC_SEGG);
        manager.load(MENUHATTER);
        manager.load(HALAL_HATTER);
        manager.load(GOMB_HATTER);
        manager.load(KEK_HATTER);
        manager.load(PIA1);
        manager.load(PIA2);
        manager.load(PIA3);
        manager.load(PEN);
        manager.load(KENYER);
        manager.load(SPEAKER);
        manager.load(NOSPEAKER);

        manager.load(GAME2_HATTER);
        manager.load(GAME2_TAKAR1);
        manager.load(GAME2_TAKAR2);
        manager.load(GAME2_TAKAR3);
        manager.load(GAME2_TAKAR4);

        manager.load(VISITAS1);
        manager.load(VISITAS2);
        manager.load(VISITAS3);
        manager.load(MUSIC);
        //</editor-fold>

    }

    public static void afterLoaded(){
        Assets.manager.get(Assets.MUSIC).setLooping(true);
        Assets.manager.get(Assets.MUSIC).play();
    }

    public static void unload(){
        manager.dispose();
    }

}
