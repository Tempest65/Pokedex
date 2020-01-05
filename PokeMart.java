import javax.swing.*;  //import the Swing library
import java.awt.*;    //import the Graphics library
import java.awt.event.*;
import java.io.*;
import java.applet.*;
import java.net.*;
import javax.swing.border.Border;
/**
 * Author: Rakshit & Sarthak
 * Description: Program for the pokemart area
 */
public class PokeMart extends JFrame implements KeyListener{
  //Declare variables
  AudioClip song, song2;
  String songName = "Pokemart"; //variable for songs
  ImageIcon backGnd, picPlayer, picPlayerUp, picPlayerDown, picPlayerRight, picPlayerLeft, picTextbox; //pictures to be drawn
  boolean leftKey;            // booleans to tell which key is pressed
  boolean rightKey;
  boolean upKey;
  boolean downKey;
  boolean interact;
  boolean menu;
  int yPos;           // the position variables
  int xPos;
  int xSet, ySet;
  int counter;
  JLabel txtPokedex, txtBag, txtExitGame, txtCancel;
  Border blackline, raisedetched, loweredetched,raisedbevel, loweredbevel, empty;
  
  //Create combobox
  JComboBox songList;
  
  //Window swap
  PokeMartShopping pokeMartShop;
  Pokedex pokedex;
  Bag bag;
  Credits credits;
  
  public PokeMart() throws IOException{
    super("PokeMart"); //Title of the window
    setSize (850, 899);
    setResizable(false);
    setLayout(null);
    
    //Variables for songs
    URL path = getClass ().getResource (songName + ".wav"); //open the file
    song = Applet.newAudioClip (path); //create audio clip
    
    //Create array for the song options
    String[] songStrings = {"PokeMart", "Adventure", "Retro"};
    
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
    
    //Create the combo box, select item at index 4.
    songList = new JComboBox(songStrings);
    songList.setSelectedIndex(0);
    songList.setBounds(680,0,150,50);
    songList.setBorder(compound);
    songList.setForeground(Color.BLACK);
    songList.setBackground(Color.CYAN);
    add(songList);
    songList.addActionListener(new Music());
    songList.setVisible(false);
    
    backGnd = new ImageIcon ("PokeMart.png"); // load the pictures
    picPlayerUp = new ImageIcon("PlayerUp.png");
    picPlayerDown = new ImageIcon("PlayerDown.png");
    picPlayerLeft = new ImageIcon("PlayerLeft.png");
    picPlayerRight = new ImageIcon("PlayerRight.png");
    picPlayer = picPlayerUp;
    picTextbox = new ImageIcon("textbox.png");
    
    //Create JLabels
    txtPokedex = new JLabel("Pokedex");
    txtPokedex.setOpaque(true);
    txtPokedex.setBorder(compound);
    txtPokedex.setFont(new Font("roboto", Font.BOLD, 18));
    txtBag = new JLabel("Bag");
    txtBag.setOpaque(true);
    txtBag.setBorder(compound);
    txtBag.setFont(new Font("roboto", Font.BOLD, 18));
    txtExitGame = new JLabel("Exit");
    txtExitGame.setOpaque(true);
    txtExitGame.setBorder(compound);
    txtExitGame.setFont(new Font("roboto", Font.BOLD, 18));
    txtCancel = new JLabel("Cancel");
    txtCancel.setOpaque(true);
    txtCancel.setBorder(compound);
    txtCancel.setFont(new Font("roboto", Font.BOLD, 18));
    
    //Set mouse listener to JLabels
    txtPokedex.addMouseListener(new GoPokedex());
    txtBag.addMouseListener(new GoBag());
    txtExitGame.addMouseListener(new ExitGame());
    txtCancel.addMouseListener(new CancelMenu());
    
    //Set sizes of components and adding them
    txtPokedex.setBounds(680, 0, 150, 50);
    add(txtPokedex);
    txtPokedex.setVisible(false);
    txtBag.setBounds(680, 50, 150, 50);
    add(txtBag);
    txtBag.setVisible(false);
    txtExitGame.setBounds(680, 100, 150, 50);
    add(txtExitGame);
    txtExitGame.setVisible(false);
    txtCancel.setBounds(680, 150, 150, 50);
    add(txtCancel);
    txtCancel.setVisible(false);
    
    BufferedReader input = new BufferedReader(new FileReader("save.txt")); //declare buffer reader
    
    input.readLine();
    xSet = Integer.parseInt(input.readLine());
    ySet = Integer.parseInt(input.readLine());
    
    input.close();
    
    leftKey = false;    // set keys to false and original positions
    rightKey = false;
    upKey = false;
    downKey = false;
    interact = false;
    menu = false;
    xPos = xSet;
    yPos = ySet;
    addKeyListener (this);  // add the frame as a listener to your keys
    song.loop();               //Play background music
    setVisible(true);       // Show the frame   
  }
  
