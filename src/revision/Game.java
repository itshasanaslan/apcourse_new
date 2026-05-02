package revision;

public class Game {

    private Warrior[] warriors;


    public void attack(Warrior attacker, Warrior defender) {

        defender.setHealth((int)attacker.getDamagePoint());
        System.out.println(attacker.getName() + " has attacked " + defender.getName() + " and dealt " + attacker.getDamagePoint() + " damage points.");
    }


}
