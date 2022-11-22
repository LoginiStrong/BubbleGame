
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.animation.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.geometry.*;
import javafx.application.Application;
import java.io.*;
import java.util.*;
import java.text.*;


public class Game extends Canvas
{

   Singleton BubbleSingle = Singleton.getInstance();
   bIterator bit = new bIterator(null);

   Map theMap = new Map();
   ArrayList<AbstractUnit> AU;
   //ConcreteUnit CU = new ConcreteUnit(200, 70, 150);
   //HealthDecorator hD = new HealthDecorator(80, 180, 100, 30, CU);
   //HealthDecorator hD2 = new HealthDecorator(150, 180, 100, 30, hD);
   //BubbleDecorator bD = new BubbleDecorator(155, 185, 1, 15, 0.5, hD2);
   Scanner dud = new Scanner("System.in");
   //UnitFactory UF = new UnitFactory(30, dud);
  // BubbleFactory BF = new BubbleFactory(0, -10, 1, 100, .5, 10, .1, 150, 2.5, UF.getLast());
   
   ArrayList<Player> players = new ArrayList<Player>();

   String com = "";

   //ArrayList<Bubble> bubbles = new ArrayList<Bubble>();

   int xTranslate = (800-theMap.getXSize())/2;
   int yTranslate = (600 - theMap.getYSize())/2;

   public Game()
   {
      setHeight(600);
      setWidth(800);

   }
   
   
   public void clear()
   {

   }
      
      
   //this method reads the level data. Stops before the unit data since you have to write that bit!
   public void load(String mapString)
   {
      clear(); 
     
      try
      {
         Scanner scan = new Scanner(new File(mapString));
         theMap = new Map(); //clear it all out first!!!!!
         theMap.readMap(scan); //pass scanner to map to read the map
         xTranslate = (800-theMap.getXSize())/2;
         yTranslate = (600 - theMap.getYSize())/2;
      
         for(int i=0; i<theMap.CU.size(); i++){
            ConcreteUnit c = theMap.getConcreteUnits().get(i);
            AbstractUnit au = theMap.getUnits().get(i);
            Player p = new Player(c,au);
            
            players.add(p);
         
         }
         
      }
      catch(Exception e)
      {
         System.out.println("File Read Error!");
         e.printStackTrace();
      }
   }
   
   
   //this method is called each frame. Hmm I wonder what should happen here? is it a shame I deleted all this code before giving it to you?
   public void run()
   {
   }
   

   public void addBubble(Bubble b){

      if(BubbleSingle.getHead() == null){
          BubbleSingle.setHead(b);
          
      }
      else{
          
          Bubble temp = BubbleSingle.getHead();

          while(temp.getNext()!= null){
              temp = temp.getNext();
            
          }
          
          temp.setNext(b);
          b.setPrev(temp);
        
      }

  }
   
   public void setCom(String s){
      com = s;
   }

   public void draw()
   {
      ArrayList<AbstractUnit> AU = theMap.getUnits();
      GraphicsContext gc = getGraphicsContext2D();
      gc.setFill(Color.BLACK);
      gc.fillRect(0,0,800,600);
      
      //moves to center 
      gc.translate( (800-theMap.getXSize())/2, (600 - theMap.getYSize())/2);
      theMap.draw(gc);

      //draws the player/unit
      for(int i=0; i<players.size(); i++){
         players.get(i).draw(gc);

      }
      //hD.run();
      //bD.draw(gc);
      //UF.getLast().draw(gc);
      
      //System.out.println((UF.getLast());
      
      for(int i=0; i<players.size(); i++){ //compares each player to each other player

         for(int j=0; j<players.size(); j++){

            for(int q=0; q<players.get(i).bubbleDecs.size(); q++){ //for each bubble decorator

               if(players.get(i).inRange(players.get(j), q) &&
                  !players.get(i).cu.side.equals(players.get(j).cu.side)){
                  
                
                  int x2 = (int)players.get(j).x;
                  
                  int y2 = (int)players.get(j).y;

                  if(players.get(i).refire(q)){
                     Bubble b = players.get(i).getBubble(x2, y2, q);
                     addBubble(b);
                  }
               }
            }
         }
      }


      bit = new bIterator(BubbleSingle.getHead());
      BubbleSingle.setHead(bit.remove());
      BubbleSingle.setHead(bit.collidingCheck(players));
      bit.draw(gc);
      BubbleSingle.bubbleLength();

      //un "centers". Why pop matrix no work :(  ?????  Meh
      gc.translate( (800-theMap.getXSize())/-2, (600 - theMap.getYSize())/-2);

      gc.setFill(Color.RED);
      
      String str = "You are on command " + com;
      gc.fillText(str, 40, 40);
      gc.fillText("Z: Selecting     C: Moving", 40,60);


   }
}