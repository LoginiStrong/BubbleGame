public class Strategy2 extends Strategy{
    
    public void execute(Bubble b){

        //Timed burst; original bubble flies at target. 
        //When the lifetime of 1 hits 0, 
        //create 8 bubbles equally spread out (should move in a circle, not a box) 
        //with the same stats (aka, damage) as the original. 
        //If it hits something, it does not spread out.

        b.lifetime -=0.025;

        if(b.lifetime < 0.01 && b.lifetime>-.02){
            
            float tempVelX = b.velX;
            float tempVelY = b.velY;
            float tempX = b.x;
            float tempY = b.y;

            Bubble b1 = new Bubble(tempX, tempY-10, tempVelX, tempVelY, true);
            Bubble b2 = new Bubble(tempX+10, tempY, tempVelX, tempVelY, true);
            Bubble b3 = new Bubble(tempX, tempY+10, tempVelX, tempVelY, true);
            Bubble b4 = new Bubble(tempX-10, tempY, tempVelX, tempVelY, true);

            Bubble b5 = new Bubble(tempX-7, tempY-7, tempVelX, tempVelY, true);
            Bubble b6 = new Bubble(tempX+7, tempY-7, tempVelX, tempVelY, true);
            Bubble b7 = new Bubble(tempX+7, tempY+7, tempVelX, tempVelY, true);
            Bubble b8 = new Bubble(tempX-7, tempY+7, tempVelX, tempVelY, true);

            b1.setNext(b2);
            b2.setPrev(b1);

            b2.setNext(b3);
            b3.setPrev(b2);

            b3.setNext(b4);
            b4.setPrev(b3);

            b4.setNext(b5);
            b5.setPrev(b4);

            b5.setNext(b6);
            b6.setPrev(b5);

            b6.setNext(b7);
            b7.setPrev(b6);

            b7.setNext(b8);
            b8.setPrev(b7);

            if(b.next==null){
                b.next = b2;
            }
            else{
                b.next.setPrev(b8);
                b8.setNext(b.next);
                b.next = b2;
            }


        }

        if(b.lifetime>0){
            b.x+=b.velX;
            b.y+=b.velY;
        }

    }

}
