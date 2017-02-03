package hu.tokingame.donto.MyBaseClasses;

import hu.tokingame.donto.Global.Assets;

/**
 * Created by davim on 2017. 02. 03..
 */

public class BackgroundTextButton extends MyTextButton {
    private int color;

    public BackgroundTextButton(String text, int c) {
        super(text);
        color = c;
        setFont(Assets.manager.get(Assets.ANTON_FONT_B));

        /*switch (color){
            case 1: setTexture(Assets.manager.get(Assets.BUTTON_BG)); break;
            case 2: setTexture(Assets.manager.get(Assets.BUTTON_BG_RED)); break;
            default: break;
        }*/
    }
    public BackgroundTextButton(String text){
        super(" "+text+" ");
        setFont(Assets.manager.get(Assets.ANTON_FONT_B));
        //setTexture(Assets.manager.get(Assets.BUTTON_BG));
    }

    @Override
    protected void init() {
        super.init();
    }
}
