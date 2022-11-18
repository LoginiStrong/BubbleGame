public class Singleton
{
   //Based on book code
   private static Singleton uniqueInstance;
   
   Bubble headList = null;

   public Singleton()
   {
     
   }
   
   public void bubbleLength(){
      

   }

   public Bubble getHead(){
      return headList;
   }

   public void setHead(Bubble b){
      uniqueInstance.headList = b;
   }

   public static synchronized Singleton getInstance()
   {
      if(uniqueInstance == null)
      {
         uniqueInstance = new Singleton();
      }
      return uniqueInstance;
   }
}