public class Strategy1 extends Strategy{
 
    public void execute(Bubble b){

        //These bubbles have 2 lifetime and move straight at the opposing bubble. 
        //When the original bubble passes the lifetime of 1, 
        //create 5 bubbles going the same direction at 10% of the 
        //original speed + a random (-.05,.05) in both directions; 
        //the slow bubbles have a lifetime of 5.

        b.lifetime -=0.1;

        if(b.lifetime == 1){

        }


    }

}
