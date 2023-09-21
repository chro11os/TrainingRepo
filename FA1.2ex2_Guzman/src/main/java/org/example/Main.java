package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Main extends JFrame {
    private int xCoordinate = 50;
    private int yCoordinate = 50;
    private ImageIcon imageIcon;
    private int distance = 50;

    public Main() {
        setTitle("MOVE MOVE MOVE");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (imageIcon != null) {
                    imageIcon.paintIcon(this, g, xCoordinate, yCoordinate);
                }
            }
        };

        add(panel);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    changeImage();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        setFocusable(true);
        requestFocus();

        String input = JOptionPane.showInputDialog("Enter the number of steps (distance):");
        try {
            distance = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Using default distance (50).");
        }

        imageIcon = new ImageIcon("/home/linux/Documents/MAPUA/JavaMapua/FA1.2ex2_Guzman/src");
    }

    private void changeImage() {
        if (imageIcon != null) {
            Image image = imageIcon.getImage();
            Image newImage = new ImageIcon(invertImage(image)).getImage();
            imageIcon.setImage(newImage);
            repaint();
        }
    }

    private Image invertImage(Image originalImage) {
        BufferedImage bufferedImage = new BufferedImage(originalImage.getWidth(null), originalImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bufferedImage.createGraphics();
        g2.drawImage(originalImage, 0, 0, null);
        g2.dispose();

        for (int i = 0; i < bufferedImage.getWidth(); i++) {
            for (int j = 0; j < bufferedImage.getHeight(); j++) {
                int rgba = bufferedImage.getRGB(i, j);
                bufferedImage.setRGB(i, j, rgba ^ 0x00FFFFFF);
            }
        }

        return bufferedImage;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
