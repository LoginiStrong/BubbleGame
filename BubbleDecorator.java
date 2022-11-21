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
   int x;
   int y;
   int rad;
   int bubbleX;
   int bubbleY;
   int bubbleRad;
   int type;
   double damage;
   int speed;
   double refire;
   int range; 
   double bubbleSize;
   String playerSide = "";
   
   //Constructor to get the bubble attributes
   public BubbleDecorator(int rad, int bubbleX, int bubbleY, int type, int bubbleRad, double damage, int speed, double refire, int range, double bubbleSize, AbstractUnit next)
   {
      this.rad = rad;
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
   
   public Bubble getBubble(float x, float y, int destinationX, int destinationY){

      Bubble b = new Bubble(x,y,destinationX, destinationY);
      b.setStrategy(type);
      b.damage = damage;
      b.speed = speed;
      b.playerSide = playerSide;

      return b;
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
      
      next.setPos(x, y);
      
      //Draws the bubble
      next.draw(gc);
      gc.setFill(Color.CYAN);
      gc.fillOval(bubbleX + x + rad - 5, bubbleY + y + rad - 5, bubbleRad, bubbleRad);
   }
   
   
   public void setPos(int x, int y)
   {
      this.x = x;
      this.y = y;
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
   
   public AbstractUnit getNext()
   {
      return next;
   }
   
}