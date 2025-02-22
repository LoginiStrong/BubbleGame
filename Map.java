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
   public ArrayList<UnitFactory> UFS = new ArrayList<UnitFactory>();
   ArrayList<AbstractUnit> AU = new ArrayList<AbstractUnit>();
   ArrayList<ConcreteUnit> CU = new ArrayList<ConcreteUnit>();
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
      //Scanner scan = fileScanner;
      //System.out.println(scan.next() + "\n");
      
      int numOfTypes = fileScanner.nextInt();
      
      for (int i = 0; i < numOfTypes; i++)
      {
         UnitFactory UF = new UnitFactory(fileScanner.next(), fileScanner.nextInt(), fileScanner.nextDouble(), fileScanner);
         System.out.println("Called");
         UFS.add(UF);
         
      }
      
      int numOfUnits = fileScanner.nextInt();
      //System.out.println(numOfUnits);
      //System.out.println(UFS.size());
      String name;
      for (int i = 0; i < numOfUnits; i++)
      {
         name = fileScanner.next();
         int x;
         int y;
         x = fileScanner.nextInt();
         y = fileScanner.nextInt();
         String side = fileScanner.next();
         
         
         for (int j = 0; j < UFS.size(); j++)
         {
            if (UFS.get(j).getName().equals(name))
            {
               AbstractUnit temp = UFS.get(j).createUnit();
               System.out.println("Ran");
              // AbstractUnit temp = UFS.get(j).getLast();
               AU.add(temp);
               CU.add(UFS.get(j).getConcrete());
               System.out.println(x + "      " + y);
               //UFS.get(j).getLast().setPos(x, y);
               
               //fileScanner.next();
            }
         }
         AU.get(i).setPos(x, y);
         CU.get(i).setSide(side);
         CU.get(i).setPos(x, y);
         //CU.get(i).isSelected(true);
         
      
      }
      //CU.get(0).isSelected(true);
      ///CU.get(2).isSelected(true);
      //CU.get(i).isSelected(true);
      
      
   }

   boolean first=true;
   
   //have to get the size for the Game class.
   public int getXSize(){return xSize;}
   public int getYSize(){return ySize;}
   
   final int SQAURESIZE = 50;
   
   public ArrayList<UnitFactory> getList()
   {
      return UFS;
   }
   
   public ArrayList<AbstractUnit> getUnits()
   {
      return AU;
   }
   
    public ArrayList<ConcreteUnit> getConcreteUnits()
   {
      return CU;
   }
   
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