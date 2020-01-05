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
 * Description: Program that displays credit scene
 * Citations: 
 * Code relating to creating custom borders retreived from "https://examples.javacodegeeks.com/desktop-java/swing/jlabel/create-jlabel-with-border/"
 * Code Relating to swing timers retrieved from "https://docs.oracle.com/javase/tutorial/uiswing/misc/timer.html"
 */
public class Credits extends JFrame implements ActionListener {
  //declare variables
  Border blackline, raisedetched, loweredetched,raisedbevel, loweredbevel, empty;
  JLabel animation,narrate,red;
  AudioClip song;
  JButton btnSkip;
  public Credits()throws IOException{
    //sets size, title and makes unresizable
    setSize(720, 480);
    setResizable(false);
    setTitle("Credits");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setBackground(Color.RED);
    setLayout(null);
    animation = new JLabel (new ImageIcon("Zcredits2.gif"));
    btnSkip= new JButton("Skip");
    animation.setBounds(0,0,720,480);
    btnSkip.setBounds(640,400,70,25);
    btnSkip.setForeground(Color.WHITE);
    btnSkip.setFocusPainted(false);
    btnSkip.setContentAreaFilled(false);
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
    btnSkip.setBorder(compound);
    add(btnSkip);
    add(animation); 
    btnSkip.addActionListener(this);
    //gets and plays song
    URL path = getClass ().getResource ("music7.wav"); //open the file
    song = Applet.newAudioClip (path); //create audio clip
    song.loop();
    setVisible(true);
    //starts timer and stops repeats
    timer.start();
    timer.setRepeats(false);
  }
  //timer that ends program after about a minute
  Timer timer = new Timer( 80000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      System.exit(0);
    }} );
  //action listener for skip nutton
  public void actionPerformed(ActionEvent evt) { 
   if (evt.getSource () == btnSkip) {
     System.exit(0);
   }
  }
  
  public static void main(String[] args)throws IOException { 
    new Credits();
  }
  
  /* ADD YOUR CODE HERE */
  
}
