package ConsoleHelper;
import net.mikekohn.java_grinder.SegaGenesis;

public class Text {
    static final int MAX_WIDTH = 28;
    static final int MAX_HEIGHT = 40;

    /**
     * Prints text at the default position (0,0).
     * @param text The text to be printed.
     */
    public static void print(String text) {
        SegaGenesis.setCursor(0, 0);
        SegaGenesis.print(text);
    }
    /**
     * Prints text at the specified position.
     * @param text The text to be printed.
     * @param x The x-coordinate for the text position.
     * @param y The y-coordinate for the text position.
     */
    public static void print(String text, int x, int y) {
        SegaGenesis.setCursor(x, y);
        SegaGenesis.print(text);
    }

    /**
     * Clears the text screen.
     */
    public static void clear() {
        SegaGenesis.clearText();
    }

    /**
     * Clears the text screen and prints new text at the default position.
     * @param text The text to be printed after clearing the screen.
     */
    public static void clearAndPrint(String text) {
        clear();
        print(text);        
    }

    /**
     * Clears the text screen and prints new text at the specified position.
     * @param text The text to be printed after clearing the screen.
     * @param x The x-coordinate for the text position.
     * @param y The y-coordinate for the text position.
     */
    public static void clearAndPrint(String text, int x, int y) {
        clear();
        print(text, x, y);        
    }

    /**
     * Prints a single character at the specified position.
     * @param chr The character to be printed.
     * @param x0 The x-coordinate for the character position.
     * @param y0 The y-coordinate for the character position.
     */
    public static void print(char chr, int x0, int y0) {        
        SegaGenesis.setCursor(x0, y0);
        SegaGenesis.printChar(chr);
    }

    // The following method is commented out due to an unimplemented opcode error.
    // Opcode (52) 'caload' unimplemented
    // Error with caload (0x34) instruction
    /**
     * Prints an array of characters at the specified position, handling line wrapping.
     * @param text The array of characters to be printed.
     * @param x0 The starting x-coordinate for the text position.
     * @param y0 The starting y-coordinate for the text position.
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

}
