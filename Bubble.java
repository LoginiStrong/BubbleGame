import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bubble {

    //position and velocity
    float x;
    float y;
    float velX;
    float velY;

    double lifetime;

    Strategy st;

    Bubble next = null;
    Bubble previous = null;
    //Bubbles will be a linked list?!?!?!?!?!?

    public void insertBubble(Bubble b){

        if(next==null){
            next = b;
            b.setPrev(this);
        }
        else{
            next.setPrev(b);
            b.setNext(this.next);
            b.setPrev(this);
            next = b;
        }

    }


    public Bubble(float x, float y, float velX, float velY, boolean placeholder){
        this.x = x;
        this.y = y;
        this.velX = velX;
        this.velY = velY;

        st = new Strategy0();

        lifetime = 5;
    }

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

    //constructor that sets the velocity
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

        st = new Strategy2();

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

    public void run(){

        st.execute(this);

    }


}