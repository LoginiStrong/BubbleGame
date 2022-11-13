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
   String att;
   int rad;
   String name;
   //protected AbstractUnit decor; 
   
   public UnitFactory(){
   
   }
   
   public UnitFactory(String name, int radius, double speed, Scanner scan)
   {
      this.name = name;
      rad = radius;
      ConcreteUnit CU = new ConcreteUnit(radius, speed);
      last = CU;
      concrete = CU;
      int attributeNum = scan.nextInt();
      System.out.println(attributeNum);
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
         //System.out.println(att);
            //HealthNodeFactory HF1 = new HealthNodeFactory(0, -5, 10, 8, last);
            //last = HF1.getDecor();
            
            //BubbleFactory BF1 = new BubbleFactory( 0, -10, 1, 5, .5, 10, .1, 150, 2.5, last);
            //last = BF1.getDecor();  
      }
      
      
         //last.setPos(0, 0, radius);           
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