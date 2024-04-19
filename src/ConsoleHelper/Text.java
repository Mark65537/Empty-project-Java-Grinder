package ConsoleHelper;
import net.mikekohn.java_grinder.SegaGenesis;

public class Text {
    static final int MAX_WIDTH = 28;
    static final int MAX_HEIGHT = 40;

    public static void print(String text) {
        SegaGenesis.setCursor(0, 0);
        SegaGenesis.print(text);
    }
    public static void print(String text, int x, int y) {
        SegaGenesis.setCursor(x, y);
        SegaGenesis.print(text);
    }

    public static void clear() {
        SegaGenesis.clearText();
    }

    public static void clearAndPrint(String text) {
        clear();
        print(text);        
    }

    public static void clearAndPrint(String text, int x, int y) {
        clear();
        print(text, x, y);        
    }

    /**
     * Unimplemented function.
     *
     * @param  text     description of parameter
     * @param  x0       description of parameter
     * @param  y0       description of parameter
     */
    // public static void print(char[] text, int x0, int y0) {
    //     int index = 0;
    //     int textLen = text.length;
    //     int x = x0;
    //     int y = y0;
    //     if(x0 + textLen < MAX_WIDTH) {
    //         for(x = 0; x < textLen; x++) {
    //             SegaGenesis.setCursor(x0 + x, y0);
    //             SegaGenesis.printChar(text[x]);                
    //         }
    //     }
    //     else{
    //         while (index < textLen) {
    //             if(x >= MAX_WIDTH) {
    //                 x = 0;
    //                 y++;
    //             }
    //             SegaGenesis.setCursor(x, y);
    //             SegaGenesis.printChar(text[index]);
    //             x++;
    //             index++;
    //         }
    //     }
    // }
    
    // public static void print(char chr, int x0, int y0) {        
    //     SegaGenesis.setCursor(x0, y0);
    //     SegaGenesis.printChar(chr);
    // }

}
