import net.mikekohn.java_grinder.SegaGenesis;

//Imports
// import res.hitboxes.*;
import res.sprites.*;
import res.images.*;
// import res.music.*;
// import res.sounds.*;

public class Main
{  
  // static final int CENTER_X = 270;
  // static final int CENTER_Y = 230;
  static public void main(String[] args)
  {
    
    // Set Font.
    SegaGenesis.loadFonts();
    SegaGenesis.clearText();

    // Переменные
    int keyCode = 0;
    boolean pressed = false;
    boolean isPlayed = true;
    int speed=1;
    int state = GameState.LOGO;    
    
    int x=SprArrow.X;
    int y=SprArrow.Y;
    
    ImgJavaGrinder.draw();  
                  
    SprArrow.draw();

    // PlayBackgroundMusic();
    

    
  }

  
}    