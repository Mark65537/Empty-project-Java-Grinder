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

    initDraw();
    // PlayBackgroundMusic();
    
    // Game loop
    while(isPlayed) {        

      keyCode = SegaGenesis.getJoypadValuePort1();
      
      //проверка нажатий кнопок
      if(!pressed){
        for (int i = 0x0000; i <= 0xF000; i+=0x0100) {
              // проверка нажатия кнопки вверх
              if(keyCode == (i+0x0081) && y > 0x7F) {                      
                SegaGenesis.setSpritePosition(0, x, y -= speed);
                break;
              }
              
              // проверка нажатия кнопки вниз            
              if(keyCode == (i+0x0082) && y < 0x160) {                      
                SegaGenesis.setSpritePosition(0, x, y += speed);
                break;
              }
              
              // проверка нажатия кнопки влево                    
              if(keyCode == (i+0x0084) && x > 0x7E) {                      
                SegaGenesis.setSpritePosition(0, x -= speed, y);
                break;                
              }

              // проверка нажатия кнопки вправо          
              if(keyCode == (i+0x0088) && x < 0x1C0) {                      
                SegaGenesis.setSpritePosition(0, x += speed, y);
                break;
              }

              // проверка нажатия кнопки A         
              if(keyCode == (i+0xD080)) {

                pressed = true;
                break;
              }

              // проверка нажатия кнопки B          
              if(keyCode == (i+0x0090)) {

                ResManager.setSprTo0(SprArrow.SPRITE_INDEX);
                          
                pressed = true;
                break;
              }

              // проверка нажатия кнопки C          
              if(keyCode == (i+0x00A0)) {                      

                pressed = true;
                break;
              }

              // проверка нажатия кнопки START          
              if(keyCode == (i+0xE080)) {
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
                break;
              }
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