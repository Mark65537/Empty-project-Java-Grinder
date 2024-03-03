@echo off

if exist "0) BUILD.bat" (
    call "0) BUILD.bat"
) else (
    echo Файл "0) BUILD.bat" отсутствует.
)

if exist "0) RUN.bat" (
    call "0) RUN.bat"
) else (
    echo Файл "0) RUN.bat" отсутствует.
)