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

   int healthX;
   int healthY;
   int HP;
   int healthRad;
   boolean dead = false;
   
   public HealthDecorator(int healthX, int healthY, int HP, int healthRad, AbstractUnit next)
   {
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
      next.draw(gc);
      if (dead == false)
      {
         gc.setFill(Color.GREEN);
      }
      else
      {
         gc.setFill(Color.BLACK);
      }
      gc.fillOval(healthX, healthY, healthRad, healthRad); 
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