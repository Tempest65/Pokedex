import javax.swing.*;  //import the Swing library
import java.awt.*;    //import the Graphics library
import java.awt.event.*;
import java.applet.*;
import java.net.*;
import java.io.*;
import javax.swing.border.Border;
/**
 * Author: Rakshit & Sarthak
 * Description: GUI for the pokemart shopping
 */
public class PokeMartShopping extends JFrame implements ActionListener{
  //declaring label, text area and buttons
  JLabel lblPicBackground, lblMoney, lblItemName, lblPicItem, arrowU, arrowD, lblQuantity;
  JTextArea txtOutput, txtItems;
  JButton btnExit, btnBuy;
  AudioClip backgroundSong;
  
  //declare variables for border
  Border blackline, raisedetched, loweredetched,raisedbevel, loweredbevel, empty;
  
  //Window swap
  PokeMart pokeMart;
  
  //Declare variables
  String list = "", listItems = "", image = "";
  int money = 1000, counter = 1, price = 0, index;
  int quantityItems[];
  
  //Function to create a flexible array
  public static int flexableArray()throws IOException {
    BufferedReader lineCheck = new BufferedReader(new FileReader("items.txt"));
    int lines = 0;
    while (lineCheck.readLine() != null) lines++;
    lineCheck.close();
    lines = lines / 2;
    return lines;
  }
  
  public PokeMartShopping() throws IOException {
    super("Pokemart Shop"); //Title of the window must be first
    setSize (850, 850);
    setResizable(false);
    setLayout(null); // to place compenents 
    
    //set array
    quantityItems = new int [5];
    
    //Set background song
    URL path = getClass ().getResource("Pokemart.wav");
    backgroundSong = Applet.newAudioClip (path);
    
    BufferedReader input = new BufferedReader(new FileReader("QuantityOfItems.txt")); //declare buffer reader
    
    //load the information into the array
    for(int i = 0; i < 5; i++) {
      quantityItems[i] = Integer.parseInt(input.readLine());
    }
    
    money = Integer.parseInt(input.readLine());
    
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
    lblPicBackground = new JLabel(new ImageIcon("Background.jpg"));
    arrowU = new JLabel(new ImageIcon("UpArrow.png"));
    arrowU.setVisible(false);
    arrowD = new JLabel(new ImageIcon("DownArrow.png"));
    arrowD.setVisible(false);
    lblItemName = new JLabel("");
    lblItemName.setOpaque(true);
    lblItemName.setBorder(compound);
    lblItemName.setFont(new Font("roboto", Font.BOLD, 18));
    lblPicItem = new JLabel(new ImageIcon(image));
    lblMoney = new JLabel("Money: $" + money);
    lblMoney.setOpaque(true);
    lblMoney.setBorder(compound);
    lblMoney.setFont(new Font("roboto", Font.BOLD, 18));
    lblQuantity = new JLabel("" + counter);
    lblQuantity.setOpaque(true);
    lblQuantity.setBorder(compound);
    lblQuantity.setFont(new Font("roboto", Font.BOLD, 18));
    lblQuantity.setVisible(false);
    txtOutput = new JTextArea();
    txtOutput.setOpaque(true);
    txtOutput.setEditable(false);
    txtOutput.setBorder(compound);
    txtOutput.setFont(new Font("roboto", Font.ITALIC, 24));
    txtItems = new JTextArea();
    txtItems.setOpaque(true);
    txtItems.setEditable(false);
    txtItems.setBorder(compound);
    txtItems.setFont(new Font("roboto", Font.ITALIC, 24));
    
    //Create Button
    btnExit = new JButton("Exit");
    btnExit.setBorder(compound);
    btnBuy = new JButton("Buy Item");
    btnBuy.setBorder(compound);
    
    //Set mouse listener to JLabels
    txtItems.addMouseListener(new GetItems());
    arrowU.addMouseListener(new UpClick());
    arrowD.addMouseListener(new DownClick());
    
    // set sizes of components and adding them
    lblItemName.setBounds(200, 100, 150, 25);
    add(lblItemName);
    
    lblQuantity.setBounds(510, 240, 30, 25);
    add(lblQuantity);
    
    arrowU.setBounds(500, 180, 50, 50);
    add(arrowU);
    
    arrowD.setBounds(500, 270, 50, 50);
    add(arrowD);
    
    lblPicItem.setBounds(250, 150, 200, 200);
    add(lblPicItem);
    
    txtOutput.setBounds(200, 100, 400, 300);
    add(txtOutput);
    
    txtItems.setBounds(200, 480, 400, 300);
    add(txtItems);
    
    btnExit.setBounds(740, 750, 80, 25);
    add(btnExit);
    
    btnBuy.setBounds(630, 750, 100, 25);
    add(btnBuy);
    
    lblMoney.setBounds(10, 10, 150, 40);
    add(lblMoney);
    
    lblPicBackground.setBounds(0, -10, 850, 850);
    add(lblPicBackground);
    
    //Make song play in background
    backgroundSong.loop();
    
    //Call reading method
    Read();
    txtItems.setText(list);
    
    //make the button listen to clicks and set visible true
    btnExit.addActionListener(this);
    btnBuy.addActionListener(this);
    setVisible(true);
  }
  
