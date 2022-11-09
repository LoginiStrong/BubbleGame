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


public class BubbleDecorator extends DecoratorParent {

   int bubbleX;
   int bubbleY;
   int bubbleRad;
   int type;
   double damage;
   int speed;
   double refire;
   int range; 
   int bubbleSize;
   
   
   
   public BubbleDecorator(int bubbleX, int bubbleY, int type, int bubbleRad, double damage, int speed, double refire, int range, int bubbleSize, AbstractUnit next)
   {
      this.bubbleX = bubbleX;
      this.bubbleY = bubbleY;
      this.type = type;
      this.bubbleRad = bubbleRad;
      this.damage = damage;
      this.speed = speed;
      this.refire = refire;
      this.range = range;
      this.next = next;
      this.bubbleSize = bubbleSize;
      
   }
   
   
   public void run()
   {
   }
   
   public Vector2 getPosition()
   {
      return returnVector;
   }
   
   public void draw(GraphicsContext gc)
   {
      run();
      next.draw(gc);
      gc.setFill(Color.CYAN);
      gc.fillOval(bubbleX, bubbleY, bubbleRad, bubbleRad);
     
      
   }
   
   
   public int getType()
   {
      return type;
   }
   
   public int getBubbleSize()
   {
      return bubbleSize;
   }
   
   public int getSpeed()
   {
      return speed;
   }
   
   public int getRange()
   {
      return range;
   }
   
   public double getFireRate()
   {
      return refire;
   }
   
   public double getDamage()
   {
      return damage; 
   }
  
  
}