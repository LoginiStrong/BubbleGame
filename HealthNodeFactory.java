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
   
   public HealthNodeFactory()
   {
      
   }
   
   public UnitFactory create(UnitFactory next)
   {
      HealthDecorator hD = new HealthDecorator(1,1,1,1,next);
      
      return hD;
   }
   
   /*public class DFactory extends AbstractFactory
{
   String DPextra;

   public DFactory(String ex)
   {
      DPextra = ex;
   }

   public AbstractO create(AbstractO next)
   {
      Decoration d = new Decoration(DPextra,next);
      
      return d;
   }
}*/
}