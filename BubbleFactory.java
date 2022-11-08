import java.util.*;
import java.text.*;
import java.io.*;

public class BubbleFactory extends UnitFactory {
   
   int num1 = 0;
   int num2 = 0;
   int num3 = 0;
   
   //Constructor
   public BubbleFactory(/*int numOne, int numTwo, int numThree*/)
   {
      /*num1 = numOne;
      num2 = numTwo;
      num3 = numThree;*/
   }
   
   //Abstract method from UnitFactory
   public AbstractUnit create(AbstractUnit next)
   {
      BubbleDecorator bD = new BubbleDecorator(num1,num2,num3,next);   //Calls on the decorator
      
      return bD;
   }
    
    /*public Vector2 getPosition()
   {
      return returnVector;
   }

    public Vector2 getPosition(){

        return null;

    }

    public BubbleFactory(){

    }*/

    public Bubble createBubble(float x, float y, int destinationX, int destinationY){

        Bubble b = new Bubble(x, y, destinationX, destinationY);

        return b;

    }


}