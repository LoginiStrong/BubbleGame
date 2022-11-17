import java.util.*;
import java.text.*;
import java.io.*;
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
import javafx.scene.shape.Circle;

public class UnitFactory{
   //Abstract method
   private AbstractUnit last;
   private AbstractUnit concrete;
   int attributes;
   int rad;
   String strRad;
   double speed;
   String name;
   String att;
   //protected AbstractUnit decor;
   //ArrayList<String> decorArray = new ArrayList<String>();
   ArrayList<ArrayList<String>> attLists = new ArrayList<ArrayList<String>>();
   //ArrayList<String> bubbleArray = new ArrayList<String>();
   
    
   
   public UnitFactory(){
   
   }
   
   public UnitFactory(String name, int radius, double speed, Scanner scan)
   {
      this.name = name;
      this.speed = speed;
      rad = radius;
      strRad = Integer.toString(rad);
      /*ConcreteUnit CU = new ConcreteUnit(radius, speed);
      last = CU;
      concrete = CU;*/
      this.attributes = scan.nextInt();
      //String stringBuilder = "";
      
      
      for (int i = 0; i < attributes; i++)
      {
         att = scan.next();
         if (att.equals("health"))
         {
            attLists.add(new ArrayList<String>());
            attLists.get(i).add(att);
            attLists.get(i).add(scan.next());
            attLists.get(i).add(scan.next());
            attLists.get(i).add(scan.next());
            attLists.get(i).add(scan.next());
            //stringBuilder += att + " " + Integer.toString(rad) + " " + scan.next() + " " + scan.next() + " " + scan.next()  + " " + scan.next();
            //decorArray.add(stringBuilder);
            //stringBuilder = "";
         }
         else if (att.equals("bubble"))
         {
            attLists.add(new ArrayList<String>());
            attLists.get(i).add(att);
            attLists.get(i).add(scan.next());
            attLists.get(i).add(scan.next());
            attLists.get(i).add(scan.next());
            attLists.get(i).add(scan.next());
            attLists.get(i).add(scan.next());
            attLists.get(i).add(scan.next());
            attLists.get(i).add(scan.next());
            attLists.get(i).add(scan.next());
            attLists.get(i).add(scan.next());
            
         
            //stringBuilder += att + " " + Integer.toString(rad) + " " + scan.next() + " " + scan.next() + " " + scan.next()  + " " + scan.next() + " " + scan.next() + " " + scan.next() + " " + scan.next()  + " " + scan.next()+ " " + scan.next();
            //decorArray.add(stringBuilder);
            //stringBuilder = "";
         }
         
      }
      
      
      
      
      
      
      /*System.out.println(attributeNum);
      for (int i = 0; i < attributeNum; i++)
      {
      att = scan.next();
         if (att.equals("health"))
         {
            HealthNodeFactory HF = new HealthNodeFactory(radius, scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), last);
            
            last = HF.getDecor();
         }
         else if (att.equals("bubble"))
         {
            BubbleFactory BF = new BubbleFactory(radius, scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextDouble(), scan.nextInt(), scan.nextDouble(), scan.nextInt(), scan.nextDouble(), last);
            last = BF.getDecor();
         }   
      }*/
                 
   }
   
   public AbstractUnit createUnit()
   {
      ConcreteUnit CU = new ConcreteUnit(rad, speed);
      last = CU;
      concrete = CU;
      for (int i = 0; i < attLists.size(); i++)
      {
         ArrayList<String> tempArray = attLists.get(i);
         if (attLists.get(i).get(0).equals("health"))
         {
            HealthDecorator hD = new HealthDecorator(rad, Integer.parseInt(tempArray.get(1)), Integer.parseInt(tempArray.get(2)), Integer.parseInt(tempArray.get(3)), Integer.parseInt(tempArray.get(4)), last);
            last = hD;
         }
         else if (attLists.get(i).get(0).equals("bubble"))
         {
            BubbleDecorator bD = new BubbleDecorator(rad, Integer.parseInt(tempArray.get(1)), Integer.parseInt(tempArray.get(2)), Integer.parseInt(tempArray.get(3)), Integer.parseInt(tempArray.get(4)), Double.parseDouble(tempArray.get(5)), Integer.parseInt(tempArray.get(6)), Double.parseDouble(tempArray.get(7)), Integer.parseInt(tempArray.get(8)), Double.parseDouble(tempArray.get(9)), last);
            last = bD;
         }
         
      }
      return last;
   
   }
   
   
   public AbstractUnit getLast()
   {
      return last;
   }
   
   public int getRad()
   {
      return rad;
   }
   
   public AbstractUnit getConcrete()
   {
      return concrete;
   }
   
   public void setLast(AbstractUnit decor)
   {
      last = decor;
      System.out.println("Called");
   }
   
   public String getName()
   {
      return name;
   }
   
   //public abstract AbstractUnit create(AbstractUnit next);
}