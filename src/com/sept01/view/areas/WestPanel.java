package com.sept01.view.areas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.sept01.controller.StateButtonHoverListener;
import com.sept01.controller.StateButtonListener;
import com.sept01.view.MainView;

/**
 * <p>
 * A Class that represents the western-side panel of the GUI.
 * </p>
 * <p>
 * It is currently a side bar which holds buttons for all the states.
 * </p>
 * 
 * @version 1.0
 * @see State
 */
@SuppressWarnings("serial")
public class WestPanel extends JPanel {

  private MainView view;

  /**
   * A reference to the currently state JPanel.
   */
  private JPanel currentStatePanel;

  Image image;

  public WestPanel(MainView mainView) {
    this.setView(mainView);
    this.setLayout(new BorderLayout());
    
    setOpaque(true);
    
    // JPanel TextPanel = new JPanel();
    TextPanelView TextPanel = new TextPanelView();

    GridLayout layout = new GridLayout(9, 1, 0, 0);
    TextPanel.setLayout(layout);

    JButton NSW = new JButton("NSW");
    //StateButton NSW = new StateButton("NSW");

    JButton VIC = new JButton("VIC");
    JButton QLD = new JButton("QLD");
    JButton WA = new JButton("WA");
    JButton SA = new JButton("SA");
    JButton TAS = new JButton("TAS");
    JButton ACT = new JButton("ACT");
    JButton NT = new JButton("NT");
    JButton ANTARTICA = new JButton("ANT");

    // Adding Listeners to the button
    NSW.addMouseListener(new StateButtonHoverListener(this, NSW));
    NSW.addMouseListener(new StateButtonListener(new JPanel[] {this}, NSW, false));
    NSW.setBorder(null);

    VIC.addMouseListener(new StateButtonHoverListener(this, VIC));
    VIC.addMouseListener(new StateButtonListener(new JPanel[] {this}, VIC, false));
    VIC.setBorder(null);
    
    QLD.addMouseListener(new StateButtonHoverListener(this, QLD));
    QLD.addMouseListener(new StateButtonListener(new JPanel[] {this}, QLD, false));
    QLD.setBorder(null);
    
    WA.addMouseListener(new StateButtonHoverListener(this, WA));
    WA.addMouseListener(new StateButtonListener(new JPanel[] {this}, WA, false));
    WA.setBorder(null);
    
    SA.addMouseListener(new StateButtonHoverListener(this, SA));
    SA.addMouseListener(new StateButtonListener(new JPanel[] {this}, SA, false));
    SA.setBorder(null);
    
    TAS.addMouseListener(new StateButtonHoverListener(this, TAS));
    TAS.addMouseListener(new StateButtonListener(new JPanel[] {this}, TAS, false));
    TAS.setBorder(null);
    
    ACT.addMouseListener(new StateButtonHoverListener(this, ACT));
    ACT.addMouseListener(new StateButtonListener(new JPanel[] {this}, ACT, false));
    ACT.setBorder(null);
    
    NT.addMouseListener(new StateButtonHoverListener(this, NT));
    NT.addMouseListener(new StateButtonListener(new JPanel[] {this}, NT, false));
    NT.setBorder(null);
    
    ANTARTICA.addMouseListener(new StateButtonHoverListener(this, ANTARTICA));
    ANTARTICA.addMouseListener(new StateButtonListener(new JPanel[] {this}, ANTARTICA, false));
    ANTARTICA.setBorder(null);

    TextPanel.add(NSW);
    
     TextPanel.add(VIC); TextPanel.add(QLD); TextPanel.add(WA);
     TextPanel.add(SA); TextPanel.add(TAS); TextPanel.add(ACT);
     TextPanel.add(NT); TextPanel.add(ANTARTICA);
     
     TextPanel.setBorder(null);
     

    this.add(TextPanel);

    Border blackline;

    blackline = BorderFactory.createLineBorder(Color.black);
    // TextPanel.setBorder(blackline);

    // TextPanel.setBackground(Color.BLUE);

    // image = new ImageIcon("images/west_back.png").getImage();

  }
  

  public MainView getView() {
    return view;
  }

  public void setView(MainView view) {
    this.view = view;
  }

  /**
   * Gets the current state {@link JPanel}
   * 
   * @return The current state JPanel
   * @author Joshua
   */
  public JPanel getCurrentStatePanel() {
    return currentStatePanel;
  }

  /**
   * Sets the current state {@link JPanel}
   * 
   * @param jPanel
   *          The current state JPanel
   * @author Joshua
   */
  public void setCurrentStatePanel(JPanel jPanel) {
    currentStatePanel = jPanel;
  }

  public void paintComponent(Graphics g) {
    g.drawImage(image, 0, 0, null);
  }
  
  
  
  
  
  

  public class TextPanelView extends JPanel {
    Image image;

    public TextPanelView() {
      image = new ImageIcon("images/west_back.png").getImage();
      // setMinimumSize(new Dimension(2200, 1));
      setPreferredSize(new Dimension(202, 1080));
    }

    public void paintComponent(Graphics g) {
      g.drawImage(image, 0, 0, null);
    }
  }
  
  
  
  

}
