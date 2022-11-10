import java.util.*;
import java.text.*;
import java.io.*;

public class BubbleFactory extends UnitFactory {
   
   /*int bubbleX;
   int bubbleY;
   int bubbleRad;
   int type;
   double damage;
   int speed;
   double refire;
   int range; 
   int bubbleSize;
   AbstractUnit next;*/
   AbstractUnit bDecor;
   
   //Constructor
   public BubbleFactory(int bubbleX, int bubbleY, int type, int bubbleRad, double damage, int speed, double refire, int range, double bubbleSize, AbstractUnit next)
   {
      /*num1 = numOne;
      num2 = numTwo;
      num3 = numThree;*/
      /*this.bubbleX = bubbleX;
      this.bubbleY = bubbleY;
      this.type = type;
      this.bubbleRad = bubbleRad;
      this.damage = damage;
      this.speed = speed;
      this.refire = refire;
      this.range = range;
      this.next = next;
      this.bubbleSize = bubbleSize;*/
      //System.out.println("Test");
      BubbleDecorator bD = new BubbleDecorator(bubbleX, bubbleY, type, bubbleRad, damage, speed, refire, range, bubbleSize, next);
      bDecor = bD;
      //last = bD;
      //setLast(bD);
      
   }
   
   public AbstractUnit getBDecor()
   {
      return bDecor;
   }
   
   //Abstract method from UnitFactory
   /*public AbstractUnit create(AbstractUnit next)
   {
      BubbleDecorator bD = new BubbleDecorator(num1,num2,num3,next);   //Calls on the decorator
      
      return bD;
   }*/
    
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