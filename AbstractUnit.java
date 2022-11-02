import java.util.*;
import java.text.*;
import java.io.*;

public abstract class AbstractUnit extends GameObject {

    AbstractUnit next;
    
    
    public AbstractUnit getNext()
    {
      return next;
    }
    
    public void setNext(AbstractUnit next)
    {
      this.next = next;
    }
    
    //Abstract methods for the Health and Bubble
    /*public abstract void setLocation();
    public abstract void setSpeed();
    public abstract void setRadius();*/
    
    //needs a abstract "command" method
    //should have x and y positions?
    //pretty sure that this will feed into the bubble class

}
