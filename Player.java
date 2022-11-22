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

    ConcreteUnit cu;
    AbstractUnit au;

    //these are ints to track where the unit needs to move to and how fast
    int destinationX = 0;
    int destinationY = 0;
    float velX = 0;
    float velY = 0;

    Bubble head = null;

    boolean firesBubbles = false;

    float centerX = 0, centerY = 0;

    ArrayList<Integer> range = new ArrayList<Integer>();
    ArrayList<Double> refireSpeed = new ArrayList<Double>();
   
    ArrayList<Long> currentTimes = new ArrayList<Long>();

    ArrayList<BubbleDecorator> bubbleDecs = new ArrayList<BubbleDecorator>();

    //long currentTime = System.currentTimeMillis();

    //basic constructor
    public Player(ConcreteUnit cu, AbstractUnit au){

        super(cu.getX(), cu.getY(), cu.radius);
        this.cu = cu;
        this.au = au;

        centerX = x+radius;
        centerY = y+radius;

        setUpBubbleData();

    }

    public boolean refire(int index){

        long t2 = System.currentTimeMillis();

        if(t2-currentTimes.get(index)>refireSpeed.get(index)*1000){
            currentTimes.set(index, t2);
            return true;
        }
        
        return false;

    }

    public boolean isPlayerDead(){

        boolean isDead = false;

        AbstractUnit temp = au;
        while(temp!=null){

            if(temp.getClass() == HealthDecorator.class){
                
                HealthDecorator h = (HealthDecorator)temp;
                isDead = h.getDead();
               
            }

            temp=temp.getNext();

        }




        return isDead;

    }

    public void damage(double dmg){

        AbstractUnit temp = au;
        while(temp!=null){

            if(temp.getClass() == HealthDecorator.class){
                
                HealthDecorator h = (HealthDecorator)temp;
                h.takeDamage(dmg);
               
            }

            temp=temp.getNext();

        }


    }


    public void setUpBubbleData(){

        AbstractUnit temp = au;
        while(temp!=null){

            if(temp.getClass() == BubbleDecorator.class){
                BubbleDecorator bubbs = (BubbleDecorator)(temp);

                firesBubbles = true;

                range.add(bubbs.range);
                refireSpeed.add(bubbs.getFireRate());
                currentTimes.add(System.currentTimeMillis());

                bubbs.playerSide = cu.side;
                bubbleDecs.add(bubbs);
                System.out.println("Range: " + this.range);
                System.out.println("RefireSpeed: " + this.refireSpeed);
            }

            temp=temp.getNext();

        }

    }

    public Bubble getBubble(int destinationX, int destinationY, int index){

        
        return bubbleDecs.get(index).getBubble(this.centerX, this.centerY, 
            destinationX, destinationY);


    }

    public boolean inRange(Player p, int index){

        if(p == this){
            return false;
        }

        float xc = p.centerX;
        float yc = p.centerY;

        float distX = (centerX-xc)*(centerX-xc);
        float distY = (centerY-yc)*(centerY-yc);

        double distA = distX + distY;

        double dist = Math.sqrt(distA);

        //System.out.println(dist);
        if(dist<range.get(index)){
            return true;
        }

        return false;

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
    
   
    public void setPos(int x, int y){

        AbstractUnit temp = au;
        while(temp!= null){
            temp.setPos(x, y);
            temp = temp.next;
        }

    }
    

    public void draw(GraphicsContext gc){

        
        //moves the unit
        if(moving){
            x+=velX;
            y+=velY;
            setPos((int)(x),(int)(y));

            //stops moving if at the destination
            if(x<destinationX+1 && x>destinationX-1){
                if(y<destinationY+1 && y>destinationY-1){
                    moving = false;
                }

            }

        }

        centerX = x+radius;
        centerY = y+radius;

       //removeBubbles();
        /*
        Bubble temp = head;

        while(temp!=null){
            
            Bubble b2 = temp;
            b2.draw(gc);
            temp = temp.getNext();
            
        }
        */

        au.draw(gc);

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


    }


}