  public void keyTyped (KeyEvent e)  {     //needs to be here because the class implements KeyListener
  }
  
  public void keyPressed (KeyEvent e)  //needs to be here because the class implements KeyListener
  {
    //System.out.println (e.getKeyCode ());
    if (e.getKeyCode () == KeyEvent.VK_LEFT)
    {
      leftKey = true;
      
    }
    else if (e.getKeyCode () == KeyEvent.VK_RIGHT)
    {
      rightKey = true;
    }
    else if (e.getKeyCode () == KeyEvent.VK_UP)
    {
      upKey = true;
    }
    else if (e.getKeyCode () == KeyEvent.VK_DOWN)
    {
      downKey = true;
    }
    else if (e.getKeyCode () == KeyEvent.VK_C)
    {
      menu = true;
    }
    else if (e.getKeyCode () == KeyEvent.VK_X)
    {
      interact = true;
    }
    repaint ();  //repaint the window everytime you press a key
  }
  
  //Class for music combo box
  public class Music implements ActionListener{
    String holder="";
    public void actionPerformed(ActionEvent evt) {
      try {
        JComboBox songList = (JComboBox) evt.getSource();
        song.stop();
        if (counter > 0) {
          song2.stop(); 
        }
        songName = holder + songList.getItemAt(songList.getSelectedIndex());
        //Variables for songs
        URL path2 = getClass ().getResource (songName + ".wav"); //open the file
        song2 = Applet.newAudioClip (path2); //create audio clip
        song2.loop();
        counter = counter + 1;
        songList.setVisible(false);
        requestFocus();
      } catch (Exception error){ } 
    }
  }
  
  //class that takes user to pokedex program
  class GoPokedex extends MouseAdapter{
    public void mouseClicked(MouseEvent e){
      if(e.getClickCount() == 1){
        try {
          song.stop();
          if (counter > 0) {
            song2.stop(); 
          }
          setVisible(false);
          pokedex = new Pokedex();
        } catch (Exception error){ } 
      }
    }
  }
  
  //class that takes user to bag program
  class GoBag extends MouseAdapter{
    public void mouseClicked(MouseEvent e){
      if(e.getClickCount() == 1){
        try {
          song.stop();
          if (counter > 0) {
            song2.stop(); 
          }
          setVisible(false);
          bag = new Bag();
        } catch (Exception error){ } 
      }
    }
  }
  
  //class that exits game
  class ExitGame extends MouseAdapter{
    public void mouseClicked(MouseEvent e){
      try {
        if(e.getClickCount() == 1){
          //Create text file
          FileWriter file = new FileWriter("save.txt");
          PrintWriter output = new PrintWriter(file); 
          
          output.println("yes");
          output.println(xPos);
          output.println(yPos);
          
          output.close();
          
           song.stop();
          if (counter > 0) {
            song2.stop(); 
          }
          setVisible(false);
          credits = new Credits();
        }
      } catch (Exception error){ } 
    }
  }
  
  //class that cancels menu
  class CancelMenu extends MouseAdapter{
    public void mouseClicked(MouseEvent e){
      if(e.getClickCount() == 1){
        txtPokedex.setVisible(false);
        txtBag.setVisible(false);
        txtExitGame.setVisible(false);
        txtCancel.setVisible(false);
        requestFocus();
      }
    }
  }
  
  public void keyReleased (KeyEvent e)  {   //needs to be here because the class implements KeyListener
  } 
  
