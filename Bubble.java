import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bubble {

    //position and velocity
    float x;
    float y;
    float velX;
    float velY;

    int lifetime;

    Strategy st;

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

        st = new Strategy0();

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