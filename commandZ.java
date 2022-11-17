import javafx.geometry.*;

public class commandZ implements command{

    Player p;

    public boolean intersection(int x1, int y1, float x2, float y2, float w, float h){

        boolean ret = true;
  
        Rectangle2D r1 = new Rectangle2D(x1,y1,1,1);
        Rectangle2D r2 = new Rectangle2D(x2, y2, w, h);
  
        if(!r1.intersects(r2)){
           ret = false;
        }
  
        return ret;
     }

    public commandZ(){

    }

    public void execute(Player p1, int mouseX, int mouseY){
        //System.out.println("this should print the z command");

        if(intersection(mouseX,mouseY,p1.x, p1.y, p1.radius, p1.radius)){
            p1.toggleOn();
        }
        else{
            p1.toggleOff();
        }

    }

}