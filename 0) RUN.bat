@REM start out\Main.smd

@echo off
setlocal enabledelayedexpansion

rem Initialize the file variable
set "file="

rem Find the first .smd or .gen file
for %%f in (out\*.smd out\*.gen) do (
    if not defined file set "file=%%f"
)

rem Check if a file was found and launch it, otherwise show a message and pause
if defined file (
    start "" "!file!"
) else (
    echo Cant find a .smd or .gen file in out
    pause
)
