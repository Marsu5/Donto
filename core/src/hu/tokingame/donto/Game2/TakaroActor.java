package hu.tokingame.donto.Game2;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.donto.Global.Assets;
import hu.tokingame.donto.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.donto.MyBaseClasses.WorldActorGroup;
import hu.tokingame.donto.MyBaseClasses.WorldBodyEditorLoader;

/**
 * Created by davim on 2017. 02. 03..
 */

public class TakaroActor extends WorldActorGroup {

    private OneSpriteStaticActor actor;

    public TakaroActor(World world, WorldBodyEditorLoader loader, int index) {
        super(world, loader, id(index), BodyDef.BodyType.StaticBody, 0, 0.2f, 5, false);
        actor = new OneSpriteStaticActor(tex(index));
        actor.setSize(16, 9);
        setSize(16,9);
        addToWorld();

    }

    static String id(int k){
        switch(k){
            case 1: return "takaro1.png";
            case 2: return "takaro2.png";
            case 3: return "takaro3.png";
            case 4: return "takaro4.png";
            default: return "sample";
        }
    }
    static Texture tex(int k){
        switch(k){
            case 1: return Assets.manager.get(Assets.GAME2_TAKAR1);
            case 2: return Assets.manager.get(Assets.GAME2_TAKAR2);
            case 3: return Assets.manager.get(Assets.GAME2_TAKAR3);
            case 4: return Assets.manager.get(Assets.GAME2_TAKAR4);
            default: return Assets.manager.get(Assets.BL);
        }
    }
}
