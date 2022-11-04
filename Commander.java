public class Commander {
    
    command bc;

    public Commander(){

    }

    public void setCommand(command bc2){
        bc = bc2;
    }

    public void execute(Player p1, int mouseX, int mouseY){
        bc.execute(p1,mouseX,mouseY);
    }


}
