/**
 * Skunk Class.
 * This class represents a Skunk, a subclass of Pet.
 * A Skunk can make other Pets weaker before attacking them,
 * but only a set number of times.
 * Contains 1 private instance variable
 * Contains one 3-args constructor, and one no-args constructor
 * Has a total of 3 public methods
 * @author gcanales6
 * @version 1.3
 */

public class Skunk extends Pet {
    private int numSpray;

    /**
     * 3-args constructor for a Skunk object.
     * @param health int representing the health of the Skunk
     * @param attack int representing the attack power of the Skunk
     * @param numSpray int representing the amount of sprays the Skunk has
     */
    public Skunk(int health, int attack, int numSpray) {
        super(health, attack);
        if (numSpray >= 0) {
            this.numSpray = numSpray;
        } else {
            this.numSpray = 0;
        }
    }

    /**
     * no-args constructor for a Skunk object.
     */
    public Skunk() {
        this(5, 3, 1);
    }

    /**
     * sprayPet() method, debuffs other Pet's health and attack.
     * @param other Pet to be affected by the debuff
     */
    public void sprayPet(Pet other) {
        other.setHealth(other.getHealth() - other.getHealth() / 3);
        other.setAttack(other.getAttack() - other.getAttack() / 3);
        numSpray--;
    }

    @Override
    public void attackPet(Pet other) {
        if (this.numSpray > 0) {
            this.sprayPet(other);
        }
        other.getAttacked(this.getAttack());
    }

    @Override
    public String toString() {
        return "Skunk:" + super.toString() + "/" + this.numSpray;
    }
}
