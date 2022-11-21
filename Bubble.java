import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.geometry.*;

public class Bubble {

    //position and velocity
    float x;
    float y;
    float velX;
    float velY;

    //this variable kees track of how long the bubble is in play
    double lifetime;

    //this will be the strategy that is called
    Strategy st;

    //bubbles that this bubble links to
    Bubble next = null;
    Bubble previous = null;

    double damage = 0;

    int speed = 0;

    String playerSide = "";

    //this constructor is used to set the velocity of the bubble
    public Bubble(float x, float y, float velX, float velY, boolean placeholder){
        this.x = x;
        this.y = y;
        this.velX = velX;
        this.velY = velY;

        st = new Strategy0();

        lifetime = 5;
    }

    public boolean collision(Player p){

        Rectangle2D r = new Rectangle2D(x,y,1,1);
        Rectangle2D r2 = new Rectangle2D(p.x,p.y,p.radius,p.radius);

        return(r.intersects(r2));

    }


    public double getDamage(){
        return damage;
    }

    public void removeSelf(){

        if(previous == null){
            return;
        }

        if(next == null){
            previous.setNext(null);
        }
        else{
            previous.setNext(next);
        }

    }

    public boolean hasNext(){
        if(next!= null){
            return true;
        }
        return false;
    }

    //this bubble sets the strategy of the bubble
    public void setStrategy(int num){

        if(num == 0){
            st = new Strategy0();
            lifetime = 5;
        }
        if(num == 1){
            st = new Strategy1();
            lifetime = 2;
        }
        if(num == 2){
            st = new Strategy2();
            lifetime = 1;
        }

    }

    //constructor
    public Bubble(float x, float y, float destinationX, float destinationY){

        this.x = x;
        this.y = y;

        float diffx = 0;
        float diffy = 0;

        diffx = destinationX - this.x;
        diffy = destinationY - this.y;
                
        double mag = Math.sqrt(diffx*diffx + diffy*diffy);
                
        diffx /= mag;
        diffy /= mag;

        velX = diffx;
        velY = diffy;

        lifetime = 5;

        st = new Strategy1();

    }

    public void setLifetime(double x){
        lifetime = x;
    }

    public void setNext(Bubble b){
        next = b;
    }

    public void setPrev(Bubble b){
        previous = b;
    }

    public Bubble getNext(){
        return next;
    }

    public Bubble getPrevious(){
        return previous;
    }

    //draws and moves
    public void draw(GraphicsContext gc){

        gc.setFill(Color.LIGHTBLUE);

        gc.fillOval(x,y,5,5);

        run();

    }

    //this method calls the strategy
    public void run(){

        st.execute(this);

    }


}