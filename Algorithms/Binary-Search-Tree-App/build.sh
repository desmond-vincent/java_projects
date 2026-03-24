#!/bin/bash

# Build and Run Script for Java BST Application
# Usage: ./build.sh [compile|test|run]

set -e

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
cd "$SCRIPT_DIR"

# Colors
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

echo -e "${YELLOW}=== Java BST Application ===${NC}"
echo ""

# Create bin directory if it doesn't exist
mkdir -p bin

# Compile
echo -e "${YELLOW}Compiling Java files...${NC}"
javac -d bin src/*.java

if [ $? -eq 0 ]; then
    echo -e "${GREEN}✓ Compilation successful${NC}"
else
    echo -e "${RED}✗ Compilation failed${NC}"
    exit 1
fi

# Run tests by default if no argument provided
if [ "$1" = "test" ] || [ -z "$1" ]; then
    echo ""
    echo -e "${YELLOW}Running tests...${NC}"
    cd bin
    java src.BSTTest
    cd ..
fi

# Run application
if [ "$1" = "run" ] || [ "$1" = "gui" ]; then
    echo ""
    echo -e "${YELLOW}Launching GUI application...${NC}"
    cd bin
    java src.BSTApplication
    cd ..
fi

# Only compile
if [ "$1" = "compile" ]; then
    echo ""
    echo -e "${GREEN}Build complete. Use './build.sh run' to launch the application.${NC}"
fi
