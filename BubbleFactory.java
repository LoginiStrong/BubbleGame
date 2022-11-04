import java.util.*;
import java.text.*;
import java.io.*;

public class BubbleFactory extends AbstractUnit {
    /*public void setLocation();
    public void setSpeed();
    public void setRadius();*/
    
    public Vector2 getPosition()
   {
      return returnVector;
   }

    public BubbleFactory(){

    }

    public Bubble createBubble(float x, float y, int destinationX, int destinationY){

        Bubble b = new Bubble(x, y, destinationX, destinationY);

        return b;

    }


}