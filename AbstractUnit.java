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

public abstract class AbstractUnit extends GameObject {
    
    protected AbstractUnit next;
   
    public abstract AbstractUnit getNext();
    
    public abstract void draw(GraphicsContext gc);
    public abstract void setPos(int x, int y);
    
    
    /*public AbstractUnit next;
    public AbstractUnit current;
    
    public AbstractUnit getNext()
    {
      return next;
      
    }
    
    public void setNext(AbstractUnit next)
    {
      this.next = next;
    }*/
    
    //Abstract methods for the Health and Bubble
    /*public abstract void setLocation();
    public abstract void setSpeed();
    public abstract void setRadius();*/
    
    //needs a abstract "command" method
    //should have x and y positions?
    //pretty sure that this will feed into the bubble class

}
