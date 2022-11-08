
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
   Map theMap = new Map();
   ConcreteUnit CU = new ConcreteUnit(200, 70, 150);
   HealthDecorator hD = new HealthDecorator(80, 180, 100, 30, CU);
   HealthDecorator hD2 = new HealthDecorator(150, 180, 100, 30, hD);
   BubbleDecorator bD = new BubbleDecorator(155, 185, 15, hD2);
   Player p1 = new Player(100,100);

   ArrayList<Bubble> bubbles = new ArrayList<Bubble>();

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
   
   //New draw method given to us
   /*public void draw()
   {
      GraphicsContext gc = getGraphicsContext2D();
      gc.setFill(Color.BLACK);
      gc.fillRect(0,0,800,600);
      
      //moves to center 
      gc.translate( (800-theMap.getXSize())/2, (600 - theMap.getYSize())/2);
      theMap.draw(gc);
      for(int i=0;i<units.size();i++)
      {
         units.get(i).draw(gc);
      }
      
      BubbleList.BubbleListIterator BLI = BubbleList.getInstance().getIterator();
      while(BLI.hasNext())
      {
         Bubble b = BLI.next();
         b.draw(gc);
      }
      
      //un "centers". Why pop matrix no work :(  ?????  Meh
      gc.translate( (800-theMap.getXSize())/-2, (600 - theMap.getYSize())/-2);
   }*/
   
   public void draw()
   {
      GraphicsContext gc = getGraphicsContext2D();
      gc.setFill(Color.BLACK);
      gc.fillRect(0,0,800,600);
      
      //moves to center 
      gc.translate( (800-theMap.getXSize())/2, (600 - theMap.getYSize())/2);
      theMap.draw(gc);

      //draws the player/unit
      p1.draw(gc);
      //hD.run();
      bD.draw(gc);
      
      //draws the bubbles
      for(int i=0; i<bubbles.size(); i++){
         bubbles.get(i).draw(gc);
      }

      //un "centers". Why pop matrix no work :(  ?????  Meh
      gc.translate( (800-theMap.getXSize())/-2, (600 - theMap.getYSize())/-2);
   }
}