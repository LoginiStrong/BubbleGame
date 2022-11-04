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

   int radius; 
   int posX;
   int posY;

   public ConcreteUnit(int radius, int posX, int posY)
   {
      this.radius = radius;
      this.posX = posX;
      this.posY = posY;
   }

   public void draw(GraphicsContext gc)
   {
      gc.setFill(Color.RED);
      gc.fillOval(posX, posY, radius, radius);
   }
   
   
   
   public Vector2 getPosition()
   {
      return returnVector;
   }




}