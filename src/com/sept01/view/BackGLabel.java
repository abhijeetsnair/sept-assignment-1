package com.sept01.view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackGLabel extends JPanel {
  
  /** LABEL PAINTS THE BACK PANEL AND DISPLAYS THE IMAGE
	 * backg.png. IT DRAWS THE IMAGE USING GRAPHICS IN THE BACKGROUND
	 */
	
	private static final long serialVersionUID = 1L;
private Image image = new ImageIcon("images/backg.png").getImage();
  
  @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
}

}
