import net.mikekohn.java_grinder.SegaGenesis;

public class Text {
    static final int MAX_WIDTH = 28;
    static final int MAX_HEIGHT = 40;
    public static void print(char[] text, int x, int y) {

        int len = text.length();
        
        SegaGenesis.setCursor(x, y++);
        SegaGenesis.print(text);
    }
}
