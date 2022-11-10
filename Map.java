import java.util.*;
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

//I'm not expecting you to modify this file in any shape or form since it literally is just drawing the background. Hence, little comments.

public class Map
{
   ArrayList<Obstacle> obs = new ArrayList<Obstacle>();
   
   int xSize;
   int ySize;
   
   //this method takes the filescanner and reads ONLY the map parts. does not read the unit parts. Those up to you!
   public void readMap(Scanner fileScanner) throws Exception
   {
      xSize = fileScanner.nextInt();
      ySize = fileScanner.nextInt();
      
      int amountObTypes = fileScanner.nextInt();
      
      HashMap<String,Obstacle> theMap = new HashMap<String,Obstacle>();
      
      for(int i=0; i<amountObTypes; i++)
      {
         theMap.put(fileScanner.next(),new Obstacle(0,0,fileScanner.nextFloat()));
      }
      
      int numObjects = fileScanner.nextInt();
      for(int i = 0; i < numObjects;i++)
      {
         obs.add(theMap.get(fileScanner.next()).clone(fileScanner.nextInt(),fileScanner.nextInt()));
      } 
      
      System.out.println(fileScanner.next());
   }

   boolean first=true;
   
   //have to get the size for the Game class.
   public int getXSize(){return xSize;}
   public int getYSize(){return ySize;}
   
   final int SQAURESIZE = 50;
   
   //drawing the map and obstacles
   public void draw(GraphicsContext gc)
   {

   
      for(int i=0;i<xSize;i+=SQAURESIZE)
      {
         for(int j=0;j<ySize;j+=SQAURESIZE)
         {
            gc.setStroke(Color.GRAY);
            gc.strokeRect(i,j,SQAURESIZE,SQAURESIZE);
         }
      }
   
      for(int i=0;i<obs.size();i++)
      {
         obs.get(i).draw(gc);
      }
      

   }
}