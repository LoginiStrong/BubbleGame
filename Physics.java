import java.util.*;

public class Physics
{
//this method returns the first unit, which overlaps with the current bubble. I guess you get to see my class names :)
   public static AbstractUnit overlapping(Bubble caller, ArrayList<AbstractUnit> circles)
   {
      int size = circles.size();
   
      for(int i=0;i<size;i++)
      {
      
         AbstractUnit go = circles.get(i);
         
         if(go.getSide() == caller.getSide()) //which side the player is on
            continue;
         
         //get positions...
         GameObject.Vector2 position = circles.get(i).getPosition();
         GameObject.Vector2 ownPosition = caller.getPosition();
      
         float x2 = position.getX();
         float y2 = position.getY();
         float rad2 = go.getRadius();
         float dSquared = (rad2 + caller.getRadius())*(rad2 + caller.getRadius());         
         
         //compute distances.
         if(dSquared > (x2 - ownPosition.getX())*(x2 - ownPosition.getX()) + (y2 - ownPosition.getY())*(y2 - ownPosition.getY()) )
         {
            return circles.get(i); //the object that collides 
         }
      }
      return null; //so no object is found that collides
   }


}