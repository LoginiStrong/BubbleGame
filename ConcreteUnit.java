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

public class ConcreteUnit extends AbstractUnit {

   //Variables for the unit radius and positions at x and y
   int radius; 
   int posX;
   int posY;
   double speed;
   String side;
   
   //Constructor to take in radius and x/y position
   public ConcreteUnit(int radius, double speed)
   {
      this.radius = radius;
   }
   
   //Draws the unit
   public void draw(GraphicsContext gc)
   {
      if (side.equals("0"))
      {
         gc.setFill(Color.RED);
      }
      else 
      {
         gc.setFill(Color.BLUE);
      }
      
      gc.fillOval(posX, posY, radius*2, radius*2);
   }
   
   public void setPos(int x, int y)
   {
      posX = x;
      posY = y;
   }
   
   /*public int getRad()
   {
      return radius;
   }*/
   
   public double getSpeed()
   {
      return speed;
   }
   
   public void setSide(String team)
   {
      side = team;
   }
   
   public String getSide()
   {
      return side;
   }
   
   //Gets position of the where the unit is going to
   public Vector2 getPosition()
   {
      return returnVector;
   }
}