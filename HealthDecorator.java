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
   int maxHP;
   double HP;
   int healthRad;
   boolean dead = false;
   int green = 255;
   //Color hPColor = new Color(0, green, 0);
   
   public HealthDecorator(int rad, int healthX, int healthY, int HP, int healthRad, AbstractUnit next)
   {
      this.x = x;
      this.y = y;
      this.rad = rad;
      this.healthX = healthX;
      this.healthY = healthY;
      this.HP = HP;
      maxHP = HP;
      this.healthRad = healthRad;
      this.next = next;
      
   }
   
   
   public void run()
   {
      green = (int)(255*(HP/maxHP));
   
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
         gc.setFill(Color.rgb(0,green,0));
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

   public double getHP()
   {
      return HP;
   }

   public void takeDamage(double damage)
   {
      HP -= damage;
   }
   
   public boolean getDead()
   {
      return dead;
   }
   
   public AbstractUnit getNext()
   {
      return next;
   }

}