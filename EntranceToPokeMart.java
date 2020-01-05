import java.awt.event.*;
import javax.swing.*;  //import the Swing library
import javax.swing.Timer;
import javax.swing.border.Border;
import java.awt.*;    //import the Graphics library
import java.applet.*;
import java.net.*;
import java.io.*;

public class EntranceToPokeMart extends JFrame {
  JLabel narrate,animation;
  
  public EntranceToPokeMart()throws IOException{
    setSize(520, 400);
    setResizable(false);
    setTitle("Storm");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    narrate = new JLabel ("Red gets caught up in a snow storm and stops at a nearby house to rest");
    animation = new JLabel (new ImageIcon("StormMovie1.gif"));
    animation.setBounds(40,20,402,296);
    narrate.setBounds(10,340,750,25);
    add(animation);
    add(narrate);
    setVisible(true);
    timer.start();
    timer.setRepeats(false);
    timer2.start();
    timer2.setRepeats(false);
    timer3.start();
    timer3.setRepeats(false);
  }
  Timer timer = new Timer(6000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setVisible(false);
      getContentPane().setBackground(Color.BLACK);
      narrate.setText("Red rests for a few hours");
    }} );
  Timer timer2 = new Timer( 10000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
     animation.setVisible(true);
      getContentPane().setBackground(Color.WHITE);
      animation.setIcon(new ImageIcon("StormMovie2.gif"));
      narrate.setText("After resting Red realizes he is low on supplies so he goes to the pokeMart to stock up");
    }} );
  Timer timer3 = new Timer( 14000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      try {
      new PokeMart();
      dispose();
      } catch (Exception error) {}
    }} );
  public static void main(String[] args) throws IOException { 
    new EntranceToPokeMart();
  }
  
  /* ADD YOUR CODE HERE */
  
}
