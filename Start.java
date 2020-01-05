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
 * Description: Program for start menu
 * Citations: 
 * Code relating to creating custom borders retreived from "https://examples.javacodegeeks.com/desktop-java/swing/jlabel/cre
 */
public class Start extends JFrame implements ActionListener {
   Border blackline, raisedetched, loweredetched,raisedbevel, loweredbevel, empty;
  JLabel background;
  JButton btnNewGame,btnLoadGame,btnHelp,btnExit;
  AudioClip song;
  Help help;
  public Start(){
    setSize(500, 600);
    setResizable(false);
    setTitle("Battle");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    background = new JLabel (new ImageIcon("startMenu.gif"));
    btnNewGame = new JButton("New Game");
    btnLoadGame = new JButton("Load Game");
    btnHelp = new JButton("Help");
    btnExit = new JButton("Exit");
    btnNewGame.setForeground(Color.WHITE);
    btnLoadGame.setForeground(Color.WHITE);
    btnHelp.setForeground(Color.WHITE);
btnExit.setForeground(Color.WHITE);
btnLoadGame.setContentAreaFilled(false);

    btnLoadGame.setFocusPainted(false);
    btnNewGame.setContentAreaFilled(false);
    btnNewGame.setFocusPainted(false);
btnHelp.setContentAreaFilled(false);
 btnHelp.setFocusPainted(false);
btnExit.setFocusPainted(false);
btnExit.setContentAreaFilled(false);

    background.setBounds(0,0,500,600);
    btnNewGame.setBounds(200,370,100,25);
    btnLoadGame.setBounds(200,400,100,25);
    btnHelp.setBounds(200,430,100,25);
    btnExit.setBounds(200,460,100,25);
    
    
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
    
    add(btnHelp);
   add(btnNewGame);
   add(btnLoadGame);
   add(btnExit);
    add(background);
    
    //sets borders to components
    btnHelp.setBorder(compound);
    btnNewGame.setBorder(compound);
    btnLoadGame.setBorder(compound);
    btnExit.setBorder(compound);
    
    
    
    btnHelp.addActionListener(this);
    btnNewGame.addActionListener(this);
    btnLoadGame.addActionListener(this);
    btnExit.addActionListener(this);  
    URL path = getClass ().getResource ("original.wav"); //open the file
    song = Applet.newAudioClip (path); //create audio clip
    song.loop();
    
    setVisible(true);
  }
  
  public void actionPerformed(ActionEvent evt) { 
   if (evt.getSource () == btnNewGame) {
     JOptionPane.showMessageDialog(null,"This game supports autosave");
     try{
       FileWriter file = new FileWriter ("QuantityOfItems.txt");
    PrintWriter output = new PrintWriter(file);
    output.println("no");
    output.println("265");
    output.println("480");
       FileWriter file2 = new FileWriter ("QuantityOfItems.txt");
    PrintWriter output2 = new PrintWriter(file2);
    for(int i = 0;i<5;i++){
      output2.println("0");  
    }
       output2.println("1000");
    output2.close();
       song.stop();
   new BattleScene();
   dispose();
   
   } catch (Exception error){
    }
}
    else if (evt.getSource () == btnLoadGame) {
      try{
        BufferedReader input = new BufferedReader(new FileReader("save.txt"));//declare buffer reader
        String check =input.readLine();
        if (check.equalsIgnoreCase("yes"))  {
              song.stop();
   new PokeMart();
   dispose();
            }
            else{
              JOptionPane.showMessageDialog(null,"There is no saved file, Please click new game");            
            }
   } catch (Exception error){
    }
}
    else if (evt.getSource () == btnHelp) {
      song.stop();
      setVisible(false);
  help = new Help();
}
    else if (evt.getSource () == btnExit) {
  System.exit(0);
}
  }
  public static void main(String[] args) { 
    new Start();
  }
  
  /* ADD YOUR CODE HERE */
  
}
