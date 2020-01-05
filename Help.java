import java.awt.event.*;
import javax.swing.*;  //import the Swing library
import javax.swing.Timer;
import javax.swing.border.Border;
import java.awt.*;    //import the Graphics library
import java.applet.*;
import java.net.*;
import java.io.*;
/**
 * Author: Sarthak & Rakshit
 * Description: Program for help menu
 *  Citations: 
 * Code relating to creating custom borders retreived from "https://examples.javacodegeeks.com/desktop-java/swing/jlabel/create-jlabel-with-border/"
 */
public class Help extends JFrame implements ActionListener {
   Border blackline, raisedetched, loweredetched,raisedbevel, loweredbevel, empty;
  JLabel background,help;
  JButton btnPokedex,btnBattleScene,btnPokemart,btnExit,btnShopping;
  AudioClip song;
  ImageIcon icon,icon2,icon3,icon4;
  Start start;
  public Help(){
    setSize(500, 540);
    setResizable(false);
    setTitle("Help");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
     icon = new ImageIcon(Help.class.getResource("pokedexHelp.png"));
  icon2 = new ImageIcon(Help.class.getResource("battleHelp.png"));
  icon3 = new ImageIcon(Help.class.getResource("pokemartHelp.png"));
    icon4 = new ImageIcon(Help.class.getResource("shopperHelp.png"));

    background = new JLabel (new ImageIcon("sphere.gif"));
    btnPokedex = new JButton("Pokedex");
    btnBattleScene = new JButton("Battle");
    btnPokemart = new JButton("PokeMart");
    btnShopping = new JButton("Shopping");
    help = new JLabel("Help Menu");
    help.setFont(new Font("Times New Roman", Font.BOLD, 50));
    btnExit = new JButton("Exit");
    btnPokedex.setForeground(Color.CYAN);
    btnBattleScene.setForeground(Color.CYAN);
    btnPokemart.setForeground(Color.CYAN);
btnExit.setBackground(Color.BLUE);
btnPokedex.setBackground(Color.BLUE);
    btnBattleScene.setBackground(Color.BLUE);
    btnPokemart.setBackground(Color.BLUE);
btnExit.setForeground(Color.CYAN);
btnShopping.setBackground(Color.BLUE);
btnShopping.setForeground(Color.CYAN);
help.setForeground(Color.MAGENTA);
help.setBackground(Color.MAGENTA);

btnBattleScene.setContentAreaFilled(false);
    btnBattleScene.setFocusPainted(false);
    btnPokedex.setContentAreaFilled(false);
    btnPokedex.setFocusPainted(false);
btnPokemart.setContentAreaFilled(false);
 btnPokemart.setFocusPainted(false);
btnExit.setFocusPainted(false);
btnExit.setContentAreaFilled(false);
btnShopping.setFocusPainted(false);
btnShopping.setContentAreaFilled(false);

    background.setBounds(0,-30,500,540);
    btnPokedex.setBounds(200,280,100,25);
    btnBattleScene.setBounds(200,310,100,25);
    btnPokemart.setBounds(200,340,100,25);
    btnShopping.setBounds(200,370,100,25);
    btnExit.setBounds(200,400,100,25);
    help.setBounds(125,60,257,100);
    
    //declares border
    Border compound;
    //creates components of compound border
    Border line = BorderFactory.createLineBorder(Color.BLACK);
    raisedbevel = BorderFactory.createRaisedBevelBorder();
    loweredbevel = BorderFactory.createLoweredBevelBorder();
//This creates a neat frame
    compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
    
//Adds an outline to the frame.
    compound = BorderFactory.createCompoundBorder(line, compound);
    
    add(btnPokemart);
   add(btnPokedex);
   add(btnBattleScene);
   add(btnShopping);
   add(btnExit);
   add(help);
    add(background);
    
    //sets borders to components
    btnPokemart.setBorder(compound);
    btnPokedex.setBorder(compound);
    btnBattleScene.setBorder(compound);
    btnExit.setBorder(compound);
    btnShopping.setBorder(compound);
    help.setBorder(compound);
    
    
    btnPokemart.addActionListener(this);
    btnPokedex.addActionListener(this);
    btnBattleScene.addActionListener(this);
    btnExit.addActionListener(this); 
    btnShopping.addActionListener(this); 
    URL path = getClass ().getResource ("originalX.wav"); //open the file
    song = Applet.newAudioClip (path); //create audio clip
    song.loop();
    
    setVisible(true);
  }
  
  public void actionPerformed(ActionEvent evt) { 
   if (evt.getSource () == btnPokedex) {
      JOptionPane.showMessageDialog( null,"","Pokedex Help", JOptionPane.INFORMATION_MESSAGE,icon);
                
    }

    else if (evt.getSource () == btnBattleScene) {
  JOptionPane.showMessageDialog( null,"","Battle Help", JOptionPane.INFORMATION_MESSAGE,icon2);
}
    else if (evt.getSource () == btnPokemart) {
  JOptionPane.showMessageDialog( null,"","Pokemart Help", JOptionPane.INFORMATION_MESSAGE,icon3);
}
    else if (evt.getSource () == btnShopping) {
  JOptionPane.showMessageDialog( null,"","Shopping Help", JOptionPane.INFORMATION_MESSAGE,icon4);
}
    else if (evt.getSource () == btnExit) {
      song.stop();
      setVisible(false);
  start= new Start();
}
  }
  public static void main(String[] args) { 
    new Help();
  }
  
  /* ADD YOUR CODE HERE */
  
}