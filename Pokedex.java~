import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;  //import the Swing library
import javax.swing.Timer;
import javax.swing.border.Border;
import java.awt.*;    //import the Graphics library
import java.applet.*;
import java.net.*;
import java.io.*;
import java.awt.Color;

public class Pokedex extends JFrame implements ActionListener{
  /**
   * Author: Sarthak & Rakshit
   * Description: Program for pokedex which is a databse that contains information on pokemon
   * Citations: 
   * Code relating to scrollpane retrieved from "https://youtu.be/tcs-Sz1WPuU"
   * Code relating to creating custom borders retreived from "https://examples.javacodegeeks.com/desktop-java/swing/jlabel/create-jlabel-with-border/"
   * Code Relating to swing timers retrieved from "https://docs.oracle.com/javase/tutorial/uiswing/misc/timer.html"
   */
  //declare variables
  Border blackline, raisedetched, loweredetched,raisedbevel, loweredbevel, empty;
  JLabel logoP,background,sprite,btnMega,ball,load,load2,name,arrowR,arrowL,sortMethod,backJpic,searchIcon;
  JTextArea pokemon2,description;
  JTextField txtFind;
  JButton btnClear,btnCry,btnInfo,btnExit;
  JScrollPane scrollpane;
  String image = "pokeball2";
  String listDex,listAlpha,listType,listTotal,listHp,listAtk,listDef,listSpa,listSpd,listSpe;
  int counter=0;
  AudioClip cry,cryMega,megaE,loading,loading2;
  int move = -600,ballMove=200;
  String pokemon [],type [], type2 [],entry[],stats[];
  int hp[],atk[],def[],spa[],spd[],spe[],total[];
  String statLine;
  
  PokeMart pokemart;
  
