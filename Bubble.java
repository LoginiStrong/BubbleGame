import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bubble extends AbstractUnit{

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
    
    public Vector2 getPosition(){
        return null;
    }
    public void setPos(int x, int y){

    }


    //this constructor is used to set the velocity of the bubble
    public Bubble(float x, float y, float velX, float velY, boolean placeholder){
        this.x = x;
        this.y = y;
        this.velX = velX;
        this.velY = velY;

        st = new Strategy0();

        lifetime = 5;
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
    public Bubble(float x, float y, int destinationX, int destinationY){

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