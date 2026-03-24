package src;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Main GUI Application for Binary Search Tree
 * Professional Swing-based interface with dark theme
 */
public class BSTApplication extends JFrame {
    private BinarySearchTree bst;
    private TreeCanvas canvas;
    private JLabel statusLabel;
    private JLabel infoLabel;

    /**
     * Constructor - initializes the application
     */
    public BSTApplication() {
        this.bst = new BinarySearchTree();
        initializeUI();
    }

    /**
     * Initialize the user interface
     */
    private void initializeUI() {
        setTitle("Binary Search Tree Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setResizable(true);

        // Create main panel with split layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(15, 23, 42));

        // Left panel: Canvas
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(new Color(15, 23, 42));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel canvasTitle = new JLabel("Tree Visualization");
        canvasTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        canvasTitle.setForeground(new Color(226, 232, 240));
        leftPanel.add(canvasTitle, BorderLayout.NORTH);

        canvas = new TreeCanvas();
        leftPanel.add(canvas, BorderLayout.CENTER);

        // Right panel: Menu and controls
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(new Color(15, 23, 42));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        rightPanel.setMaximumSize(new Dimension(300, Integer.MAX_VALUE));
        rightPanel.setPreferredSize(new Dimension(300, Integer.MAX_VALUE));

        JLabel menuTitle = new JLabel("Menu");
        menuTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        menuTitle.setForeground(new Color(226, 232, 240));
        rightPanel.add(menuTitle);
        rightPanel.add(Box.createVerticalStrut(15));

        // Create buttons
        JButton btnCreate = createStyledButton("1. Create BST (1-7)");
        btnCreate.addActionListener(e -> createTree());
        rightPanel.add(btnCreate);
        rightPanel.add(Box.createVerticalStrut(10));

        JButton btnAdd = createStyledButton("2. Add Node");
        btnAdd.addActionListener(e -> addNode());
        rightPanel.add(btnAdd);
        rightPanel.add(Box.createVerticalStrut(10));

        JButton btnDelete = createStyledButton("3. Delete Node");
        btnDelete.addActionListener(e -> deleteNode());
        rightPanel.add(btnDelete);
        rightPanel.add(Box.createVerticalStrut(10));

        JButton btnInorder = createStyledButton("4. InOrder Traversal");
        btnInorder.addActionListener(e -> showInorder());
        rightPanel.add(btnInorder);
        rightPanel.add(Box.createVerticalStrut(10));

        JButton btnPreorder = createStyledButton("5. PreOrder Traversal");
        btnPreorder.addActionListener(e -> showPreorder());
        rightPanel.add(btnPreorder);
        rightPanel.add(Box.createVerticalStrut(10));

        JButton btnPostorder = createStyledButton("6. PostOrder Traversal");
        btnPostorder.addActionListener(e -> showPostorder());
        rightPanel.add(btnPostorder);
        rightPanel.add(Box.createVerticalStrut(20));

        // Info panel
        JLabel infoTitle = new JLabel("Tree Information");
        infoTitle.setFont(new Font("Segoe UI", Font.BOLD, 12));
        infoTitle.setForeground(new Color(148, 163, 184));
        rightPanel.add(infoTitle);
        rightPanel.add(Box.createVerticalStrut(10));

        infoLabel = new JLabel("Status: Empty");
        infoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        infoLabel.setForeground(new Color(203, 213, 225));
        infoLabel.setVerticalAlignment(JLabel.TOP);
        JScrollPane infoScroll = new JScrollPane(infoLabel);
        infoScroll.setPreferredSize(new Dimension(260, 100));
        infoScroll.setBackground(new Color(30, 41, 59));
        infoScroll.setOpaque(true);
        rightPanel.add(infoScroll);
        rightPanel.add(Box.createVerticalStrut(20));

        rightPanel.add(Box.createVerticalGlue());

        JButton btnExit = createStyledButton("7. Exit");
        btnExit.setBackground(new Color(239, 68, 68));
        btnExit.addActionListener(e -> exitApplication());
        rightPanel.add(btnExit);

        // Add panels to main
        mainPanel.add(leftPanel, BorderLayout.CENTER);
        mainPanel.add(rightPanel, BorderLayout.EAST);

        setContentPane(mainPanel);
        updateInfo();
    }

    /**
     * Create a styled button
     */
    private JButton createStyledButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(new Color(59, 130, 246)); // Blue
        btn.setForeground(Color.WHITE);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setPreferredSize(new Dimension(260, 40));
        btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(37, 99, 235)); // Darker blue
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!btn.getText().startsWith("7")) {
                    btn.setBackground(new Color(59, 130, 246));
                }
            }
        });
        return btn;
    }

    /**
     * Create initial balanced tree with values 1-7
     */
    private void createTree() {
        bst = new BinarySearchTree();
        int[] values = {4, 2, 6, 1, 3, 5, 7}; // Insert in this order for balanced tree
        for (int val : values) {
            bst.insert(val);
        }

        canvas.setTree(bst);
        updateInfo();

        JOptionPane.showMessageDialog(this,
                "Binary Search Tree created with values 1-7\n\n" +
                        "Structure:\n" +
                        "        4\n" +
                        "      /   \\\n" +
                        "     2     6\n" +
                        "    / \\   / \\\n" +
                        "   1   3 5   7",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Add a node to the tree
     */
    private void addNode() {
        if (bst.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Create a tree first!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String input = JOptionPane.showInputDialog(this, "Enter value to add:", "0");
        if (input != null) {
            try {
                int value = Integer.parseInt(input);
                if (bst.insert(value)) {
                    canvas.setTree(bst);
                    updateInfo();
                    JOptionPane.showMessageDialog(this, "Node " + value + " added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Value " + value + " already exists or is invalid!", "Error", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid integer!", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /**
     * Delete a node from the tree
     */
    private void deleteNode() {
        if (bst.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tree is empty!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String input = JOptionPane.showInputDialog(this, "Enter value to delete:", "0");
        if (input != null) {
            try {
                int value = Integer.parseInt(input);
                if (bst.delete(value)) {
                    canvas.setTree(bst);
                    updateInfo();
                    JOptionPane.showMessageDialog(this, "Node " + value + " deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Value " + value + " not found in tree!", "Error", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid integer!", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /**
     * Show InOrder traversal result
     */
    private void showInorder() {
        if (bst.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tree is empty!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<Integer> result = bst.inorderTraversal();
        String output = "InOrder Traversal (Left → Root → Right)\n\nResult: " + formatList(result);
        JOptionPane.showMessageDialog(this, output, "InOrder Traversal", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Show PreOrder traversal result
     */
    private void showPreorder() {
        if (bst.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tree is empty!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<Integer> result = bst.preorderTraversal();
        String output = "PreOrder Traversal (Root → Left → Right)\n\nResult: " + formatList(result);
        JOptionPane.showMessageDialog(this, output, "PreOrder Traversal", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Show PostOrder traversal result
     */
    private void showPostorder() {
        if (bst.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tree is empty!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<Integer> result = bst.postorderTraversal();
        String output = "PostOrder Traversal (Left → Right → Root)\n\nResult: " + formatList(result);
        JOptionPane.showMessageDialog(this, output, "PostOrder Traversal", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Format list as arrow-separated string
     */
    private String formatList(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) sb.append(" → ");
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    /**
     * Update the info label
     */
    private void updateInfo() {
        if (bst.isEmpty()) {
            infoLabel.setText("Status: Empty\nNodes: 0\nHeight: N/A");
        } else {
            List<Integer> inorder = bst.inorderTraversal();
            String text = String.format(
                    "<html>Status: Active<br>" +
                            "Nodes: %d<br>" +
                            "Height: %d<br>" +
                            "InOrder: %s</html>",
                    inorder.size(),
                    bst.height(),
                    formatList(inorder)
            );
            infoLabel.setText(text);
        }
    }

    /**
     * Exit application with confirmation
     */
    private void exitApplication() {
        int result = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to exit?",
                "Exit",
                JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    /**
     * Main method - entry point of application
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BSTApplication app = new BSTApplication();
            app.setVisible(true);
        });
    }
}
