package ConsoleHelper;

import net.mikekohn.java_grinder.SegaGenesis;

/**
 * ResManager - класс для управления ресурсами на платформе Sega Genesis.
 */
public class ResManager {
    /**
     * SprConfE - внутренний класс вместо перечисления, содержащий индексы массива int[] config для спрайтов.
     */
    private class SprConfE {
        public static final int SPRITE_INDEX = 0;
        public static final int SPRITE_LOCATION = 1;
        public static final int PAL_INDEX = 2;
        public static final int X = 3;
        public static final int Y = 4;
        public static final int CONF_WORD1 = 5;
        public static final int CONF_WORD2 = 6;        
    }

    public static final int SPR_PAL_INDEX = 16;

    /**
     * Рисует задний фон.
     *
     * @param pattern массив данных тайлов
     * @param palette массив палитры
     * @param tileMap массив тайловой карты
     */
    public static void drawBG(int[] pattern, short[] palette, short[] tileMap) {
        SegaGenesis.setPaletteColors(palette);
        SegaGenesis.setPatternTable(pattern);
        SegaGenesis.setImageData(tileMap);
    }

    /**
     * Рисует спрайт.
     *
     * @param pattern массив данных паттернов
     * @param palette массив данных палитры
     * @param config массив конфигурации спрайта
     */
    public static void drawSpr(int[] pattern, short[] palette, int[] config) {
        SegaGenesis.setPaletteColorsAtIndex(config[SprConfE.PAL_INDEX], palette);
        SegaGenesis.setPatternTableAtIndex(config[SprConfE.SPRITE_LOCATION], pattern);    
        SegaGenesis.setSpritePosition(config[SprConfE.SPRITE_INDEX], config[SprConfE.X], config[SprConfE.Y]);

        SegaGenesis.setSpriteConfig1(config[SprConfE.SPRITE_INDEX], config[SprConfE.CONF_WORD1]);
        SegaGenesis.setSpriteConfig2(config[SprConfE.SPRITE_INDEX], config[SprConfE.CONF_WORD2]);   
    }

    /**
     * Устанавливает позицию спрайта в (0, 0).
     *
     * @param sprIndex индекс спрайта
     */
    public static void setSprTo0(int sprIndex) {
        SegaGenesis.setSpritePosition(sprIndex, 0, 0);
    }

    /**
     * Очищает паттерны спрайта.
     *
     * @param location позиция в VDP
     * @param length количество паттернов для очистки
     */
    public static void clearSpr(int location, int length) {
        SegaGenesis.setPlotAddress(location);
        SegaGenesis.clearPatterns(length);     
    }

    public static void flipHSpr(int SPRITE_INDEX, int confWord2){
        SegaGenesis.setSpriteConfig2(SPRITE_INDEX, confWord2 | SegaGenesis.SPRITE_CONFIG2_HORIZONTAL_FLIP);
    }

    public static void flipVSpr(int spriteIndex, int confWord2) {
        SegaGenesis.setSpriteConfig2(spriteIndex, confWord2 | SegaGenesis.SPRITE_CONFIG2_VERTICAL_FLIP);
    }

    /*
    // Пример функции для получения индекса конфигурации по ключу
    // private int getConf(int[] conf, int key) {
    //   for (int i = 0; i < conf.length; i++) {
    //       if (conf[i] - key == 0) {
    //           return key + i;
    //       }
    //   }
    //   return -1;
    // }
    */
}