  public Pokedex()throws IOException{
    //sets size and makes window unresizable
    setSize(800, 980);
    setResizable(false);
    setTitle("Pokedex");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Read();
    
    //declares variables sets bounds
    description=new JTextArea();
    description.setEditable(false);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    //create custom colors
    Color x = new Color (27, 27, 27);//creates custom color
    Color p = new Color (240, 0, 0);//creates custom color
    
    //creates labels text boxes and buttons
    scrollpane = new JScrollPane();
    scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    pokemon2=new JTextArea();
    pokemon2.setTabSize(13);
    logoP = new JLabel (new ImageIcon("pokedex.png"));
    background = new JLabel (new ImageIcon("back5.jpg"));
    load = new JLabel (new ImageIcon("load5.gif"));
    searchIcon = new JLabel (new ImageIcon("sIcon.png"));
    arrowR = new JLabel (new ImageIcon("rightArrowS.png"));
    arrowL = new JLabel (new ImageIcon("leftArrowS.png"));
    load2 = new JLabel (new ImageIcon("load7.gif"));
    sprite = new JLabel (new ImageIcon(image + ".gif"));
    ball = new JLabel (new ImageIcon("ball.png"));
    btnMega= new JLabel(new ImageIcon("mg.png"));
    btnMega.setVisible(false);
    description.setFont(new Font("Times New Roman", Font.ITALIC, 14));
    description.setForeground(Color.RED);
    pokemon2.setText(listDex);
    pokemon2.setEditable(false);
    description.setBackground(x);
    name = new JLabel ("");
    sortMethod = new JLabel("Sorted By Dex Entry");
    name.setFont(new Font("Times New Roman", Font.BOLD, 25));
    name.setForeground(Color.WHITE);
    sortMethod.setForeground(Color.WHITE);
    sortMethod.setFont(new Font("Times New Roman", Font.BOLD, 25));
    txtFind = new JTextField();
    txtFind.setOpaque( false );
    backJpic = new JLabel( new ImageIcon("pFall.gif"));
    backJpic.setLayout( new BorderLayout() );
    txtFind.setFont(new Font("Times New Roman", Font.BOLD, 25));
    txtFind.setForeground(Color.BLACK);
    backJpic.add(txtFind);
    btnCry = new JButton("Cry");
    btnClear = new JButton("Clear");
    btnInfo = new JButton("Info");
    btnExit = new JButton("Exit");
    btnCry.setForeground(Color.WHITE);
    btnCry.setBackground(Color.RED);
    btnClear.setForeground(Color.WHITE);
    btnClear.setBackground(Color.RED);
    btnInfo.setForeground(Color.WHITE);
    btnInfo.setBackground(Color.RED);
    btnExit.setForeground(Color.WHITE);
    btnExit.setBackground(Color.RED);
    
//sets bounds and sizes
    btnMega.setBackground(Color.BLACK);
    logoP.setBounds(100,0,600,120);
    background.setBounds(-200,-30,1000,1000);
    sprite.setBounds(75,170,500,320);
    ball.setBounds(200,400,150,150);
    load.setBounds(150,100,300,300);
    load2.setBounds(150,100,300,300);
    pokemon2.setBounds(50,500,600,350);
    btnMega.setBounds(470,260,70,70);
    backJpic.setBounds(350,868,300,60);
    searchIcon.setBounds(245,875,50,50);
    arrowR.setBounds(450,360,90,95);
    arrowL.setBounds(110,360,90,95);
    name.setBounds(120,110,200,150);
    sortMethod.setBounds(180,370,400,200);
    description.setBounds(50,150,583,350);
    btnCry.setBounds(90,270,70,25);
    btnInfo.setBounds(90,295,70,25);
    btnClear.setBounds(90,320,70,25);
    btnExit.setBounds(720,915,70,25);
    //pokemon.setBorder(new LineBorder(Color.GREEN,20));
    
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
    
    //sets borders to components
    pokemon2.setBorder(compound);
    backJpic.setBorder(compound);
    description.setBorder(compound);
    btnCry.setBorder(compound);
    btnInfo.setBorder(compound);
    btnClear.setBorder(compound);
    btnExit.setBorder(compound);
    
    //adds mouse listener to Jlabels
    pokemon2.addMouseListener(new GetPokemon());
    btnMega.addMouseListener(new MegaEvolve());
    arrowR.addMouseListener(new RightClick());
    arrowL.addMouseListener(new LeftClick());
    searchIcon.addMouseListener(new Search());
    
    scrollpane.setBounds(50,500,600,350);
    pokemon2.setBackground(Color.WHITE);
    //adds jtext area to scrollpane
    scrollpane.getViewport().add(pokemon2);
    //sets scrollpane color
    scrollpane.getViewport().getView().setBackground(p);
    scrollpane.getViewport().getView().setForeground(Color.red);
    scrollpane.getViewport().getView().setForeground(Color.WHITE);
    scrollpane.getVerticalScrollBar().setBackground(Color.BLACK);
    scrollpane.getHorizontalScrollBar().setBackground(Color.BLACK);
    
    //sets componets visibility to false for animation
    backJpic.setVisible(false);
    sprite.setVisible(false);
    arrowR.setVisible(false);
    arrowL.setVisible(false);
    searchIcon.setVisible(false);
    sortMethod.setVisible(false);
    btnCry.setVisible(false);
    btnClear.setVisible(false);
    btnInfo.setVisible(false);
    btnExit.setVisible(false);
    
    //sets bounds for animation
    scrollpane.setBounds(-600,500,600,350);
    description.setBounds(800,150,583,350);
    
    
    //creates font
    Font font = new Font("Dialog", Font.BOLD + Font.ITALIC, 14);
    
    //adds components
    scrollpane.getViewport().getView().setFont(font);
    add(arrowR);
    add(arrowL);
    add(btnCry);
    add(btnClear);
    add(btnInfo);
    add(btnExit);
    add(searchIcon);
    add(backJpic);
    add(sortMethod);
    add(name);
    add(load);
    add(load2);
    add(ball);
    add(sprite);
    add(btnMega);
    add(description);
    add(logoP);
    add(scrollpane);
    add(background);
    
    btnCry.addActionListener(this);
    btnInfo.addActionListener(this);
    btnClear.addActionListener(this);
    btnExit.addActionListener(this);
    
    setVisible(true);
    
    //plays audio file, and load screen
    
    URL path = getClass ().getResource ("init.wav"); //open the file
    loading = Applet.newAudioClip (path); //create audio clip
    loading.play();
    //starts timer
    timerInvisble.start();
    timerInvisble.setRepeats(false); 
  }
  //timer that sets loading icons to invisible
  Timer timerInvisble = new Timer( 5000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      load.setVisible(false);
      load2.setVisible(false);
      //uses timers to create animation
      x1.start();
      x2.start();
      x3.start();
      x4.start();
    }} );
  //timers x1-x5 used for animation
  Timer x1 = new Timer( 35, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      scrollpane.setBounds(move,500,600,350);
      ball.setBounds(ballMove,400,150,150);
      move=move+2;
      ballMove=ballMove + 2;
      ball.setIcon(new ImageIcon("ball2.png"));
      ball.setBounds(ballMove,400,150,150);
      //if statement that stops animation after text area is in desired position and starts timer for next animation
      if (move>50){
        x1.stop();
        x2.stop();
        x3.stop();
        x4.stop();
        x5.start();
        move=800;
      }
    }} );
  Timer x2 = new Timer( 42, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      ballMove=ballMove + 2;
      ball.setIcon(new ImageIcon("ball3.png"));
      ball.setBounds(ballMove,400,150,150);
    }} );
  Timer x3 = new Timer( 49, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      move=move+2;
      ballMove=ballMove + 2;
      ball.setIcon(new ImageIcon("ball4.png"));
      ball.setBounds(ballMove,400,150,150);
    }} );
  Timer x4 = new Timer( 56, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      move=move+2;
      ballMove=ballMove + 2;
      ball.setIcon(new ImageIcon("ball.png"));
      ball.setBounds(ballMove,400,150,150);
    }} );
  Timer x5 = new Timer( 3, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      description.setBounds(move,150,584,350);
      move=move-1;
      //if statements that stops timer when animation places text area in desired position and sets components to visible
      if (move<48){
        x5.stop();
        URL path = getClass ().getResource ("init2.wav"); //open the file
        loading2 = Applet.newAudioClip (path); //create audio clip
        loading2.play();
        backJpic.setVisible(true);
        sprite.setVisible(true);
        arrowR.setVisible(true);
        arrowL.setVisible(true);
        sortMethod.setVisible(true);
        searchIcon.setVisible(true);
        btnExit.setVisible(true);
      }
    }} );
  
