@echo off
REM Build and Run Script for Java BST Application (Windows)
REM Usage: build.bat [compile|test|run]

setlocal enabledelayedexpansion

echo.
echo ======================================================================
echo Java Binary Search Tree Application
echo ======================================================================
echo.

REM Create bin directory if it doesn't exist
if not exist bin mkdir bin

REM Compile
echo Compiling Java files...
cd /d %~dp0
javac -d bin src\*.java

if errorlevel 1 (
    echo.
    echo Compilation failed!
    exit /b 1
)

echo Compilation successful!
echo.

REM Run tests by default
if "%1"=="" goto test
if "%1"=="test" goto test
if "%1"=="run" goto run
if "%1"=="gui" goto run
if "%1"=="compile" goto end

:test
echo Running unit tests...
cd bin
java src.BSTTest
cd ..
goto end

:run
echo Launching GUI application...
cd bin
start javaw src.BSTApplication
cd ..
goto end

:end
if "%1"=="compile" (
    echo Build complete. Run 'build.bat run' to launch the application.
)
echo.
