package hu.tokingame.donto.Global;


import java.util.Vector;

/**
 * Created by M on 10/14/2016.
 */


public class Globals {
    public static final String CHARS = "0123456789öüóqwertzuiopőúasdfghjkléáűíyxcvbnm'+!%/=()ÖÜÓQWERTZUIOPŐÚASDFGHJKLÉÁŰÍYXCVBNM?:_*<>#&@{}[],-.";
    public static final float WORLD_WIDTH = 1280;
    public static final float WORLD_HEIGHT = 720;


    public static boolean music = true;
    public static boolean host = false;
    public static boolean multiPlayer = false;
    public static boolean dead = false;

    public static String SCORE1 = "score1";
    public static String SCORE2 = "score2";

    public static Mode gameMode = Mode.SinglePlayer;

    public static Vector<Integer> MaxScores1 = new Vector(), MaxScores2 = new Vector();

    public static float randomF(float a, float b){return (float) (Math.random()*(b-a+1)+a);}

    public static int random(int a, int b){return (int) (Math.random()*(b-a+1)+a);}




}


