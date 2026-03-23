package chess;

public class Player {
    private String name;
    private String color;
    private int elo;

    public Player(String name, String color, int elo) {
        this.setName(name);
        this.color = color;
        this.elo = elo;
    }
    

    
    public Player(String name, String color) {
        this.name = name;
        this.color = color;
    }
    

    // ismail adiguzel
    public void setName(String name){
        this.name = "";
        String[] names = name.split(" ");
        for (String item: names) {
            this.name += item.substring(0).toUpperCase() + item.substring(1) + " ";
        }    
        this.name = this.name.substring(0, this.name.length() -1);
        System.out.println("check the name if there's a space");
   
    }



    public String getName(){
        return this.name;
    }

     public String getColor(){
        return this.color;
    }

    public void setColor(String color) {
        throw new UnsupportedOperationException();
    }

}
