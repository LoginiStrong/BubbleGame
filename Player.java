import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.*;

public class Player extends GameObject {
    
    ArrayList<AbstractUnit> nodes = new ArrayList<AbstractUnit>();

    //default color is Red
    public Color col = Color.RED;

    //booleans to track if selected and if moving
    boolean selected = false;
    boolean moving = false;

    //these are ints to track where the unit needs to move to and how fast
    int destinationX = 0;
    int destinationY = 0;
    float velX = 0;
    float velY = 0;

    //this is the player's bubble head node
    Bubble head = null;

    //basic constructor
    public Player(int x, int y){

        super(x,y,50);

    }

    //adds a bubble to the end
    public void addBubble(Bubble b){

        if(head == null){
            head = b;
            
        }
        else{
            
            Bubble temp = head;

            while(temp.getNext()!= null){
                temp = temp.getNext();
              
            }
            
            temp.setNext(b);
            b.setPrev(temp);
          
        }

    }

    //this is to set the velocity, used for purposes of moving the unit
    public void setVelocity(int x2, int y2){

        //System.out.println("I am at: " + x + " " + y);
        //System.out.println("I want to be at: " + x2 + " " + y2);

        destinationX = x2;
        destinationY = y2;
        float diffx = 0;
        float diffy = 0;

        diffx = x2 - this.x;
        diffy = y2 - this.y;
                
        double mag = Math.sqrt(diffx*diffx + diffy*diffy);
                
        diffx /= mag;
        diffy /= mag;

        velX = diffx;
        velY = diffy;

        moving = true;
       
    }

    public void toggleOn(){

        selected = true;

    }

    public void toggleOff(){

        selected = false;

    }

    public void setColor(Color c){
        col = c;
    }

    public Vector2 getPosition(){

        Vector2 v2 = new Vector2();
        v2.setX(this.x);
        v2.setY(this.y);

        return v2;

    }

    public void draw(GraphicsContext gc){

        //moves the unit
        if(moving){
            x+=velX;
            y+=velY;

            //stops moving if at the destination
            if(x<destinationX+1 && x>destinationX-1){
                if(y<destinationY+1 && y>destinationY-1){
                    moving = false;
                }

            }

        }

        //draws based on selected status
        if(!selected){
            gc.setFill(col);
            gc.fillOval(x, y, radius, radius);

        }

        if(selected){
            gc.setFill(Color.WHITE);
            gc.fillOval(x, y, radius, radius);

            gc.setFill(col);
            gc.fillOval(x+2, y+2, radius-4, radius-4);

        }

        removeBubbles();

        Bubble temp = head;

        while(temp!=null){
            
            Bubble b2 = temp;
            b2.draw(gc);
            temp = temp.getNext();
            
        }
        
    }

    public void removeBubbles(){

        Bubble temp = head;

        if(temp == null){
            return;
        }
        else if(temp.getNext()==null){
            if(temp.lifetime<=0){
                head = null;
            }
        }
        else{
            while(temp!=null){
                    if(temp.lifetime <=0){
                        if(temp.getNext()!=null & temp!=head){
                            temp.getPrevious().setNext(temp.getNext());
                            temp.getNext().setPrev(temp.getPrevious());
                        }
                        else if(temp!=head){
                            temp.getPrevious().setNext(null);
                        }
                        else{
                            head = temp.getNext();
                        }
                    }
                temp = temp.getNext();

            }
        }
    }


    public void run(){

        //Dr. Mood "start with run and draw"

        for(int i=0; i<nodes.size(); i++){

            //nodes.get(i).command();

        }

        //are bubbles (the ones being shot) included here?

    }


}
