package com.sept01.AreaController;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.sept01.view.ShowAllStates;

/**
 * A {@link JButton} Listener that implements {@link MouseListener} . To be used for State Button related 
 * functions in the {@link ShowAllStates}
 * @version 1.0
 * @see JButton
 * @see ShowAllStates
 * Gets triggered when the area button is clicked in the 
 * Area button listener class if we hover over an state/area the listener
 * responds to the click.
 * @author Joshua
 */
public class AreaButtonListener implements MouseListener {

  JPanel[] jPanel;
  JButton jButton;

  /**
   * Default background colour of the JButton
   */
  Color backColorDef;
  
  /**
   * Hover colour of the JButton
   */
  Color backColorHover;

  boolean noAlpha;

  /**
   * Main Constructor
   * @param jPanel the JPanels array that we will call repaint() on
   * @param jButton The affected JButton of this listener
   */
  public AreaButtonListener(JPanel[] jPanel, JButton jButton) {
    this.jPanel = jPanel;
    this.jButton = jButton;
    

    jButton.setForeground(Color.ORANGE);

    jButton.setFont(new Font("Verdana", Font.PLAIN, 12));

    jButton.setFocusPainted(false);
    jButton.setFocusable(false);
    backColorDef = new Color(64, 64, 72);
    backColorHover = new Color(128, 128, 136);
    
    jButton.setBackground(backColorDef);

    // jButton.setOpaque(true);

    jButton.repaint();
    for (JPanel panel : jPanel) {
      panel.repaint();
    }
  }
 
  

  @Override
  public void mouseClicked(MouseEvent e) {
    jButton.setForeground(Color.ORANGE);

    jButton.repaint();
    for (JPanel panel : jPanel) {
      panel.repaint();
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {
    jButton.setForeground(Color.WHITE);

    jButton.repaint();
    for (JPanel panel : jPanel) {
      panel.repaint();
    }
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    jButton.setForeground(Color.ORANGE);

    jButton.repaint();
    for (JPanel panel : jPanel) {
      panel.repaint();
    }
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    jButton.setForeground(Color.WHITE);
    jButton.setBackground(backColorHover);

    jButton.repaint();
    for (JPanel panel : jPanel) {
      panel.repaint();
    }

  }

  @Override
  public void mouseExited(MouseEvent e) {
    jButton.setForeground(Color.ORANGE);
    jButton.setBackground(backColorDef);

    jButton.repaint();
    for (JPanel panel : jPanel) {
      panel.repaint();
    }
  }
}
