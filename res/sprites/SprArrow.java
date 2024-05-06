package sprites;

import net.mikekohn.java_grinder.SegaGenesis;

public class SprArrow
{
  
    public static final int X=270;    
    public static final int Y=230;
    public static final int SIZE=32;
    public static final int SPRITE_INDEX = 0;
    public static final int SPRITE_LOCATION = 0x04A0;
    public static final int NEXT_LINK = SPRITE_INDEX + 1;
    

  public static void draw()
  {
    
          SegaGenesis.setPaletteColorsAtIndex(16, palette);
          SegaGenesis.setPatternTableAtIndex(SPRITE_LOCATION, pattern);
          
          SegaGenesis.setSpritePosition(SPRITE_INDEX, X, Y);
          SegaGenesis.setSpriteConfig1(
                                        SPRITE_INDEX,
                                        SegaGenesis.SPRITE_CONFIG1_HORIZONTAL_SIZE_2_CELL | 
                                        SegaGenesis.SPRITE_CONFIG1_VERTICAL_SIZE_4_CELL |
                                        NEXT_LINK
                                      );
          SegaGenesis.setSpriteConfig2(
                                        SPRITE_INDEX, 
                                        SegaGenesis.SPRITE_CONFIG2_PALETTE_1 | 
                                        SPRITE_LOCATION
                                      );
        
  }

  
    public static void setTo0(){
      SegaGenesis.setSpritePosition(SPRITE_INDEX, 0, 0);
    }
  
    public static void clear(){
      SegaGenesis.setPatternTableAtIndex(SPRITE_LOCATION, clearPattern);
    }
    

  public static int[] pattern =
  {    
        //Pattern 0
        0x01100000, 0x01100000, 0x01110000, 0x01110000, 
    0x01121100, 0x01123310, 0x01123310, 0x01123331, 
    
        //Pattern 1
        0x01123331, 0x01123333, 0x01123333, 0x01122233, 
    0x01122233, 0x01122233, 0x01122233, 0x01122233, 
    
        //Pattern 2
        0x01122223, 0x01122223, 0x01122222, 0x01122222, 
    0x01122222, 0x01121111, 0x01121111, 0x01111101, 
    
        //Pattern 3
        0x01111101, 0x01110000, 0x01110000, 0x01100000, 
    0x00000000, 0x00000000, 0x00000000, 0x00000000, 
    
        //Pattern 4
        0x00000000, 0x00000000, 0x00000000, 0x00000000, 
    0x00000000, 0x00000000, 0x00000000, 0x10000000, 
    
        //Pattern 5
        0x10000000, 0x31000000, 0x31000000, 0x33110000, 
    0x33331000, 0x33331000, 0x33333110, 0x33333110, 
    
        //Pattern 6
        0x33333331, 0x33333331, 0x23111111, 0x23111111, 
    0x23110000, 0x13331000, 0x13331000, 0x11331000, 
    
        //Pattern 7
        0x11331000, 0x01333110, 0x01333110, 0x01113110, 
    0x00113110, 0x00113110, 0x00111110, 0x00111110, 
        
  };

  

  public static short[] palette =
  {
    
    0xCAE, 0x000, 0xCCC, 0xEEE, 
  };

  
    public static int[] clearPattern =
    {
      
      
        //Pattern 0
        0x00000000, 0x00000000, 0x00000000, 0x00000000, 
    0x00000000, 0x00000000, 0x00000000, 0x00000000, 
    
        //Pattern 1
        0x00000000, 0x00000000, 0x00000000, 0x00000000, 
    0x00000000, 0x00000000, 0x00000000, 0x00000000, 
    
        //Pattern 2
        0x00000000, 0x00000000, 0x00000000, 0x00000000, 
    0x00000000, 0x00000000, 0x00000000, 0x00000000, 
    
        //Pattern 3
        0x00000000, 0x00000000, 0x00000000, 0x00000000, 
    0x00000000, 0x00000000, 0x00000000, 0x00000000, 
    
        //Pattern 4
        0x00000000, 0x00000000, 0x00000000, 0x00000000, 
    0x00000000, 0x00000000, 0x00000000, 0x00000000, 
    
        //Pattern 5
        0x00000000, 0x00000000, 0x00000000, 0x00000000, 
    0x00000000, 0x00000000, 0x00000000, 0x00000000, 
    
        //Pattern 6
        0x00000000, 0x00000000, 0x00000000, 0x00000000, 
    0x00000000, 0x00000000, 0x00000000, 0x00000000, 
    
        //Pattern 7
        0x00000000, 0x00000000, 0x00000000, 0x00000000, 
    0x00000000, 0x00000000, 0x00000000, 0x00000000, 
    
    };
    
}

