# Находим все файлы .class в папке Images
SPRITES := $(patsubst %.java,%.class,$(wildcard res/sprites/*.java))
IMAGES := $(patsubst %.java,%.class,$(wildcard res/images/*.java))

OUTPUT_DIR := out/

GAME_NAME := "Empty-project"
# Находим все файлы .class в текущей директории
CURRENT_DIR := $(patsubst %.java,%.class,$(wildcard *.java))

CLASSES= $(SPRITES) $(IMAGES) $(SCRIPT_DIR) $(CURRENT_DIR)#SegaGenesisJavaDemo.class ImginfoScreen.class Imgplus.class 

default: $(CLASSES)

grind: $(CLASSES)
	../../java_grinder Main.class $(OUTPUT_DIR)$(GAME_NAME).asm sega_genesis

	for dir in gfx hitboxes images music palettes sounds sprites tilesets; do \
		sed -i "s/res\/$$dir\//res_$$dir\_/g" $(OUTPUT_DIR)$(GAME_NAME).asm; \
	done

	../../naken_asm -I ~ -l -type bin -o $(OUTPUT_DIR)$(GAME_NAME).smd $(OUTPUT_DIR)$(GAME_NAME).asm

dac:
	naken_asm -l -type bin -o z80_play_dac.bin z80_play_dac.asm
	go run bin2java.go z80_play_dac.bin | grep -v INFO | sed 's/ClassName/PlayTitleSample/' | sed 's/code/z80_code/' > PlayTitleSample.java

synth:
	naken_asm -l -type bin -o z80_play_end_song.bin z80_play_end_song.asm
	go run bin2java.go z80_play_end_song.bin | grep -v INFO | sed 's/ClassName/PlayEndSong/' | sed 's/code/z80_code/' > PlayEndSong.java

song:
	naken_asm -l -type bin -o z80_play_title_song.bin z80_play_title_song.asm
	go run bin2java.go z80_play_title_song.bin | grep -v INFO | sed 's/ClassName/PlayTitleSong/' | sed 's/code/z80_code/' > PlayTitleSong.java

laser:
	naken_asm -l -type bin -o z80_play_laser.bin z80_play_laser.asm
	go run bin2java.go z80_play_laser.bin | grep -v INFO | sed 's/ClassName/PlayLaser/' | sed 's/code/z80_code/' > PlayLaser.java

setup:
	naken_asm -l -type bin -o z80_setup_synth.bin z80_setup_synth.asm
	go run bin2java.go z80_setup_synth.bin | grep -v INFO | sed 's/ClassName/SetupSynth/' | sed 's/code/z80_code/' > SetupSynth.java

%.class: %.java
	javac -classpath ../../build/JavaGrinder.jar:. $*.java

clean:
	find . -name "*.class" -delete
	@rm -f *.hex *.lst *.class sega_genesis_java_demo.asm *.bin *.rpk
	@rm -rf cfg nvram snap
	@echo "Clean!"

