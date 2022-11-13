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

public class HealthNodeFactory extends UnitFactory {
   
   AbstractUnit hDecor;
   
   //Constructor
   public HealthNodeFactory(int rad, int healthX, int healthY, int HP, int healthRad, AbstractUnit next)
   {
      HealthDecorator hD = new HealthDecorator(rad, healthX, healthY, HP, healthRad, next);
      hDecor = hD;
   }
   
   public AbstractUnit getDecor()
   {
      return hDecor;
   }
}