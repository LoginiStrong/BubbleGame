public class Strategy0 extends Strategy{
    
    public void execute(Bubble b){

        b.lifetime -=0.025;

        if(b.lifetime>0){
            b.x+=b.velX;
            b.y+=b.velY;
        }
        

    }


}
