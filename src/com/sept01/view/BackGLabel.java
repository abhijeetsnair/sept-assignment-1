package com.sept01.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackGLabel extends JPanel {
  
  
  @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
}

}
