import javafx.geometry.*;

public class commandZ implements command{

    Player p;
    int mouseX;
    int mouseY;

    public boolean intersection(int x1, int y1, float x2, float y2, float w, float h){

        boolean ret = true;
  
        Rectangle2D r1 = new Rectangle2D(x1,y1,1,1);
        Rectangle2D r2 = new Rectangle2D(x2, y2, w, h);
  
        if(!r1.intersects(r2)){
           ret = false;
        }
  
        return ret;
     }

    public commandZ(Player p, int mouseX, int mouseY){

        this.p = p;
        this.mouseX = mouseX;
        this.mouseY = mouseY;

    }

    public void execute(Player p1, int mouseX, int mouseY){
        System.out.println("this should print the z command");

       /* if(intersection(x,y,theGame.p1.x+xt, theGame.p1.y+yt, 
            theGame.p1.radius, theGame.p1.radius)){

               theGame.p1.toggleOn();

            }
            else{
               theGame.p1.toggleOff();

            }
        */
    }

}