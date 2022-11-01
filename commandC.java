public class commandC implements command{

    Player p;
    int mouseX;
    int mouseY;

    public commandC(Player p, int mouseX, int mouseY){

        this.p = p;
        this.mouseX = mouseX;
        this.mouseY = mouseY;

    }

    public void execute(Player p1, int mouseX, int mouseY){
        System.out.println("this should print the c command");

        if(p.selected){

            p.setVelocity(mouseX, mouseY); //do something about graphics translation

         }

    }

}