  public void paint (Graphics g){
    backGnd.paintIcon (this, g, 0, 0);  //background at 0,0
    picPlayer.paintIcon (this, g, xPos, yPos);  //picture based on x and y co-ordinates
    picTextbox.paintIcon(this, g, 0, 637); //set location of textbox image 
    
    if (rightKey == true) //right arrow pressed
    {
      picPlayer = picPlayerRight; //Set image to corrosponding key
      xPos = xPos + 10;   //move to the right
      rightKey = false;   // reset the key
      songList.setVisible(false); //reset the combo box and JLabels
      txtPokedex.setVisible(false);
      txtBag.setVisible(false);
      txtExitGame.setVisible(false);
      txtCancel.setVisible(false);
      
      //Do not let sprite walk through certain objects
      if (xPos > 380 && xPos < 400 && yPos < 420 && yPos > 200) {
        xPos = xPos - 10; 
      }
      else if (xPos > 680 && xPos < 800 && yPos < 600 && yPos > 0) {
        xPos = xPos - 10; 
      }
      else if (yPos < 110 && yPos > 20 && xPos > 365 && xPos < 450) {
        xPos = xPos - 10; 
      }
    }
    
    else if (upKey == true) //up arrow pressed
    {
      picPlayer = picPlayerUp; //Set image to corrosponding key
      yPos = yPos - 10; //move up
      upKey = false;    // reset the key
      songList.setVisible(false); //reset the combo box and JLabels
      txtPokedex.setVisible(false);
      txtBag.setVisible(false);
      txtExitGame.setVisible(false);
      txtCancel.setVisible(false);
      
      //Do not let sprite walk through certain objects
      if (yPos < 440 && yPos > 200 && xPos > 380 && xPos < 560) {
        yPos = yPos + 10; 
      }
      else if (yPos < 300 && yPos > 200 && xPos > 0 && xPos < 200) {
        yPos = yPos + 10; 
      }
      else if (yPos < 80 && yPos > 20 && xPos > 0 && xPos < 800) {
        yPos = yPos + 10; 
      }
      else if (yPos < 120 && yPos > 20 && xPos > 400 && xPos < 700) {
        yPos = yPos + 10; 
      }
    }
    
    else if (downKey == true) //down arrow pressed
    {
      picPlayer = picPlayerDown; //Set image to corrosponding key
      yPos = yPos + 10; //Move down
      downKey = false;  //reset the key
      songList.setVisible(false); //reset the combo box and JLabels
      txtPokedex.setVisible(false);
      txtBag.setVisible(false);
      txtExitGame.setVisible(false);
      txtCancel.setVisible(false);
      
      //Show message if player trying to leave
      if (xPos < 300 && xPos > 200 && yPos > 480) {
        Font h =new Font ("roboto", Font.BOLD, 34);//changes font size and bolds
        g.setFont(h);
        g.drawString("There is a storm outside! You cannot leave now!", 40, 760);//draws message
      }
      
      //Do not let sprite walk through certain objects
      if (xPos > 0 && xPos < 850 && yPos > 480) {
        yPos = yPos - 10; 
      }
      else if (yPos < 280 && yPos > 200 && xPos > 380 && xPos < 560) {
        yPos = yPos - 10; 
      }
      else if (yPos < 120 && yPos > 20 && xPos > 800 && xPos < 850) {
        yPos = yPos - 10; 
      } 
    }
    
    
    else if (leftKey == true) //left arrow pressed
    {
      picPlayer = picPlayerLeft; //Set image to corrosponding key
      xPos = xPos - 10; //Move left
      leftKey = false;  //Reset the key
      songList.setVisible(false); //reset the combo box and JLabels
      txtPokedex.setVisible(false);
      txtBag.setVisible(false);
      txtExitGame.setVisible(false);
      txtCancel.setVisible(false);
      
      //Do not let sprite walk through certain objects
      if (xPos > 530 && xPos < 550 && yPos < 420 && yPos > 200) {
        xPos = xPos + 10; 
      }
      else if (xPos > -10 && xPos < 5 && yPos < 500 && yPos > 0) {
        xPos = xPos + 10; 
      }
      else if (xPos > -10 && xPos <200 && yPos < 280 && yPos > 0) {
        xPos = xPos + 10; 
      } 
    }
    
    else if (interact == true) //x pressed
    {
      interact = false;    // reset the key
      
      //Set conditions to where the user can interact
      if (xPos > -10 && xPos < 230 && yPos < 220 && yPos > 130) { //interact with cashier
        try {
          Font h =new Font ("roboto", Font.BOLD, 34);//changes font size and bolds
          g.setFont(h);
          g.drawString("Welcome to the PokeMart! How may I help you?", 40, 760);//draws message
          Thread.sleep(1000);
          song.stop();
          if (counter > 0) {
            song2.stop(); 
          }
          pokeMartShop = new PokeMartShopping();
          setVisible(false);
        } catch (Exception error){ } 
      }
      else if (xPos > 650 && xPos < 700 && yPos < 500 && yPos > 450) { //interact with music npc
        try {
          Font h =new Font ("roboto", Font.BOLD, 34);//changes font size and bolds
          g.setFont(h);
          g.drawString("I Love Music!", 300, 760);//draws message
          Thread.sleep(1000);
          g.setColor(Color.WHITE);
          g.fillRect(100, 700, 600, 150);
          g.setColor(Color.BLACK);
          g.drawString("But the music in here is kinda bland...", 100, 760);//draws message
          Thread.sleep(2000);
          g.setColor(Color.WHITE);
          g.fillRect(100, 700, 600, 150);
          g.setColor(Color.BLACK);
          g.drawString("Change it by clicking on the top right box!", 100, 760);//draws message
          songList.setVisible(true);
        } catch (Exception error){ } 
      }
    }
    
    else if (menu == true) //c pressed
    {
      menu = false;    // reset the key
      
      //Make menu visible
      txtPokedex.setVisible(true);
      txtBag.setVisible(true);
      txtExitGame.setVisible(true);
      txtCancel.setVisible(true);
    }
  }
  
  public static void main(String[] args) throws IOException{ 
    new PokeMart();
  }
}