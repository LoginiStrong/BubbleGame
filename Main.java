

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
import java.io.*;
import java.util.*;
import java.text.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class Main extends Application
{
   VBox root = new VBox();
   Stage theStage;
   
   Button start = new Button("Start");
    
   Scene menu;
   Scene game;
   
   String commandState = "";

   Game theGame = new Game();

   static double deltaTime; 
   
   //get the amount of time passed between the last frame and this frame.
   public static double getDeltaTime()
   {
      return deltaTime;
   }

   public void setMenu(Stage stage)
   {
      stage.setScene(menu);
      stage.setTitle("Bubble Poppers!?!?!???!");
      stage.show(); 
   }
   public void start(Stage stage)
   {
      //creating the menu & scences. Don't worry about this code. You shouldn't have to change anything in this method... I mean unless you want too
      Label title = new Label("Bubble Poppers 3000");
      title.setFont(Font.font ("Verdana", 34));
      
      Label subtitle = new Label("Here *they* comes!");
      subtitle.setFont(Font.font ("Verdana", 18));
   
      Label spacer1 = new Label(" ");
      spacer1.setFont(Font.font ("Verdana", 52));

      start.setFont(Font.font ("Verdana", 14));      
      start.setPrefSize(150,30);

      root.getChildren().add(title);
      root.getChildren().add(subtitle);
      root.getChildren().add(spacer1);
      root.getChildren().add(start);
      root.setAlignment(Pos.TOP_CENTER);


      start.setOnAction(new ButtonListener());  
      theStage = stage;
      menu = new Scene(root,800,600);
      setMenu(stage);
      
      VBox empty = new VBox();            
      empty.getChildren().add(theGame);
      game = new Scene(empty, 800, 600);

      theGame.setOnKeyPressed(new KeyListenerDown());
      theGame.setOnMousePressed(new MousePressedListener());
   }
   
   public static void main(String [] args)
   {
      launch(args);
   }
   
   //handler for the start button
   public class ButtonListener implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent e)      
      {
         if(e.getSource() == start)
         {
            theGame.load("map1.txt");
            theAnimator.start();
            theStage.setScene(game);
            theGame.requestFocus();
         }
      }
   }
   
   
   AnimationHandler theAnimator = new AnimationHandler();
   
   public class AnimationHandler extends AnimationTimer
   {
      long lastTime=-1;
      
      //runs whatever each frame. Keeps track of the "deltatime" or the time between frames.
      public void handle(long currentTimeInNanoSeconds) 
      {
         
         if(lastTime != -1 )
         {
            long t = (currentTimeInNanoSeconds-lastTime)/1000l;
            deltaTime = t*1.0/1000000;

            theGame.run();
            theGame.draw();
         }
         lastTime = currentTimeInNanoSeconds;
      }
   }

   boolean paused=false;

   //listeners to keep track of whether a key is up or down
   public class KeyListenerDown implements EventHandler<KeyEvent>  
   {
      public void handle(KeyEvent event) 
      {
          if (event.getCode() == KeyCode.Z) 
          {


          }
          if(event.getCode() == KeyCode.X)
          {
            
          }
          if(event.getCode() == KeyCode.C)
          {
           
           
          }
      }
   }
   
   int active = 0;
   
   //what should happen when the mouse is clicked
   public class MousePressedListener implements EventHandler<MouseEvent>  
   {
      public void handle(MouseEvent me) 
      {
         int x = (int) me.getX();
         int y = (int) me.getY();
         
         //maybe do something here on a click depending on what command is active?

         
      }   
   }
}