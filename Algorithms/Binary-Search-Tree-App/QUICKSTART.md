# Java BST Application - Quick Start Guide

## Installation & Setup

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Windows, macOS, or Linux

### Download JDK
- **Windows/macOS/Linux:** https://www.oracle.com/java/technologies/downloads/
- Or use: `sudo apt install default-jdk` (Linux)

### Verify Installation
```bash
java -version
javac -version
```

---

## Running the Application

### Option 1: Using Build Script (Recommended)

**Linux/macOS:**
```bash
chmod +x build.sh
./build.sh run
```

**Windows:**
```bash
build.bat run
```

### Option 2: Manual Compilation

```bash
# Step 1: Compile
javac -d bin src/*.java

# Step 2: Run tests
java -cp bin src.BSTTest

# Step 3: Run GUI
java -cp bin src.BSTApplication
```

### Option 3: Create Standalone JAR

```bash
# Compile
javac -d bin src/*.java

# Create manifest
echo "Manifest-Version: 1.0" > Manifest.txt
echo "Main-Class: src.BSTApplication" >> Manifest.txt

# Create JAR
jar cvfm BSTApplication.jar Manifest.txt -C bin .

# Run JAR
java -jar BSTApplication.jar
```

---

## First Run: Expected Behavior

1. **GUI Window Opens**
   - Left side: Empty tree canvas with message "Create a tree to begin"
   - Right side: 7 menu buttons and status panel

2. **Click "1. Create BST (1-7)"**
   - Dialog appears showing tree structure
   - Tree visualization displays on canvas
   - Status updates to show: "Active, 7 nodes, Height: 2"

3. **Click "2. Add Node"**
   - Input dialog appears
   - Enter any integer (e.g., 8)
   - Tree updates automatically

4. **Click "4. InOrder Traversal"**
   - Shows: 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8

5. **Click "3. Delete Node"**
   - Input dialog appears
   - Enter value to delete (e.g., 2)
   - Tree restructures automatically

6. **Click "5. PreOrder Traversal"**
   - Shows tree in root-first order

7. **Click "6. PostOrder Traversal"**
   - Shows tree in root-last order

---

## Testing

### Run All Tests
```bash
# Using build script
./build.sh test

# Or manually
javac -d bin src/*.java
java -cp bin src.BSTTest
```

### Expected Output
```
======================================================================
Binary Search Tree - Unit Test Suite
======================================================================

✓ testInsertSingleNode
✓ testInsertMultipleNodes
✓ testInsertDuplicate
✓ testSearchExisting
✓ testSearchNonexisting
✓ testSearchEmptyTree
✓ testDeleteLeafNode
✓ testDeleteNodeOneChild
✓ testDeleteNodeTwoChildren
✓ testDeleteRoot
✓ testDeleteNonexistent
✓ testDeleteEmptyTree
✓ testInorderTraversal
✓ testInorderEmpty
✓ testPreorderTraversal
✓ testPreorderEmpty
✓ testPostorderTraversal
✓ testPostorderEmpty
✓ testBSTPropertyAfterInsert
✓ testBSTPropertyAfterDelete
✓ testHeightEmpty
✓ testHeightSingleNode
✓ testHeightBalancedTree
✓ testHeightUnbalancedTree
✓ testMultipleOperations
✓ testLargeTree

======================================================================
TEST SUMMARY
======================================================================
Tests Run: 27
Successes: 27
Failures: 0

✓ All tests passed!
```

---

## Menu Options Explained

| # | Option | Description | Input |
|---|--------|-------------|-------|
| 1 | Create BST (1-7) | Creates balanced tree with values 1-7 | None |
| 2 | Add Node | Inserts a new value | Integer |
| 3 | Delete Node | Removes a node by value | Integer |
| 4 | InOrder Traversal | Shows sorted values | None |
| 5 | PreOrder Traversal | Shows root-first order | None |
| 6 | PostOrder Traversal | Shows root-last order | None |
| 7 | Exit | Closes application | Confirmation |

---

## Example Workflow

### Create Tree
```
1. Click "1. Create BST (1-7)"
   Result: Tree with structure
           4
         /   \
        2     6
       / \   / \
      1   3 5   7
```

