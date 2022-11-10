public class Strategy0 extends Strategy{
    
    public void execute(Bubble b){

        //reduces the lifespan of the bubble
        b.lifetime -=0.025;

        //if it still has life, keep moving
        if(b.lifetime>0){
            b.x+=b.velX;
            b.y+=b.velY;
        }
        

    }


}
