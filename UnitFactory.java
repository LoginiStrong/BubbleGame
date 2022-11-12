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
   
   public UnitFactory(){
   
   }
   
   public UnitFactory(int radius)
   {
      ConcreteUnit CU = new ConcreteUnit(radius);
      int rad = CU.getRad();
      last = CU;
      HealthNodeFactory HF = new HealthNodeFactory(0, 5, 10, 5, last);
      last = HF.getHDecor();
      HealthNodeFactory HF1 = new HealthNodeFactory(0, -5, 10, 8, last);
      last = HF1.getHDecor();
      BubbleFactory BF = new BubbleFactory(0, 10, 1, 5, 3, 2, 2, 100, 5 , last);
      last = BF.getBDecor();
      BubbleFactory BF1 = new BubbleFactory( 0, -10, 1, 5, .5, 10, .1, 150, 2.5, last);
      last = BF1.getBDecor();
      BF1.getBDecor().setPos(0, 0, rad);
      
   }
   
   public AbstractUnit getLast()
   {
      return last;
   }
   
   public void setLast(AbstractUnit decor)
   {
      last = decor;
      System.out.println("Called");
   }
   
   //public abstract AbstractUnit create(AbstractUnit next);
}