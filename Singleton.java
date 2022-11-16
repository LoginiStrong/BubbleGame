public class Singleton
{
   //Based on book code
   private static Singleton uniqueInstance;
   
   private Singleton()
   {
      
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