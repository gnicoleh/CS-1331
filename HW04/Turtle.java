/**
 * Turtle Class.
 * This class represents a Turtle, a subclass of Pet.
 * A Turtle can start with a melon armor which prevents up to
 * 20 damage the first time it is attacked.
 * Contains 1 private instance variable
 * Constains one 3-args constructor and one no-args constructor
 * Has a total of 2 public methods
 * @author gcanales6
 * @version 1.3
 */

public class Turtle extends Pet {
    private boolean melonArmor;

    /**
     * 3-args constructor for a Turtle object.
     * @param health int representing the health of the Turtle
     * @param attack int representing the attack power of the Turtle
     * @param melonArmor boolean representing the presence of the melonArmor on the Turtle
     */
    public Turtle(int health, int attack, boolean melonArmor) {
        super(health, attack);
        this.melonArmor = melonArmor;
    }

    /**
     * no-args constructor for a Turtle object.
     */
    public Turtle() {
        this(4, 2, true);
    }

    @Override
    public void getAttacked(int attack) {
        if (this.melonArmor) {
            attack = attack > 20 ? attack - 20 : 0;
            this.melonArmor = false;
        }
        super.getAttacked(attack);
    }

    @Override
    public String toString() {
        return "Turtle:" + super.toString() + "/" + this.melonArmor;
    }
}