  //read file
  public void Read() throws IOException{
    BufferedReader input = new BufferedReader(new FileReader("items.txt")); //declare buffer reader
    
    int lines = flexableArray();
    
    //Declare variables
    String items [] = new String [lines];
    int price [] = new int [lines];
    
    //load the information into the array
    for(int i = 0; i < items.length; i++) {
      items[i] = input.readLine();
      price [i] = Integer.parseInt(input.readLine());
    }
    
    list = "Item\tPrice\n";
    
    //Display adds array elements to string list
    for (int i = 0; i < items.length; i++) {
      list = list + (items[i] + "\t" + price[i] + "\n"); 
    }
    
    input.close();
  }
  
  //Class that raises quantity
  class UpClick extends MouseAdapter{
    public void mouseClicked(MouseEvent e){
      if(e.getClickCount() == 1){
        if (counter == 99) {
          counter = 0; 
          lblQuantity.setText("" + counter);
        }
        else {
          counter = counter + 1;
          lblQuantity.setText("" + counter);
        }
      }
    }
  }
  
  //Class that lowers quantity
  class DownClick extends MouseAdapter{
    public void mouseClicked(MouseEvent e){
      if(e.getClickCount() == 1){
        if(counter == 0) {
          counter = 99;
          lblQuantity.setText("" + counter);
        }
        else { 
          counter = counter - 1;
          lblQuantity.setText("" + counter);
        }
      }
    }
  }
  
  //class that displays Items
  class GetItems extends MouseAdapter{
    public void mouseClicked(MouseEvent e){
      if(e.getClickCount() == 2){
        listItems = txtItems.getSelectedText();
        try{
        if (listItems.matches(".*\\d.*")||listItems.matches("\\s+") || listItems.matches("Item") || listItems.matches("Price")|| listItems.matches("[^a-zA-Z0-9]")) {
          lblItemName.setText("Select item");
          lblQuantity.setVisible(false);
          arrowU.setVisible(false);
          arrowD.setVisible(false);
          lblPicItem.setVisible(false);
        } 
        else {
          lblQuantity.setVisible(true);
          arrowU.setVisible(true);
          arrowD.setVisible(true);
          image = listItems;
          lblPicItem.setIcon(new ImageIcon(image+ ".jpg"));
           lblPicItem.setVisible(true);
          lblItemName.setText(txtItems.getSelectedText());
        }
        } catch (Exception error) {lblItemName.setText("Select item");
          lblQuantity.setVisible(false);
          arrowU.setVisible(false);
          arrowD.setVisible(false);
          lblPicItem.setVisible(false);} 
      }
    }
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
    else if (evt.getSource() == btnBuy) {
      try {
        //Subtract money based on what item is being purchased
        if (listItems.matches("Pokeball")) {
          price = 50;
          index = 0;
          money = money - (price * counter); 
          lblMoney.setText("Money: $" + money);
        }
        else if (listItems.matches("Greatball")) {
          price = 100;
          index = 1;
          money = money - (price * counter); 
          lblMoney.setText("Money: $" + money);
        }
        else if (listItems.matches("Ultraball")) {
          price = 150;
          index = 2;
          money = money - (price * counter); 
          lblMoney.setText("Money: $" + money);
        }
        else if (listItems.matches("Potion")) {
          price = 20;
          index = 3;
          money = money - (price * counter); 
          lblMoney.setText("Money: $" + money);
        }
        else if (listItems.matches("Super-Potion")) {
          price = 80;
          index = 4;
          money = money - (price * counter); 
          lblMoney.setText("Money: $" + money);
        }
        
        BufferedReader input = new BufferedReader(new FileReader("QuantityOfItems.txt")); //declare buffer reader
        
        //load the information into the array
        for(int i = 0; i < 5; i++) {
          quantityItems[i] = Integer.parseInt(input.readLine());
        }
        
        quantityItems[index] = quantityItems[index] + counter;
        
        input.close();
        
        //Create text file
        FileWriter file = new FileWriter("QuantityOfItems.txt");
        PrintWriter output = new PrintWriter(file); 
        
        for (int i = 0; i < 5; i++) {
          output.println(quantityItems[i]);
        }
        
        output.println(money);
        
        //Close file
        output.close();
        
        BufferedReader input2 = new BufferedReader(new FileReader("QuantityOfItems.txt")); //declare buffer reader
        
        //load the information into the array
        for(int i = 0; i < 5; i++) {
          quantityItems[i] = Integer.parseInt(input.readLine());
        }
        
        money = Integer.parseInt(input2.readLine());
        
        lblMoney.setText("Money: $" + money);
        
        input2.close();
        
      } catch (Exception error) { } 
    }
  }
  
  
  public static void main(String[] args) throws IOException { 
    new PokeMartShopping();
  }
}
