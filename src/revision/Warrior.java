package revision;

public class Warrior {

    public static int warriorCounter = 0;
    private String name; //dynamic attributes
    private int health;
    private double damagePoint;

    public Warrior(String name, int health, double damagePoint) {
        System.out.println("A warrior is created");
        this.name = name;
        this.health = health;
        this.damagePoint = damagePoint;
                Warrior.warriorCounter++;

    }

    public Warrior() {
        System.out.println("A warrior is created");
        Warrior.warriorCounter++;

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getDamagePoint() {
        return damagePoint;
    }

    public void setDamagePoint(double damagePoint) {
        this.damagePoint = damagePoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }


    @Override
    public String toString(){
        return this.name + " attack: " +  this.damagePoint + " health: " + this.health; 
    }

    //         Warrior w4 = Warrior.getRandom();

    public static Warrior getRandom(){
        // name, health, attackPoint
        // ["a","b,","c"]
        // 0, max , math
        // String name = array[random]
        Warrior a = new Warrior("", 100, 100 );
        return a;
    }


  

}