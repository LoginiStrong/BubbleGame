import java.util.*;

public class IteratorClass
{
   Node head;
   LinkedList<AbstractUnit> unit = new LinkedList<AbstractUnit>();
   int position = 0;
   
   Iterator createIterator()
   {
      Iterator i = new Iterator(head);
      return i;
   }

   public class Iterator
   {
      Node current;
      Node lastThingSeen;
   
      public Iterator(Node start)
      {
         current = start;
      }
   
      public AbstractUnit getNext()
      {
         //If there is nothing next, returns null
         if(!hasNext())
         {
            return null;
         }
         
         //Gets the next unit in the array list
         AbstractUnit newUnit = unit.pop();
         
         return newUnit;
      }
      
      public boolean hasNext()
      {
         //return whether or not there is another node
         return !unit.isEmpty();
      }  
      
      public void remove(AbstractUnit removeUnit/*take in what is to be removed*/)
      {
         //removes the last thing I saw
         unit.remove(removeUnit);
      }
   }
}