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


public class HealthDecorator extends DecoratorParent {


   int x;
   int y;
   int rad;
   int healthX;
   int healthY;
   int HP;
   int healthRad;
   boolean dead = false;
   
   public HealthDecorator(int rad, int healthX, int healthY, int HP, int healthRad, AbstractUnit next)
   {
      this.x = x;
      this.y = y;
      this.rad = rad;
      this.healthX = healthX;
      this.healthY = healthY;
      this.HP = HP;
      this.healthRad = healthRad;
      this.next = next;
      
   }
   
   
   public void run()
   {
      if (HP <= 0)
      {
         dead = true;
      }
   }
   
   public Vector2 getPosition()
   {
      return returnVector;
   }
   
   public void draw(GraphicsContext gc)
   {
      run();
      next.setPos(x, y);
      next.draw(gc);
      if (dead == false)
      {
         gc.setFill(Color.GREEN);
      }
      else
      {
         gc.setFill(Color.BLACK);
      }
      gc.fillOval(healthX + x + rad - 5, healthY + y + rad - 5, healthRad, healthRad); 
   }
   
   public void setPos(int x, int y)
   {
      this.x = x;
      this.y = y;
   }

   public int getHP()
   {
      return HP;
   }

   public void takeDamage(int damage)
   {
      HP -= damage;
   }
   
   public boolean getDead()
   {
      return dead;
   }

}