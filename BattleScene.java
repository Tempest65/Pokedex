import java.awt.event.*;
import javax.swing.*;  //import the Swing library
import javax.swing.Timer;
import javax.swing.border.Border;
import java.awt.*;    //import the Graphics library
import java.applet.*;
import java.net.*;
import java.io.*;
/**
 * Auto Generated Java Class.
 */
public class BattleScene extends JFrame implements ActionListener {
  Border blackline, raisedetched, loweredetched,raisedbevel, loweredbevel, empty;
  JButton btnFireBlast,btnFireSpin,btnMegaPunch,btnSeismicToss,btnEnd,btnSkip,btnSkip2;
  JLabel animation,background,narrate,storm;
  AudioClip song,audio,audio2,audio3,audio4,audio5,audio6,audio7,audio8,audio9,song2,start;
  int counter = 0,delay=232000,delay2=238000;
  public BattleScene()throws IOException{
    setSize(800, 980);
    setResizable(false);
    setTitle("Battle");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    animation = new JLabel (new ImageIcon("1.png"));
    narrate = new JLabel ("The Rivals have an unexpected encounter");
    
    background = new JLabel (new ImageIcon("moveB.jpg"));
    storm = new JLabel (new ImageIcon("storm2.gif"));
    //declares border
    Border compound;
    //creates components of compound border
    Border line = BorderFactory.createLineBorder(Color.BLACK);
    raisedbevel = BorderFactory.createRaisedBevelBorder();
    loweredbevel = BorderFactory.createLoweredBevelBorder();
    btnFireBlast= new JButton("Fireblast");
    btnEnd= new JButton("End It");
    btnSkip= new JButton("Skip");
    btnSkip2= new JButton("Skip");
    btnFireSpin= new JButton("Firespin");
    btnMegaPunch= new JButton("Mega Punch");
    btnSeismicToss= new JButton("Seismic Toss");
    Font font = new Font("Dialog", Font.BOLD + Font.ITALIC, 20);
    btnFireBlast.setFont(font);
    btnFireSpin.setFont(font);
    btnMegaPunch.setFont(font);
    btnSkip.setFont(font);
    btnSkip2.setFont(font);
    btnSeismicToss.setFont(font);
    narrate.setFont(font);
    
    btnEnd.setIcon(new ImageIcon("fire3.gif"));
    btnEnd.setBackground(Color.RED);
    btnFireBlast.setBackground(Color.RED);
    btnFireSpin.setBackground(Color.RED);
    btnMegaPunch.setBackground(Color.RED);
    btnSeismicToss.setBackground(Color.RED);
    btnFireBlast.setForeground(Color.WHITE);
    btnSkip.setBackground(Color.RED);
    btnSkip.setForeground(Color.WHITE);
    btnSkip2.setBackground(Color.RED);
    btnSkip2.setForeground(Color.WHITE);
    narrate.setForeground(Color.RED);
    btnFireSpin.setForeground(Color.WHITE);
    btnMegaPunch.setForeground(Color.WHITE);
    btnSeismicToss.setForeground(Color.WHITE);
//This creates a neat frame
    compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
    
//Adds an outline to the frame.
    compound = BorderFactory.createCompoundBorder(line, compound);
    background.setBounds(-5,400,800,650);
    narrate.setBounds(160,450,600,50);
    btnSkip.setBounds(600,850,100,50);
    btnSkip2.setBounds(600,850,100,50);
    btnFireBlast.setBounds(530,550,200,50);
    btnEnd.setBounds(200,660,300,70);
    animation.setBounds(90,10,600,500);
    storm.setBounds(0,0,800,600);
    btnFireSpin.setBounds(70,550,200,50);
    btnMegaPunch.setBounds(70,700,200,50);
    btnSeismicToss.setBounds(530,700,200,50);
    btnFireSpin.setBorder(compound);
    btnSkip.setBorder(compound);
    btnSkip2.setBorder(compound);
    btnFireBlast.setBorder(compound);
    btnMegaPunch.setBorder(compound);
    btnSeismicToss.setBorder(compound);
    btnEnd.setBorder(compound);
    
    add(animation);
    add(btnSkip);
    add(btnSkip2);
    add(narrate);
    add(btnFireBlast);
    add(btnEnd);
    add(btnFireSpin);
    add(btnMegaPunch);
    add(btnSeismicToss);
    add(background);
    add(storm);
    btnSkip2.addActionListener(this);
    btnSkip.addActionListener(this);
    btnSeismicToss.addActionListener(this);
    btnMegaPunch.addActionListener(this);
    btnFireSpin.addActionListener(this);
    btnFireBlast.addActionListener(this);
    btnEnd.addActionListener(this);
    btnSeismicToss.setVisible(false);
    btnFireBlast.setVisible(false);
    btnFireSpin.setVisible(false);
    btnMegaPunch.setVisible(false);
    btnEnd.setVisible(false);
    btnSkip.setVisible(false);
    
    URL path = getClass ().getResource ("battleMusic.wav"); //open the file
    song = Applet.newAudioClip (path); //create audio clip
    URL pathS = getClass ().getResource ("start2.wav"); //open the file
    start = Applet.newAudioClip (pathS); //create audio clip
    URL path2 = getClass ().getResource ("endXX.wav"); //open the file
    audio = Applet.newAudioClip (path2); //create audio clip
    URL path3 = getClass ().getResource ("end2.wav"); //open the file
    audio2 = Applet.newAudioClip (path3); //create audio clip
    URL path4 = getClass ().getResource ("end3.2.wav"); //open the file
    audio3 = Applet.newAudioClip (path4); //create audio clip
    URL path5 = getClass ().getResource ("end4.1.wav"); //open the file
    audio4 = Applet.newAudioClip (path5); //create audio clip
    URL path6 = getClass ().getResource ("end5.1.wav"); //open the file
    audio5 = Applet.newAudioClip (path6); //create audio clip
    URL path7 = getClass ().getResource ("end6.1.wav"); //open the file
    audio6 = Applet.newAudioClip (path7); //create audio clip
    URL path8 = getClass ().getResource ("end7.1.wav"); //open the file
    audio7 = Applet.newAudioClip (path8); //create audio clip
    URL path9 = getClass ().getResource ("end8.1.wav"); //open the file
    audio8 = Applet.newAudioClip (path9); //create audio clip
    URL path10 = getClass ().getResource ("end9.1.wav"); //open the file
    audio9 = Applet.newAudioClip (path10); //create audio clip
    setVisible(true);
    
    animation.setIcon(new ImageIcon("start.gif"));
    start.play();
    timerX.start();
    timerX.setRepeats(false);
    timer.start();
    timer.setRepeats(false);
    timer0.start();
    timer0.setRepeats(false);
    timer1.start();
    timer1.setRepeats(false);
    timer2.start();
    timer2.setRepeats(false);
    timer3.start();
    timer3.setRepeats(false);
    timer4.start();
    timer4.setRepeats(false);
    timer5.start();
    timer5.setRepeats(false);
    
    URL path11 = getClass ().getResource ("victory.wav"); //open the file
    song2 = Applet.newAudioClip (path11); //create audio clip
    
    
  }
  
