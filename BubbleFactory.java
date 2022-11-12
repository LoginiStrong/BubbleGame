import java.util.*;
import java.text.*;
import java.io.*;

public class BubbleFactory extends UnitFactory {
   
   AbstractUnit bDecor;
   
   //Constructor to take in the attributes of a bubble
   public BubbleFactory(int bubbleX, int bubbleY, int type, int bubbleRad, double damage, int speed, double refire, int range, double bubbleSize, AbstractUnit next)
   {
      //Calls on the bubble decorator to create the bubble
      BubbleDecorator bD = new BubbleDecorator(bubbleX, bubbleY, type, bubbleRad, damage, speed, refire, range, bubbleSize, next);
      
      //Sets the AbstractUnit to the created Bubble Decorator
      bDecor = bD;
      
      //last = bD;
      //setLast(bD);
   }
   
   //Gets the bubble decorator as an AbstractUnit
   public AbstractUnit getDecor()
   {
      return bDecor;
   }

   //Part of command function
   public Bubble createBubble(float x, float y, int destinationX, int destinationY){
   
      Bubble b = new Bubble(x, y, destinationX, destinationY);

      return b;

    }
}