### Add Values
```
2. Click "2. Add Node" → Enter 8
   Tree becomes:
           4
         /   \
        2     6
       / \   / \
      1   3 5   7
             \
              8

3. Click "2. Add Node" → Enter 0
   Tree becomes:
           4
         /   \
        2     6
       / \   / \
      1  3 5   7
     /         \
    0          8
```

### View Traversals
```
4. Click "4. InOrder Traversal"
   Result: 0 → 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8
   (Sorted order)

5. Click "5. PreOrder Traversal"
   Result: 4 → 2 → 1 → 0 → 3 → 6 → 5 → 7 → 8
   (Root first)

6. Click "6. PostOrder Traversal"
   Result: 0 → 1 → 3 → 2 → 5 → 8 → 7 → 6 → 4
   (Root last)
```

### Delete Nodes
```
7. Click "3. Delete Node" → Enter 2
   Node 2 deleted, children promoted
   
8. Click "3. Delete Node" → Enter 7
   Node 7 deleted, child 8 promoted

9. Click "4. InOrder Traversal"
   Result: 0 → 1 → 3 → 4 → 5 → 6 → 8
```

---

## Common Issues

### Issue: "javac: command not found"
**Solution:**
- Install JDK (not just JRE)
- Add Java to system PATH
- Restart terminal after installation
- Verify: `javac -version`

### Issue: "ClassNotFoundException: src.BSTApplication"
**Solution:**
- Ensure bin/ directory exists: `mkdir -p bin`
- Recompile: `javac -d bin src/*.java`
- Run from project root directory
- Check working directory: `pwd`

### Issue: GUI window doesn't appear
**Solution:**
- Try explicit class path: `java -cp bin src.BSTApplication`
- On Linux, may need X11: `sudo apt install xvfb`
- Check Java version: `java -version` (must be 8+)

### Issue: Tests show "0 tests run"
**Solution:**
- Verify compilation: `ls -la bin/src/*.class`
- Check JDK version: `javac -version` (must be 8+)
- Try from project directory

---

## Project Structure

```
java_bst/
├── src/
│   ├── BSTNode.java           # Node class
│   ├── BinarySearchTree.java   # Core BST
│   ├── TreeCanvas.java         # GUI canvas
│   ├── BSTApplication.java     # Main app
│   └── BSTTest.java            # Tests
├── bin/                        # Compiled files (created)
├── build.sh                    # Build script (Linux/macOS)
├── build.bat                   # Build script (Windows)
├── README.md                   # Full documentation
└── QUICKSTART.md              # This file
```

---

## System Requirements

| Component | Requirement |
|-----------|-------------|
| **Java** | JDK 8 or higher |
| **RAM** | 256 MB minimum |
| **Disk** | 100 MB (with compiled files) |
| **OS** | Windows, macOS, Linux |

---

## Development Tips

### Edit Source Code
- Use any text editor: VS Code, IntelliJ, Eclipse, Vim, Notepad++
- All files in `src/` directory
- Compile after changes: `javac -d bin src/*.java`

### Add New Features
1. Edit `BinarySearchTree.java` for core logic
2. Edit `BSTApplication.java` for GUI changes
3. Add test cases in `BSTTest.java`
4. Compile and test: `./build.sh test`

### Create JAR for Distribution
```bash
javac -d bin src/*.java
echo "Main-Class: src.BSTApplication" > Manifest.txt
jar cvfm BSTApplication.jar Manifest.txt -C bin .
# Share BSTApplication.jar - runs with: java -jar BSTApplication.jar
```

---

## Next Steps

1. **Read:** Full documentation in README.md
2. **Explore:** Look at source code, especially BinarySearchTree.java
3. **Experiment:** Add/delete nodes, view different traversals
4. **Extend:** Try adding new features (see Enhancement Ideas in README.md)
5. **Test:** Run unit tests to verify everything works

---

## Quick Reference

```bash
# Compile
javac -d bin src/*.java

# Run tests
java -cp bin src.BSTTest

# Run GUI
java -cp bin src.BSTApplication

# Create JAR
jar cvfm BSTApplication.jar Manifest.txt -C bin .

# Run JAR
java -jar BSTApplication.jar

# Clean
rm -rf bin/
```

---

**You're ready to run the Java BST Application!**

For detailed information, see README.md
