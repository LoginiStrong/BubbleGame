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
   
   public UnitFactory(int radius, int posX, int posY)
   {
      ConcreteUnit CU = new ConcreteUnit(radius, posX, posY);
      last = CU;
      HealthNodeFactory HF = new HealthNodeFactory(150, 180, 100, 30, last);
      last = HF.getHDecor();
      BubbleFactory BF = new BubbleFactory(0, -10, 1, 100, .5, 10, .1, 150, 2.5, last);
      
      
      last = BF.getBDecor();
      
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