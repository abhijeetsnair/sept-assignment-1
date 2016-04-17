package com.sept01.AreaController;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import com.sept01.view.MainView;
import com.sept01.view.areas.WestPanel;

/**
 * A {@link MouseListener} Class that handles touch events related to the Center Panel in the GUI.
 * @author Joshua
 */
public class CenterViewListener implements MouseListener {
  
  private WestPanel westPanel;
  /**
   * Main constructor.
   * @param westPanel Reference to the WestPanel instance
   * @param mainView Reference tot he MainView instance
   */
  public CenterViewListener(WestPanel westPanel, MainView mainView) {
    // TODO Auto-generated constructor stub
    this.westPanel = westPanel;
  }

  @Override
  public void mouseClicked(MouseEvent e) {

    // Remove the west panel when we click on this panel
    JPanel jPanel = westPanel.getCurrentStatePanel();
    
    if (jPanel != null) {
      Container parent = jPanel.getParent();
      
      if (parent != null) {
      parent.setVisible(false);
      parent.remove(jPanel);
      
     
      
      parent.getParent().remove(parent);
      
      //grandParent.getParent().remove(grandParent);
      
      parent.repaint();
      

      //parent.invalidate();
      }

    }
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

}
