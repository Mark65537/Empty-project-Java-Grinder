# Находим все файлы .class в папке Images
BIN_DIR := bin/
OUTPUT_DIR := out/
SRC_DIR := src/

# Находим все файлы .class в директориях директории
SPRITES := $(patsubst %.java,%.class,$(wildcard $(SRC_DIR)res/sprites/*.java))
IMAGES := $(patsubst %.java,%.class,$(wildcard $(SRC_DIR)res/images/*.java))
SRC_CLASSES := $(patsubst %.java,%.class,$(wildcard $(SRC_DIR)*.java))
CURRENT_DIR := $(patsubst %.java,%.class,$(wildcard *.java))

# получаем имя текущей директории
# GAME_NAME := $(shell echo ${PWD##*/})
GAME_NAME := "Game"

CLASSES= $(SPRITES) $(IMAGES) $(SRC_CLASSES)#SegaGenesisJavaDemo.class ImginfoScreen.class Imgplus.class 

default: $(CLASSES)

grind: $(CLASSES)
	../../java_grinder $(BIN_DIR)Main.class $(OUTPUT_DIR)$(GAME_NAME).asm sega_genesis

	# Вставьте сюда название пакета
	for dir in gfx ConsoleHelper hitboxes images music palettes sounds sprites tilesets; do \
		sed -i "s/$$dir\//$$dir\_/g" $(OUTPUT_DIR)$(GAME_NAME).asm; \
	done
	sed -i 's/,\.align 32/\
.align 32/g' $(OUTPUT_DIR)$(GAME_NAME).asm
	sed -i 's/dw\.align 32/.align 32/g' $(OUTPUT_DIR)$(GAME_NAME).asm
	
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
	javac -d bin -cp ../../build/JavaGrinder.jar:./res:./src:.:./lib:. $*.java

clean:
	find . -name "*.class" -delete
	@rm -f *.hex *.lst *.class sega_genesis_java_demo.asm *.bin *.rpk
	@rm -rf cfg nvram snap
	@echo "Clean!"

