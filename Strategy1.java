import java.util.*;

public class Strategy1 extends Strategy{
 
    public void execute(Bubble b){

        //These bubbles have 2 lifetime and move straight at the opposing bubble. 
        //When the original bubble passes the lifetime of 1, 
        //create 5 bubbles going the same direction at 10% of the 
        //original speed + a random (-.05,.05) in both directions; 
        //the slow bubbles have a lifetime of 5.


        b.lifetime -=0.025;

        if(b.lifetime > .98 && b.lifetime<1.01){

            Random r = new Random();

            float shift;

            shift = (r.nextInt(10)-5);
            Bubble b2 = new Bubble(b.x, b.y, shift + b.velX/10,shift + b.velY/10, true);

            shift = (r.nextInt(10)-5);
            Bubble b3 = new Bubble(b.x, b.y, shift + b.velX/10,shift + b.velY/10, true);
           
            shift = (r.nextInt(10)-5);
            Bubble b4 = new Bubble(b.x, b.y, shift + b.velX/10,shift + b.velY/10, true);

            shift = (r.nextInt(10)-5);
            Bubble b5 = new Bubble(b.x, b.y, shift + b.velX/10,shift + b.velY/10, true);
            
            shift = (r.nextInt(10)-5);
            Bubble b6 = new Bubble(b.x, b.y, shift + b.velX/10,shift + b.velY/10, true);

            b2.setStrategy(0);
            b3.setStrategy(0);
            b4.setStrategy(0);
            b5.setStrategy(0);
            b6.setStrategy(0);

            b2.setNext(b3);
            b3.setPrev(b2);

            b3.setNext(b4);
            b4.setPrev(b3);

            b4.setNext(b5);
            b5.setPrev(b4);

            b5.setNext(b6);
            b6.setPrev(b5);

            b2.setPrev(b);

            if(b.next==null){
                b.next = b2;
            }
            else{
                b.next.setPrev(b6);
                b6.setNext(b.next);
                b.next = b2;
            }

        }

        if(b.lifetime>0){
            b.x+=b.velX;
            b.y+=b.velY;
        }


    }

}
