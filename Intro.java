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
 * Description: Program for intro to game
 * Citations: 
 * Code relating to creating custom borders retreived from "https://examples.javacodegeeks.com/desktop-java/swing/jlabel/create-jlabel-with-border/"
 * Code Relating to swing timers retrieved from "https://docs.oracle.com/javase/tutorial/uiswing/misc/timer.html"
 */
public class Intro extends JFrame implements ActionListener {
  //declare variables
  Border blackline, raisedetched, loweredetched,raisedbevel, loweredbevel, empty;
  JLabel animation,narrate,red;
  AudioClip song;
  JButton btnSkip;
  public Intro()throws IOException{
    //sets size, title and makes unresizable
    setSize(750, 400);
    setResizable(false);
    setTitle("Red");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setBackground(Color.RED);
    setLayout(null);
    narrate = new JLabel ("This is the story of the legendary pokemon trainer Red");
    animation = new JLabel (new ImageIcon("introX.gif"));
    red = new JLabel (new ImageIcon("miniRed.gif"));
    btnSkip= new JButton("Skip");
    animation.setBounds(-10,-10,640,360);
    narrate.setBounds(10,340,750,25);
    red.setBounds(590,10,170,200);
    btnSkip.setBounds(640,300,70,25);
    btnSkip.setForeground(Color.WHITE);
    btnSkip.setFocusPainted(false);
    btnSkip.setContentAreaFilled(false);
    btnSkip.setBackground(Color.red);
    narrate.setForeground(Color.WHITE);
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
    add(animation);
    add(narrate);
    add(red);
    add(btnSkip);
    btnSkip.addActionListener(this);
    //gets and plays song
    URL path = getClass ().getResource ("x8.wav"); //open the file
    song = Applet.newAudioClip (path); //create audio clip
    song.loop();
    setVisible(true);
    //starts timer and stops repeats
    timerN.start();
    timerN.setRepeats(false);
    timerN2.start();
    timerN2.setRepeats(false);
    timerN3.start();
    timerN3.setRepeats(false);
    timerN4.start();
    timerN4.setRepeats(false);
    timerX.start();
    timerX.setRepeats(false);
    timerX2.start();
    timerX2.setRepeats(false);
    timerX3.start();
    timerX3.setRepeats(false);
  }
  //creates sing timers to change animation and change text
  Timer timerN = new Timer( 12000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      narrate.setText("Red vs. Blue, The rivals clash for the first time");
    }} );
  Timer timerN2 = new Timer( 24000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      narrate.setText("Red vs. Brock, Red faces his first gym leader");
    }} );
  Timer timerN3 = new Timer( 55000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      narrate.setText("Red vs. Giovanni, Red faces his final gym leader and the leader of team rocket");
    }} );
  Timer timerN4 = new Timer( 77000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      narrate.setText("After numerous battles, defeating all 8 gym leaders Red approaches Indigo Plateau to face the Pokemon League Champion....");
    }} );
  Timer timerX = new Timer( 33000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      
      animation.setIcon(new ImageIcon("introX2.gif"));
    }} );
  Timer timerX2 = new Timer( 66000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setIcon(new ImageIcon("introX3.gif"));
    }} );
  Timer timerX3 = new Timer( 84000, new ActionListener(){
    @Override
      //calls method for start menu
      public void actionPerformed( ActionEvent e ){
      try{
        song.stop();
        new Start();
        dispose();
      }catch (Exception error){//catches error
      }
    }} );
  public void actionPerformed(ActionEvent evt) { 
      if(evt.getSource () == btnSkip) {
        try{
          timerX3.stop();
        song.stop();
        new Start();
        dispose();
      }catch (Exception error){//catches error
      }
      }
    }
  public static void main(String[] args)throws IOException { 
    new Intro();
  }
  
  /* ADD YOUR CODE HERE */
  
}
