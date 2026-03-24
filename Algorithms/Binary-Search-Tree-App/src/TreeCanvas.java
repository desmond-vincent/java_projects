package src;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Custom JPanel for rendering the Binary Search Tree visually
 * Displays nodes as circles and connections as lines
 */
public class TreeCanvas extends JPanel {
    private BinarySearchTree tree;
    private static final int NODE_RADIUS = 25;
    private static final int VERTICAL_SPACING = 80;
    private static final Color NODE_FILL = new Color(59, 130, 246); // Blue
    private static final Color NODE_STROKE = new Color(30, 64, 175); // Dark Blue
    private static final Color LINE_COLOR = new Color(71, 85, 105); // Gray
    private static final Color TEXT_COLOR = Color.WHITE;

    /**
     * Constructor
     */
    public TreeCanvas() {
        this.tree = null;
        setBackground(new Color(15, 23, 42)); // Dark background
        setPreferredSize(new Dimension(800, 600));
    }

    /**
     * Set the tree to display
     * @param tree the BinarySearchTree to display
     */
    public void setTree(BinarySearchTree tree) {
        this.tree = tree;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (tree == null || tree.isEmpty()) {
            drawEmptyMessage(g);
            return;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the tree
        drawNode(g2d, tree.getRoot(), getWidth() / 2, 40, getWidth() / 4);
    }

    /**
     * Draw the empty tree message
     */
    private void drawEmptyMessage(Graphics g) {
        g.setColor(new Color(148, 163, 184)); // Muted text
        g.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        String message = "Create a tree to begin";
        FontMetrics fm = g.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(message)) / 2;
        int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
        g.drawString(message, x, y);
    }

    /**
     * Recursively draw nodes and edges
     */
    private void drawNode(Graphics2D g, BSTNode node, int x, int y, int offset) {
        if (node == null) {
            return;
        }

        // Draw edges first (so they appear behind nodes)
        if (node.left != null) {
            int leftX = x - offset;
            int leftY = y + VERTICAL_SPACING;
            g.setColor(LINE_COLOR);
            g.setStroke(new BasicStroke(1.5f));
            g.drawLine(x, y + NODE_RADIUS, leftX, leftY - NODE_RADIUS);
            drawNode(g, node.left, leftX, leftY, offset / 2);
        }

        if (node.right != null) {
            int rightX = x + offset;
            int rightY = y + VERTICAL_SPACING;
            g.setColor(LINE_COLOR);
            g.setStroke(new BasicStroke(1.5f));
            g.drawLine(x, y + NODE_RADIUS, rightX, rightY - NODE_RADIUS);
            drawNode(g, node.right, rightX, rightY, offset / 2);
        }

        // Draw node circle
        g.setColor(NODE_FILL);
        g.fillOval(x - NODE_RADIUS, y, NODE_RADIUS * 2, NODE_RADIUS * 2);
        g.setColor(NODE_STROKE);
        g.setStroke(new BasicStroke(2.0f));
        g.drawOval(x - NODE_RADIUS, y, NODE_RADIUS * 2, NODE_RADIUS * 2);

        // Draw value text
        g.setColor(TEXT_COLOR);
        g.setFont(new Font("Segoe UI", Font.BOLD, 12));
        FontMetrics fm = g.getFontMetrics();
        String text = String.valueOf(node.value);
        int textX = x - fm.stringWidth(text) / 2;
        int textY = y + NODE_RADIUS + (fm.getAscent() - fm.getDescent()) / 2;
        g.drawString(text, textX, textY);
    }
}
