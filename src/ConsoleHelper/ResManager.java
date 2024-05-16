package ConsoleHelper;

import net.mikekohn.java_grinder.SegaGenesis;

public class ResManager {
    private class SprConfE {
        public static final int SPRITE_INDEX = 0;
        public static final int SPRITE_LOCATION = 1;
        public static final int PAL_INDEX = 2;
        public static final int X = 3;
        public static final int Y = 4;
        public static final int NEXT_LINK = 5;
        public static final int CONF_WORD1 = 6;
        public static final int CONF_WORD2 = 7;        
    }
    
    public static final int SPR_PAL_INDEX = 16;
    public static void drawBG(short[] image, short[] palette, int[] pattern)
    {
        SegaGenesis.setPaletteColors(palette);
        SegaGenesis.setPatternTable(pattern);
        SegaGenesis.setImageData(image);
    }
    public static void drawSpr(int[] pattern, short[] palette, int[] config)
    {
        SegaGenesis.setPaletteColorsAtIndex(config[2], palette);
        SegaGenesis.setPatternTableAtIndex(config[1], pattern);    
        SegaGenesis.setSpritePosition(config[0], config[SprConfE.X], config[4]);

        SegaGenesis.setSpriteConfig1(config[0], config[6]);
        SegaGenesis.setSpriteConfig2(config[0], config[7]);   
    }
    public static void setSprTo0(int sprIndex){
        SegaGenesis.setSpritePosition(sprIndex, 0, 0);
    }

    public static void clearSpr(int location, int length){
        SegaGenesis.setPlotAddress(location);
        SegaGenesis.clearPatterns(length);     
    }

    // private int getConf(int[] conf, int key) {
    //   for (int i = 0; i < conf.length; i++) {
    //       if (conf[i] - key == 0) {
    //           return key + i;
    //       }
    //   }
    //   return -1;
    // }
}