  //creates swing timers to delay program for animation without freezing GUI
  //////////////////////////////////////////////////////////////////////////////
  Timer timerX = new Timer( 32000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setIcon(new ImageIcon("start2.gif"));
    }} );
  Timer timer = new Timer( 39425, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      start.stop();
      song.loop();
      animation.setIcon(new ImageIcon("1.png"));
      narrate.setText("The Rivals clash! fighting battle after battle");
    }} );
  Timer timer0 = new Timer( 42425, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setIcon(new ImageIcon("battle.gif"));
    }} );
  
  Timer timer2 = new Timer( 64000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      narrate.setText("After many battles they each are down to their last pokemon");
      animation.setIcon(new ImageIcon("blastoise entrance.gif"));
    }} );
  Timer timer1 = new Timer( 73500, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      narrate.setText("");
      animation.setIcon(new ImageIcon("2.png"));
    }} );
  Timer timer3 = new Timer( 75500, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      narrate.setText("After many battles they each are down to their last pokemon");
      animation.setIcon(new ImageIcon("Charizard entrance.gif"));
    }} ); 
  Timer timer4 = new Timer( 84000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      narrate.setText("");
      animation.setIcon(new ImageIcon("3.png"));
    }} ); 
  Timer timer5 = new Timer( 86000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      btnSkip2.setVisible(false);
      narrate.setText("");
      btnSeismicToss.setVisible(true);
      btnFireBlast.setVisible(true);
      btnFireSpin.setVisible(true);
      btnMegaPunch.setVisible(true);
      animation.setIcon(new ImageIcon("4.png"));
    }} ); 
  Timer timer6 = new Timer( 6500, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      narrate.setText("");
      btnSeismicToss.setVisible(false);
      btnFireBlast.setVisible(false);
      btnFireSpin.setVisible(false);
      btnMegaPunch.setVisible(false);
      animation.setIcon(new ImageIcon("5.png"));
    }} ); 
  Timer timer7 = new Timer( 9500, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setIcon(new ImageIcon("hydropump.gif"));
    }} );  
  Timer timer8 = new Timer( 18000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setIcon(new ImageIcon("6.png"));
    }} );  
  Timer timer9 = new Timer( 23500, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      btnSeismicToss.setVisible(true);
      btnFireBlast.setVisible(true);
      btnFireSpin.setVisible(true);
      btnMegaPunch.setVisible(true);
      animation.setIcon(new ImageIcon("4.png"));
    }} );
  Timer timerCounter = new Timer( 23500, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      if(counter==4){
        btnSeismicToss.setVisible(false);
        btnFireBlast.setVisible(false);
        btnFireSpin.setVisible(false);
        btnMegaPunch.setVisible(false);
        narrate.setBounds(160,480,600,50);
        narrate.setText("Blastoise is weakened, now's your chance");
        btnEnd.setVisible(true);
      }
    }} );  
  
  Timer timer10 = new Timer( 6000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      narrate.setText("");
      animation.setIcon(new ImageIcon("7.png"));
    }} );  
  Timer timer11 = new Timer( 8000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setIcon(new ImageIcon("8.png"));
    }} );
  Timer timer12 = new Timer( 10000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setIcon(new ImageIcon("skull bash.gif"));
    }} );  
  Timer timer13 = new Timer( 13200, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setIcon(new ImageIcon("9.png"));
    }} );  
  Timer timer14 = new Timer( 15000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setIcon(new ImageIcon("withstood.gif"));
    }} );  
  Timer timer15 = new Timer( 18200, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      btnSeismicToss.setVisible(true);
      btnFireBlast.setVisible(true);
      btnFireSpin.setVisible(true);
      btnMegaPunch.setVisible(true);
      animation.setIcon(new ImageIcon("4.png"));
    }} );
  Timer timerCounter2 = new Timer( 18200, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      if(counter==4){
        btnSeismicToss.setVisible(false);
        btnFireBlast.setVisible(false);
        btnFireSpin.setVisible(false);
        btnMegaPunch.setVisible(false);
        narrate.setBounds(160,480,600,50);
        narrate.setText("Blastoise is weakened, now's your chance");
        btnEnd.setVisible(true);
      }
    }} );  
  Timer timer16 = new Timer( 7000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      narrate.setText("");
      animation.setIcon(new ImageIcon("10.png"));
    }} );
  Timer timer17 = new Timer( 9000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setIcon(new ImageIcon("holdStrong.gif"));
    }} );  
  Timer timer18 = new Timer( 11500, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setIcon(new ImageIcon("clip.gif"));
    }} );  
  Timer timer19 = new Timer( 14000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setIcon(new ImageIcon("11.png"));
    }} );  
  Timer timer20 = new Timer( 17500, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      btnSeismicToss.setVisible(true);
      btnFireBlast.setVisible(true);
      btnFireSpin.setVisible(true);
      btnMegaPunch.setVisible(true);
      animation.setIcon(new ImageIcon("4.png"));
    }} );
  Timer timerCounter3 = new Timer( 17500, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      if(counter==4){
        btnSeismicToss.setVisible(false);
        btnFireBlast.setVisible(false);
        btnFireSpin.setVisible(false);
        btnMegaPunch.setVisible(false);
        narrate.setBounds(160,480,600,50);
        narrate.setText("Blastoise is weakened, now's your chance");
        btnEnd.setVisible(true);
      }
    }} );  
  
  Timer timer21 = new Timer( 2700, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      narrate.setText("");
      animation.setIcon(new ImageIcon("5.png"));
    }} );
  Timer timer22 = new Timer( 4700, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setIcon(new ImageIcon("hydro2.gif"));
    }} );
  Timer timer23 = new Timer( 6800, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setIcon(new ImageIcon("12.png"));
    }} );
  Timer timer24 = new Timer( 9800, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setIcon(new ImageIcon("flamethrower.gif"));
    }} );
  Timer timer25 = new Timer( 13000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setIcon(new ImageIcon("4.png"));
      btnSeismicToss.setVisible(true);
      btnFireBlast.setVisible(true);
      btnFireSpin.setVisible(true);
      btnMegaPunch.setVisible(true);
    }} );
  Timer timerCounter4 = new Timer( 13000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      if(counter==4){
        btnSeismicToss.setVisible(false);
        btnFireBlast.setVisible(false);
        btnFireSpin.setVisible(false);
        btnMegaPunch.setVisible(false);
        narrate.setBounds(160,480,600,50);
        narrate.setText("Blastoise is weakened, now's your chance");
        btnEnd.setVisible(true);
      }
    }} );  
  Timer timerEnd = new Timer( 33000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setIcon(new ImageIcon("13.png"));
      
    }} );
  Timer timerEnd2 = new Timer( 40000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      audio2.play();
      animation.setIcon(new ImageIcon("end2.gif"));
      btnSkip.setVisible(true);
    }} );
  Timer timerEnd3 = new Timer( 51500, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setIcon(new ImageIcon("14.png"));
      
    }} );
  Timer timerEnd4 = new Timer( 54000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      audio2.stop();
      animation.setIcon(new ImageIcon("end3.gif"));
      audio3.play();
    }} );
  Timer timerEnd5 = new Timer( 74000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      audio3.stop();
      animation.setIcon(new ImageIcon("end4.gif"));
      audio4.play();
    }} );
  Timer timerEnd6 = new Timer( 100700, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setIcon(new ImageIcon("end5.gif"));
      audio5.play();
    }} );
  Timer timerEnd7 = new Timer( 134000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      audio4.stop();
      animation.setIcon(new ImageIcon("end6.gif"));
      audio6.play();
    }} );
  Timer timerEnd8 = new Timer( 166000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      audio5.stop();
      audio6.stop();
      animation.setIcon(new ImageIcon("end7.gif"));
      audio7.play();
    }} );
  Timer timerEnd9 = new Timer( 191000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      audio7.stop();
      animation.setIcon(new ImageIcon("end8.gif"));
      audio8.play();
    }} );
  Timer timerEnd10 = new Timer( 217000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setIcon(new ImageIcon("end9.gif"));
      audio9.play();
    }} );
  Timer timerEnd11 = new Timer( 227000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      audio8.stop();
      audio9.stop();
      song2.loop();
      animation.setIcon(new ImageIcon("15.png"));
      
    }} );
  Timer timerEnd12 = new Timer( delay, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      animation.setIcon(new ImageIcon("final.gif"));
      
    }} );
  Timer timerNext = new Timer(238000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      try{
        song2.stop();
        new EntranceToPokeMart();
        dispose();
        
      } catch (Exception error){
      }
      
    }} );
   Timer timerNext2 = new Timer(3000, new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e ){
      try{
        song2.stop();
        new EntranceToPokeMart();
        dispose();
        
      } catch (Exception error){
      }
      
    }} );
  //////////////////////////////////////////////////////////////////////////////////////////
  //action listener for buttons
  public void actionPerformed(ActionEvent evt) { 
    btnSeismicToss.setVisible(false);
    btnFireBlast.setVisible(false);
    btnFireSpin.setVisible(false);
    btnMegaPunch.setVisible(false);
    if(evt.getSource () == btnFireBlast) {
      animation.setIcon(new ImageIcon("fireblast.gif"));
      narrate.setText("Charizard uses fireblast!");
      timer6.start();
      timer6.setRepeats(false);
      timer7.start();
      timer7.setRepeats(false);
      timer8.start();
      timer8.setRepeats(false);
      timer9.start();
      timer9.setRepeats(false);
      counter = counter +1;
      timerCounter.start();
      timerCounter.setRepeats(false);
    }
    else if(evt.getSource () == btnFireSpin){//if clear button is clicked resets text fields and labels
      animation.setIcon(new ImageIcon("firespin.gif"));
      narrate.setText("Charizard uses firespin!");
      timer10.start();
      timer10.setRepeats(false);
      timer11.start();
      timer11.setRepeats(false);
      timer12.start();
      timer12.setRepeats(false);
      timer13.start();
      timer13.setRepeats(false);
      timer14.start();
      timer14.setRepeats(false);
      timer15.start();
      timer15.setRepeats(false);
      counter = counter +1;
      timerCounter2.start();
      timerCounter2.setRepeats(false);
    }
    else if (evt.getSource () == btnSeismicToss) {
      animation.setIcon(new ImageIcon("seismictoss.gif"));
      narrate.setText("Charizard uses seismic toss!");
      timer21.start();
      timer21.setRepeats(false);
      timer22.start();
      timer22.setRepeats(false);
      timer23.start();
      timer23.setRepeats(false);
      timer24.start();
      timer24.setRepeats(false);
      timer25.start();
      timer25.setRepeats(false);
      counter = counter +1;
      timerCounter4.start();
      timerCounter4.setRepeats(false);
    }
    //plays music
    else if (evt.getSource () == btnMegaPunch) {
      animation.setIcon(new ImageIcon("mega punch.gif"));
      narrate.setText("Charizard uses mega punch!");
      timer16.start();
      timer16.setRepeats(false);
      timer17.start();
      timer17.setRepeats(false);
      timer18.start();
      timer18.setRepeats(false);
      timer19.start();
      timer19.setRepeats(false);
      timer20.start();
      timer20.setRepeats(false);
      counter = counter + 1;
      timerCounter3.start();
      timerCounter3.setRepeats(false);
    }
    
    else if (evt.getSource () == btnEnd) {
      btnEnd.setVisible(false);
      narrate.setText("");
      song.stop();
      audio.play();
      animation.setIcon(new ImageIcon("end.gif"));
      timerEnd.start();
      timerEnd.setRepeats(false);
      timerEnd2.start();
      timerEnd2.setRepeats(false);
      timerEnd3.start();
      timerEnd3.setRepeats(false);
      timerEnd4.start();
      timerEnd4.setRepeats(false);
      timerEnd5.start();
      timerEnd5.setRepeats(false);
      timerEnd6.start();
      timerEnd6.setRepeats(false);
      timerEnd7.start();
      timerEnd7.setRepeats(false);
      timerEnd8.start();
      timerEnd8.setRepeats(false);
      timerEnd9.start();
      timerEnd9.setRepeats(false);
      timerEnd10.start();
      timerEnd10.setRepeats(false);
      timerEnd11.start();
      timerEnd11.setRepeats(false);
      timerEnd12.start();
      timerEnd12.setRepeats(false);
      timerNext.start();
      timerNext.setRepeats(false);
    }
    else if (evt.getSource () == btnSkip) {
      song.stop();
      audio2.stop();
      audio3.stop();
      audio4.stop();
      audio5.stop();
      audio6.stop();
      audio7.stop();
      audio8.stop();
      audio9.stop();
      timerEnd.stop();
      timerEnd2.stop();
      timerEnd3.stop();
      timerEnd4.stop();
      timerEnd5.stop();
      timerEnd6.stop();
      timerEnd7.stop();
      timerEnd8.stop();
      timerEnd9.stop();
      timerEnd10.stop();
      timerEnd11.stop();
      timerEnd12.stop();
      delay=0;
      narrate.setText("Congratulations you are now Pokemon League Champion!");
      animation.setIcon(new ImageIcon("final.gif"));
      song2.loop();
      timerNext2.start();
      timerNext2.setRepeats(false);
    }
    else if (evt.getSource () == btnSkip2) {
      btnSkip2.setVisible(false);
      start.stop();
      song.stop();
      song.play();
      timerX.stop();
      timer.stop();
      timer0.stop();
      timer1.stop();
      timer2.stop();
      timer3.stop();
      timer4.stop();
      timer5.stop();
      narrate.setText("");
      btnSeismicToss.setVisible(true);
      btnFireBlast.setVisible(true);
      btnFireSpin.setVisible(true);
      btnMegaPunch.setVisible(true);
      animation.setIcon(new ImageIcon("4.png"));
    }
  }
  
  public static void main(String[] args)throws IOException { 
    
    new BattleScene();
  }
  
  /* ADD YOUR CODE HERE */
  
}
