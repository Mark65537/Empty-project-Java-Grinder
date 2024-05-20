import net.mikekohn.java_grinder.SegaGenesis;

//resource Imports
// import hitboxes.*;
import sprites.*;
import images.*;

// import music.*;
// import sounds.*;
//end resource Imports
import ConsoleHelper.*;

public class Main
{  
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
    boolean isFlipH = false;
    boolean isFlipV = false;

    initDraw();
    // PlayBackgroundMusic();
    
    // Game loop
    while(isPlayed) {        

      keyCode = SegaGenesis.getJoypadValuePort1();
      
      //проверка нажатий кнопок
      if(!pressed){
        // проверка нажатия кнопки вверх 0x81
        if((byte)keyCode == -127 && y > 0x7F) {                      
          SegaGenesis.setSpritePosition(0, x, y -= speed);
          Timer.wait(1);
        }

        // проверка нажатия кнопки вниз 0x82            
        if((byte)keyCode == -126 && y < 0x160) {                      
          SegaGenesis.setSpritePosition(0, x, y += speed);
          Timer.wait(1);
        }
              
        // проверка нажатия кнопки влево 0x84                   
        if((byte)keyCode == -124 && x > 0x7E) {                      
          SegaGenesis.setSpritePosition(0, x -= speed, y);
          Timer.wait(1);                
        }

        // проверка нажатия кнопки вправо 0x88         
        if((byte)keyCode == -120 && x < 0x1C0) {                      
          SegaGenesis.setSpritePosition(0, x += speed, y);
          Timer.wait(1);
        }

        // проверка нажатия кнопки A 0xD080        
        if(keyCode == 0xD080) {
          if(isFlipH) {
            SegaGenesis.setSpriteConfig2(SprArrow.SPRITE_INDEX, SprArrow.CONF_WORD2);
            isFlipH = false;
          }
          else{
            ResManager.flipHSpr(SprArrow.SPRITE_INDEX, SprArrow.CONF_WORD2);
            isFlipH = true;
          }
          pressed = true;
        }

        // проверка нажатия кнопки B 0x90         
        if((byte)keyCode == (byte)0x90) {
          ResManager.setSprTo0(SprArrow.SPRITE_INDEX);                    
          pressed = true;
        }

        // // проверка нажатия кнопки C 0xA0         
        if((byte)keyCode == (byte)0xA0) {                      
          if(isFlipV) {
            SegaGenesis.setSpriteConfig2(SprArrow.SPRITE_INDEX, SprArrow.CONF_WORD2);
            isFlipV = false;
          }
          else{
            ResManager.flipVSpr(SprArrow.SPRITE_INDEX, SprArrow.CONF_WORD2);
            isFlipV = true;
          }
          pressed = true;
        }

        // проверка нажатия кнопки START 0xE080         
        if(keyCode == 0xE080) {
          if(state == GameState.LOGO) {
                             
            state = GameState.INFO;
          }
          else if (state == GameState.INFO) {
            
            state = GameState.INGAME;
          }
          else if (state == GameState.GAMEOVER) {                  

            state = GameState.LOGO;
          }
          pressed = true;
        }
      }
      else if(keyCode == 0xCC80 || keyCode == 0xC080) {
        pressed = false;          
      }
      
    }  
  }

  public static void initDraw() {
    //Background
    ResManager.drawBG(ImgJavaGrinder.pattern, ImgJavaGrinder.palette, ImgJavaGrinder.image);  
    
    //Sprites
    ResManager.drawSpr(SprArrow.pattern, SprArrow.palette, SprArrow.config);
  }

  
}    