///////////////////////////////////////////////////////////////////////////////
  
  //creates swing timers to delay program for animation without freezing GUI
  Timer timer = new Timer( 1150, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      
      sprite.setIcon(new ImageIcon(image+"-mega.gif"));
    }} );
  Timer timer2 = new Timer( 2000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      cryMega.play();
    }} );
  Timer timer3 = new Timer( 1150, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      
      sprite.setIcon(new ImageIcon(image+"-mega.gif"));
    }} ); 
  //class that displays pokemon and plays cry
  class GetPokemon extends MouseAdapter{
    public void mouseClicked(MouseEvent e){
      if(e.getClickCount() == 2){
        description.setText("");
        btnMega.setVisible(false);
        image = pokemon2.getSelectedText();
        //checks if the text selected is a pokemon
        if (image.matches(".*\\d.*")||image.matches("[^a-zA-Z0-9]")||image.matches("\\s+")||image.matches("Grass")||image.matches("Fire")||image.matches("Electric")||image.matches("Ice")||image.matches("Water")||image.matches("Poison")||image.matches("Ghost")||image.matches("Dark")||image.matches("Steel")||image.matches("Fighting")||image.matches("Fairy")||image.matches("Psychic")||image.matches("Rock")||image.matches("Bug")||image.matches("Flying")||image.matches("Normal")||image.matches("Ground")||image.matches("Base")||image.matches("Stats")||image.matches("Pokemon")||image.matches("Dex")||image.matches("Entry")||image.matches("Special")||image.matches("Attack")||image.matches("Defense")||image.matches("Hitpoints")||image.matches("Total")||image.matches("Type")){
          name.setText("Select a pokemon");
          sprite.setIcon(new ImageIcon("pokeball2.gif"));
          btnCry.setVisible(false);
          btnClear.setVisible(false);
          btnInfo.setVisible(false);
        }
        //displays sprite and plays cry if the text selected is apokemon
        else{
          name.setText(pokemon2.getSelectedText());
          btnCry.setVisible(true);
          btnClear.setVisible(true);
          btnInfo.setVisible(true);
          URL path = getClass ().getResource (image+".wav"); //open the file
          cry = Applet.newAudioClip (path); //create audio clip
          sprite.setIcon(new ImageIcon(image+".gif"));
          cry.play();
          //if statement which checks if the pokemon have mega forms
          if (image.equalsIgnoreCase("charizard")||image.equalsIgnoreCase("blastoise")||image.equalsIgnoreCase("venusaur")||image.equalsIgnoreCase("beedrill")||image.equalsIgnoreCase("alakazam")||image.equalsIgnoreCase("slowbro")||image.equalsIgnoreCase("gengar")||image.equalsIgnoreCase("kangaskhan")||image.equalsIgnoreCase("groudon")||image.equalsIgnoreCase("kyogre")||image.equalsIgnoreCase("shaymin")||image.equalsIgnoreCase("giratina")||image.equalsIgnoreCase("rayquaza")||image.equalsIgnoreCase("pinsir")||image.equalsIgnoreCase("aerodactyl")||image.equalsIgnoreCase("gyarados")||image.equalsIgnoreCase("mewtwo")||image.equalsIgnoreCase("scizor")||image.equalsIgnoreCase("ampharos")||image.equalsIgnoreCase("tyranitar")||image.equalsIgnoreCase("houndoom")||image.equalsIgnoreCase("sceptile")||image.equalsIgnoreCase("swampert")||image.equalsIgnoreCase("blaziken")||image.equalsIgnoreCase("gardevoir")||image.equalsIgnoreCase("sableye")||image.equalsIgnoreCase("mawile")||image.equalsIgnoreCase("medicham")||image.equalsIgnoreCase("aggron")||image.equalsIgnoreCase("manectric")||image.equalsIgnoreCase("sharpedo")||image.equalsIgnoreCase("camerupt")||image.equalsIgnoreCase("altaria")||image.equalsIgnoreCase("banette")||image.equalsIgnoreCase("absol")||image.equalsIgnoreCase("salamence")||image.equalsIgnoreCase("metagross")||image.equalsIgnoreCase("latias")||image.equalsIgnoreCase("latios")||image.equalsIgnoreCase("lopunny")||image.equalsIgnoreCase("garchomp")||image.equalsIgnoreCase("lucario")||image.equalsIgnoreCase("abomasnow")||image.equalsIgnoreCase("gallade")||image.equalsIgnoreCase("audino")||image.equalsIgnoreCase("diancie")||image.equalsIgnoreCase("greninja")||image.equalsIgnoreCase("pidgeot")||image.equalsIgnoreCase("hoopa")||image.equalsIgnoreCase("zygarde")){
            btnMega.setVisible(true);
            URL path2 = getClass ().getResource (image+" (Mega).wav"); //open the file
            cryMega = Applet.newAudioClip (path2); //create audio clip
            URL path3 = getClass ().getResource ("megaE.wav"); //open the file
            megaE = Applet.newAudioClip (path3); //create audio clip
          }}}}}
  
  //class that mega evolves pokemon- changes sprite
  class MegaEvolve extends MouseAdapter{
    public void mouseClicked(MouseEvent e){
      if(e.getClickCount() == 1){
        btnMega.setVisible(false);
        description.setText("");
        sprite.setIcon(new ImageIcon("megaAnimation.gif"));
        timer.setRepeats(false);
        timer.start();
        megaE.play();
        name.setText("Mega "+ image);
        timer2.setRepeats(false);
        timer2.start();
      }}}
  //class that goes through sorted lists on right click +1 for counter
  class RightClick extends MouseAdapter{
    public void mouseClicked(MouseEvent e){
      if(e.getClickCount() == 1){
        counter = counter +1;
        
        //uses if statements to check counter for which list to display
        if(counter>9){
          counter =0;
        }
        if (counter==9){
          pokemon2.setText(listTotal);
          sortMethod.setText("Sorted by Stat Total");
          pokemon2.setCaretPosition(114);
        }
        else if (counter==8){
          pokemon2.setText(listSpe);
          sortMethod.setText("Sorted by Speed Stat");
          pokemon2.setCaretPosition(114);
        }
        else if (counter==7){
          pokemon2.setText(listSpd);
          sortMethod.setText("Sorted by Special Defense Stat");
          pokemon2.setCaretPosition(114);
          
        }
        else if (counter==6){
          pokemon2.setText(listSpa);
          sortMethod.setText("Sorted by Special Attack Stat");
          pokemon2.setCaretPosition(109);
        }
        else if (counter==5){
          pokemon2.setText(listDef);
          sortMethod.setText("Sorted by Defense Stat");
          pokemon2.setCaretPosition(96);
        }
        else if (counter==4){
          pokemon2.setText(listAtk);
          sortMethod.setText("Sorted by Attack Stat");
          pokemon2.setCaretPosition(88);
        }
        else if (counter==3){
          pokemon2.setText(listHp);
          sortMethod.setText("Sorted by Hitpoints");
          pokemon2.setCaretPosition(74);
        }
        else if (counter==2){
          pokemon2.setText(listType);
          sortMethod.setText("Sorted by Type");
          pokemon2.setCaretPosition(0);
        }
        else if (counter==1){
          pokemon2.setText(listAlpha);
          sortMethod.setText("Sorted by Alphabetical Order");
          pokemon2.setCaretPosition(0);
        }
        else if (counter==0){
          pokemon2.setText(listDex);
          sortMethod.setText("Sorted by Dex Entry");
          pokemon2.setCaretPosition(0);
        }
      }}}
  //class that goes through sorted lists on left click -1 from counter
  class LeftClick extends MouseAdapter{
    public void mouseClicked(MouseEvent e){
      //uses if statements to check counter for which list to display
      if(e.getClickCount() == 1){
        counter = counter -1;
        if(counter<0){
          counter =9;
        }
        if (counter==9){
          pokemon2.setText(listTotal);
          sortMethod.setText("Sorted by Stat Total");
          pokemon2.setCaretPosition(114);
        }
        else if (counter==8){
          pokemon2.setText(listSpe);
          sortMethod.setText("Sorted by Speed Stat");
          pokemon2.setCaretPosition(114);
        }
        else if (counter==7){
          pokemon2.setText(listSpd);
          sortMethod.setText("Sorted by Special Defense Stat");
          pokemon2.setCaretPosition(114);
          
        }
        else if (counter==6){
          pokemon2.setText(listSpa);
          sortMethod.setText("Sorted by Special Attack Stat");
          pokemon2.setCaretPosition(109);
        }
        else if (counter==5){
          pokemon2.setText(listDef);
          sortMethod.setText("Sorted by Defense Stat");
          pokemon2.setCaretPosition(96);
        }
        else if (counter==4){
          pokemon2.setText(listAtk);
          sortMethod.setText("Sorted by Attack Stat");
          pokemon2.setCaretPosition(88);
        }
        else if (counter==3){
          pokemon2.setText(listHp);
          sortMethod.setText("Sorted by Hitpoints");
          pokemon2.setCaretPosition(74);
        }
        else if (counter==2){
          pokemon2.setText(listType);
          sortMethod.setText("Sorted by Type");
          pokemon2.setCaretPosition(0);
        }
        else if (counter==1){
          pokemon2.setText(listAlpha);
          sortMethod.setText("Sorted by Alphabetical Order");
          pokemon2.setCaretPosition(0);
        }
        else if (counter==0){
          pokemon2.setText(listDex);
          sortMethod.setText("Sorted by Dex Entry");
          pokemon2.setCaretPosition(0);
        }
      }}}
  
  //class that searches for pokemon info
  class Search extends MouseAdapter{
    public void mouseClicked(MouseEvent e){
      if(e.getClickCount() == 1){
        
        try{
          //gets text from tetx field and inputs into searching method to get information
          String input = txtFind.getText();
          String info = PokedexSort.getInfo(input,pokemon,type ,type2,entry,total,hp,atk,def,spa,spd,spe);
          
          if(info.equalsIgnoreCase(input +" not found")==false){
            sprite.setIcon(new ImageIcon(input+".gif"));
            name.setText(input);description.setText(info);
            txtFind.setText("");btnMega.setVisible(false);
            image=input;
            URL path = getClass ().getResource (image+".wav"); //open the file
            cry = Applet.newAudioClip (path); //create audio clip
            btnCry.setVisible(true);
            btnClear.setVisible(true);
            btnInfo.setVisible(true);
            //if statements that checks if searched pokemon has mega form
            if (image.equalsIgnoreCase("charizard")||image.equalsIgnoreCase("blastoise")||image.equalsIgnoreCase("venusaur")||image.equalsIgnoreCase("beedrill")||image.equalsIgnoreCase("alakazam")||image.equalsIgnoreCase("slowbro")||image.equalsIgnoreCase("gengar")||image.equalsIgnoreCase("kangaskhan")||image.equalsIgnoreCase("groudon")||image.equalsIgnoreCase("kyogre")||image.equalsIgnoreCase("shaymin")||image.equalsIgnoreCase("giratina")||image.equalsIgnoreCase("rayquaza")||image.equalsIgnoreCase("pinsir")||image.equalsIgnoreCase("aerodactyl")||image.equalsIgnoreCase("gyarados")||image.equalsIgnoreCase("mewtwo")||image.equalsIgnoreCase("scizor")||image.equalsIgnoreCase("ampharos")||image.equalsIgnoreCase("tyranitar")||image.equalsIgnoreCase("houndoom")||image.equalsIgnoreCase("sceptile")||image.equalsIgnoreCase("swampert")||image.equalsIgnoreCase("blaziken")||image.equalsIgnoreCase("gardevoir")||image.equalsIgnoreCase("sableye")||image.equalsIgnoreCase("mawile")||image.equalsIgnoreCase("medicham")||image.equalsIgnoreCase("aggron")||image.equalsIgnoreCase("manectric")||image.equalsIgnoreCase("sharpedo")||image.equalsIgnoreCase("camerupt")||image.equalsIgnoreCase("altaria")||image.equalsIgnoreCase("banette")||image.equalsIgnoreCase("absol")||image.equalsIgnoreCase("salamence")||image.equalsIgnoreCase("metagross")||image.equalsIgnoreCase("latias")||image.equalsIgnoreCase("latios")||image.equalsIgnoreCase("lopunny")||image.equalsIgnoreCase("garchomp")||image.equalsIgnoreCase("lucario")||image.equalsIgnoreCase("abomasnow")||image.equalsIgnoreCase("gallade")||image.equalsIgnoreCase("audino")||image.equalsIgnoreCase("diancie")||image.equalsIgnoreCase("greninja")||image.equalsIgnoreCase("pidgeot")||image.equalsIgnoreCase("hoopa")||image.equalsIgnoreCase("zygarde")){
              btnMega.setVisible(true);
              URL path2 = getClass ().getResource (image+" (Mega).wav"); //open the file
              cryMega = Applet.newAudioClip (path2); //create audio clip
              URL path3 = getClass ().getResource ("megaE.wav"); //open the file
              megaE = Applet.newAudioClip (path3); //create audio clip
            }}
          else {
            //if searched pokemon is not found
            name.setText("not found");
            sprite.setIcon(new ImageIcon("pokeball2.gif"));
            txtFind.setText("");description.setText("");
            btnMega.setVisible(false);
            btnCry.setVisible(false);
            btnClear.setVisible(false);
            btnInfo.setVisible(false);
          }
          
          
        }catch (Exception error){//catches error
        }
        
      }}}
  
  //actions performed on button click
  public void actionPerformed(ActionEvent evt) {
    if(evt.getSource () == btnCry) {
      cry.play();  
    }
    
    else if(evt.getSource () == btnInfo) {
      try{
        String input = image;
        String info = PokedexSort.getInfo(input,pokemon,type ,type2,entry,total,hp,atk,def,spa,spd,spe);
        description.setText(info);
      }catch (Exception error){//catches error
      }
    }
    
    else if(evt.getSource () == btnClear){
      name.setText("Select Pokemon");
      sprite.setIcon(new ImageIcon("pokeball2.gif"));
      txtFind.setText("");description.setText("");
      btnMega.setVisible(false);
      btnCry.setVisible(false);
      btnClear.setVisible(false);
      btnInfo.setVisible(false);
    }
    else if(evt.getSource () == btnExit){
      try{
        setVisible(false);
        pokemart = new PokeMart();
      }catch (Exception error){}//catches error
    }
  }
    
    
    public void Read() throws IOException{
      
      //reads files
      BufferedReader input = new BufferedReader(new FileReader("pokemon.txt"));//declare buffer reader
      BufferedReader input2 = new BufferedReader(new FileReader("type.txt"));//declare buffer reader
      BufferedReader input3 = new BufferedReader(new FileReader("type2.txt"));//declare buffer reader
      BufferedReader input4 = new BufferedReader(new FileReader("entry.txt"));//declare buffer reader
      BufferedReader input5 = new BufferedReader(new FileReader("stats.txt"));
      
      //gets number of lines in file
      int lines = PokedexSort.getLines();
      //sets begin and end variables for quicksort
      int begin=0, end=lines-1;
      
      //creates arrays
      pokemon = new String [lines];
      type = new String [lines];
      type2 = new String [lines];
      entry = new String [lines];
      hp = new int [lines];
      atk = new int [lines];
      def = new int [lines];
      spa = new int [lines];
      spd = new int [lines];
      spe = new int [lines];
      total = new int [lines];
      
      //reads files
      for (int i = 0;i < lines;i++) {
        statLine=input5.readLine();
        stats =  statLine.split(",");
        hp[i] = Integer.parseInt(stats[0]);
        atk[i] = Integer.parseInt(stats[1]);
        def[i] = Integer.parseInt(stats[2]);
        spa[i] = Integer.parseInt(stats[3]);   
        spd[i] = Integer.parseInt(stats[4]); 
        spe[i] = Integer.parseInt(stats[5]);
        total[i] = Integer.parseInt(stats[6]);                         
        pokemon [i] = input.readLine();
        type [i] = input2.readLine();
        type2 [i] = input3.readLine();
        entry[i] = input4.readLine();
      }
      
      //closes files
      input.close();
      input2.close();
      input3.close();
      input4.close();
      input5.close();
      
      //calls methods to get sorted lists
      listDex = PokedexSort.View(pokemon,type,type2,lines,entry,total,hp,atk,def,spa,spd,spe);
      String array1[] =pokemon;
      String array2[] = pokemon;
      PokedexSort.quickSortAlpha(array1,array2,pokemon,type ,type2,lines,entry,total,hp,atk,def,spa,spd,spe,begin,end);
      listAlpha =PokedexSort.View(pokemon,type,type2,lines,entry,total,hp,atk,def,spa,spd,spe);
      String arrayType[] =type;
      String arrayType2[] = type2;
      PokedexSort.quickSortAlpha(arrayType,arrayType2,pokemon,type ,type2,lines,entry,total,hp,atk,def,spa,spd,spe,begin,end);
      listType =PokedexSort.View(pokemon,type,type2,lines,entry,total,hp,atk,def,spa,spd,spe);
      int arrayNumber[]=hp;
      PokedexSort.quickSortDig(arrayNumber,pokemon,type ,type2,lines,entry,total,hp,atk,def,spa,spd,spe,begin,end);
      listHp =PokedexSort.View(pokemon,type,type2,lines,entry,total,hp,atk,def,spa,spd,spe);
      int arrayNumber2[]=atk;
      PokedexSort.quickSortDig(arrayNumber2,pokemon,type ,type2,lines,entry,total,hp,atk,def,spa,spd,spe,begin,end);
      listAtk =PokedexSort.View(pokemon,type,type2,lines,entry,total,hp,atk,def,spa,spd,spe);
      int arrayNumber3[]=def;
      PokedexSort.quickSortDig(arrayNumber3,pokemon,type ,type2,lines,entry,total,hp,atk,def,spa,spd,spe,begin,end);
      listDef =PokedexSort.View(pokemon,type,type2,lines,entry,total,hp,atk,def,spa,spd,spe);
      int arrayNumber4[]=spa;
      PokedexSort.quickSortDig(arrayNumber4,pokemon,type ,type2,lines,entry,total,hp,atk,def,spa,spd,spe,begin,end);
      listSpa =PokedexSort.View(pokemon,type,type2,lines,entry,total,hp,atk,def,spa,spd,spe);
      int arrayNumber5[]=spd;
      PokedexSort.quickSortDig(arrayNumber5,pokemon,type ,type2,lines,entry,total,hp,atk,def,spa,spd,spe,begin,end);
      listSpd =PokedexSort.View(pokemon,type,type2,lines,entry,total,hp,atk,def,spa,spd,spe);
      int arrayNumber6[]=spe;
      PokedexSort.quickSortDig(arrayNumber6,pokemon,type ,type2,lines,entry,total,hp,atk,def,spa,spd,spe,begin,end);
      listSpe =PokedexSort.View(pokemon,type,type2,lines,entry,total,hp,atk,def,spa,spd,spe);
      int arrayNumber7[]=total;
      PokedexSort.quickSortDig(arrayNumber7,pokemon,type ,type2,lines,entry,total,hp,atk,def,spa,spd,spe,begin,end);
      listTotal =PokedexSort.View(pokemon,type,type2,lines,entry,total,hp,atk,def,spa,spd,spe);
      
    }
    //main method
    public static void main(String args[])throws IOException{
      //calls method to create gui 
      new Pokedex();
    }}