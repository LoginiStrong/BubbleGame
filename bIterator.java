import javafx.event.*;
import javafx.stage.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.animation.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.geometry.*;
import javafx.application.Application;
import java.io.*;
import java.util.*;
import java.text.*;


 //Iterator and linked list need to work together?
   public class bIterator
   {
      Bubble head;
      Bubble current;
      Bubble lastThingSeen;

      public bIterator(Bubble b)
      {
         head = b;
         current = b;
      }
   
      public Bubble getNext()
      {
         //If there is nothing next, returns null
         if(current == null || !current.hasNext())
         {
            return null;
         }
         else{
            return current.getNext();
         }
         //Gets the next unit in the array list
      
      }
      
      public Bubble collidingCheck(ArrayList<Player> p){

         for(int i=0; i<p.size(); i++){

            Bubble temp = head;

            while(temp!=null){

               if(temp.collision(p.get(i)) && !temp.playerSide.equals(p.get(i).cu.side)){
                  p.get(i).damage(temp.getDamage());

                  temp.removeSelf();

               }

               temp = temp.getNext();
            }

         }

         return head;

      }


      public void setHead(Bubble b){
         head = b;
      }

      public boolean hasNext()
      {
         //return whether or not there is another node
         return current.hasNext();
      }  
      
      public void draw(GraphicsContext gc){

        Bubble temp = head;

        while(temp!=null){
            
            Bubble b2 = temp;
            b2.draw(gc);
            temp = temp.getNext();
            
        }

      }

      public Bubble remove()
      {
         //System.out.println("Remove 1");
         Bubble temp = head;

         if(temp == null){ //if the head is null, do nothing
            return null;
         }
         else if(temp.getNext()==null){ //if the head is standalone, just check the head
               if(temp.lifetime<=0){
                  head = null;
                  System.out.println("Head Removed");
               }
         }
         else{
               while(temp!=null){

                     if(temp.lifetime <=0){
                        
                        if(temp!=head){
                           Bubble temp2 = temp.getNext();
                           temp.removeSelf();
                           temp = temp2;
                          
                        }
                        else{
                            head = temp.getNext();
                        }
                    }
               temp = temp.getNext();

            }
        }
      
        return head;

      }
   }
