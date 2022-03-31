/**
 * Hippo Class.
 * This class represents a Hippo, a subclass of Pet.
 * A Hippo can get stronger, or buffed, each time it makes an enemy Pet faint.
 * Contains 1 private instance variable
 * Contains one 3-args constructor and one no-args constructor
 * Has a total of 3 public methods
 * @author gcanales6
 * @version 1.3
 */

public class Hippo extends Pet {
    private int buff;

    /**
     * 3-args constructor for a Hippo object.
     * @param health int representing the health of the Hippo
     * @param attack int representing the attack power of the Hippo
     * @param buff int representing the amount of buff the Hippo might get
     */
    public Hippo(int health, int attack, int buff) {
        super(health, attack);
        if (buff >= 0) {
            this.buff = buff;
        } else {
            this.buff = 0;
        }
    }

    /**
     * no-args constructor for a Hippo object.
     */
    public Hippo() {
        this(7, 4, 2);
    }

    /**
     * getBuffed() method, buffs this Hippo's health and attack.
     */
    public void getBuffed() {
        this.setHealth(this.getHealth() + this.buff);
        this.setAttack(this.getAttack() + this.buff);
    }

    @Override
    public void attackPet(Pet other) {
        other.getAttacked(this.getAttack());
        if (other.hasFainted()) {
            this.getBuffed();
        }
    }

    @Override
    public String toString() {
        return "Hippo:" + super.toString() + "/" + this.buff;
    }
}
