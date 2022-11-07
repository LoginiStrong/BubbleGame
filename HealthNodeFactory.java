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
   
   int num1 = 0;
   int num2 = 0;
   int num3 = 0;
   int num4 = 0;
   
   //Constructor
   public HealthNodeFactory(int numOne, int numTwo, int numThree, int numFour)
   {
      num1 = numOne;
      num2 = numTwo;
      num3 = numThree;
      num4 = numFour;
   }
   
   //Abstract method from UnitFactroy to create the health part of the unit
   public AbstractUnit create(AbstractUnit next)
   {
      HealthDecorator hD = new HealthDecorator(num1,num2,num3,num4,next);
      
      return hD;   //Since HealthDecorator extends from AbstractUnit, we can return hD
   }
}