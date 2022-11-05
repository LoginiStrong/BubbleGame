public class IteratorClass
{
   Node head;
   
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
   
      public int getNext()
      {
         //return data
         //advance
         return 0;
      }
      
      public boolean hasNext()
      {
         //return whether or not there is another node
         return false;
      }  
      
      public void remove()
      {
         //removes the last thing I saw
      }
   }
}