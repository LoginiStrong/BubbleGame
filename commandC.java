public class commandC implements command{


    public commandC(){


    }

    public void execute(Player p1, int mouseX, int mouseY){
        //System.out.println("this should print the c command");

        if(p1.cu.selected){

            p1.setVelocity(mouseX, mouseY); //do something about graphics translation
            System.out.println("AHHHH");

         }

    }

}