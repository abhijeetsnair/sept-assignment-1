package com.sept01.view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackGLabel extends JPanel {
  
  /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
private Image image = new ImageIcon("images/backg.png").getImage();
  
  @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
}

}
