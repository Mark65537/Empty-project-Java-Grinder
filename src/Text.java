import net.mikekohn.java_grinder.SegaGenesis;

public class Text {
    static final int MAX_WIDTH = 28;
    static final int MAX_HEIGHT = 40;
    public void Draw(String text) {
        int x = 4;
        int y = 1;
        int len = text.length();
        
        SegaGenesis.setCursor(x, y++);
        SegaGenesis.print(text);
    }
}
