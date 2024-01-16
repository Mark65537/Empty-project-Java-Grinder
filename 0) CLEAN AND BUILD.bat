@echo off

if exist "0) CLEAN.bat" (
    call "0) CLEAN.bat"
) else (
    echo Файл "0) CLEAN.bat" отсутствует.
)

if exist "0) BUILD.bat" (
    call "0) BUILD.bat"
) else (
    echo Файл "0) BUILD.bat" отсутствует.
)