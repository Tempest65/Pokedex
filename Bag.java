import javax.swing.*;  //import the Swing library
import java.awt.*;    //import the Graphics library
import java.awt.event.*;
import java.applet.*;
import java.net.*;
import java.io.*;
import javax.swing.border.Border;
/**
 * Author: Rakshit & Sarthak
 * Description: GUI to see items bought
 */
public class Bag extends JFrame implements ActionListener{
  //declaring label, text area, audio and button
  JLabel lblPicBackground;
  JTextArea txtBag;
  JButton btnExit;
  AudioClip backgroundSong;
  
  //Declare variables
  String list = "";
  
  //declare variables for border
  Border blackline, raisedetched, loweredetched,raisedbevel, loweredbevel, empty;
  
  //Window swap
  PokeMart pokeMart;
  
  public Bag() throws IOException {
    super("Bag"); //Title of the window must be first
    setSize (800, 500);
    setResizable(false);
    setLayout(null); // to place compenents 
    
    //Set background song
    URL path = getClass ().getResource("Adventure.wav");
    backgroundSong = Applet.newAudioClip (path);
    
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
    
    //Create Label for background picture
    lblPicBackground = new JLabel(new ImageIcon("backgroundBag.jpg"));
    txtBag = new JTextArea();
    txtBag.setOpaque(true);
    txtBag.setEditable(false);
    txtBag.setBorder(compound);
    txtBag.setFont(new Font("roboto", Font.ITALIC, 24));
    
    //Create Button
    btnExit = new JButton("Exit");
    btnExit.setBorder(compound);
    
    // set sizes of components and adding them
    txtBag.setBounds(200, 100, 400, 300);
    add(txtBag);
    btnExit.setBounds(700, 400, 80, 25);
    add(btnExit);
    lblPicBackground.setBounds(0, 0, 800, 500);
    add(lblPicBackground);
    
    //Make song play in background
    backgroundSong.loop();
    
    //Call reading method
    Read();
    txtBag.setText(list);
    
    //make the button listen to clicks and set visible true
    btnExit.addActionListener(this);
    setVisible(true);
  }
  
  //read file
  public void Read() throws IOException{
    BufferedReader input = new BufferedReader(new FileReader("itemsBag.txt")); //declare buffer reader
    BufferedReader input2 = new BufferedReader(new FileReader("QuantityOfItems.txt")); //declare buffer reader
    
    //Declare variables
    String items [] = new String [5];
    int quantity [] = new int [5];
    
    //load the information into the array
    for(int i = 0; i < items.length; i++) {
      items[i] = input.readLine();
    }
    
    //load the information into the array
    for(int i = 0; i < quantity.length; i++) {
      quantity[i] = Integer.parseInt(input2.readLine());
    }
    
    list = "Item\tQuantity\n";
    
    //Display adds array elements to string list
    for (int i = 0; i < items.length; i++) {
      list = list + (items[i] + "\t" + quantity[i] + "\n"); 
    }
    
    input.close();
    input2.close();
  }
  
  //Create an action for buttons pressed
  public void actionPerformed(ActionEvent evt){
    //Exit the program if exit button is pressed
    if (evt.getSource() == btnExit) {
      try {
        pokeMart = new PokeMart();
        setVisible(false);
        backgroundSong.stop();
      } catch (Exception error) { } 
    }
  }
  
  public static void main(String[] args) throws IOException{ 
    new Bag();
  }
}
