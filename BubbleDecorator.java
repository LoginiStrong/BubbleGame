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

   //Variables for the bubble attributes
   int bubbleX;
   int bubbleY;
   int bubbleRad;
   int type;
   double damage;
   int speed;
   double refire;
   int range; 
   double bubbleSize;
   
   //Constructor to get the bubble attributes
   public BubbleDecorator(int bubbleX, int bubbleY, int type, int bubbleRad, double damage, int speed, double refire, int range, double bubbleSize, AbstractUnit next)
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
   
   //Method to run the bubble
   public void run()
   {
   }
   
   //Gets the position of where the bubble is going to go
   public Vector2 getPosition()
   {
      return returnVector;
   }
   
   //Draws the bubble to the the board
   public void draw(GraphicsContext gc)
   {
      //Runs the bubble
      run();
      
      //Draws the bubble
      next.draw(gc);
      gc.setFill(Color.CYAN);
      gc.fillOval(bubbleX, bubbleY, bubbleRad, bubbleRad);
   }
   
   //Returns the type
   public int getType()
   {
      return type;
   }
   
   //Returns bubble size
   public double getBubbleSize()
   {
      return bubbleSize;
   }
   
   //Returns bubble speed
   public int getSpeed()
   {
      return speed;
   }
   
   //Returns bubble range
   public int getRange()
   {
      return range;
   }
   
   //Returns bubble refire
   public double getFireRate()
   {
      return refire;
   }
   
   //Returns damage
   public double getDamage()
   {
      return damage; 
   } 
}