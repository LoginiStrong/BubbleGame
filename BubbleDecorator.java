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
   float damage;
   int speed;
   double refire;
   int range; 
   int bubbleSize;
   
   
   
   public BubbleDecorator(int bubbleX, int bubbleY, int type, int bubbleRad, double refire, AbstractUnit next)
   {
      this.bubbleX = bubbleX;
      this.bubbleY = bubbleY;
      this.type = type;
      this.bubbleRad = bubbleRad;
      this.refire = refire;
      this.next = next;
      
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
   
   public double getFireRate()
   {
      return refire;
   }
   
   


}