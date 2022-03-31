/**
 * Pet Class.
 * Abstract class representinga Pet.
 * Pets should be able to be compared based on a combination of their stats,
 * health, and attack, properly following the contract set by the Comparable
 * interface using generics.
 * Contains 2 private instance variables
 * Contains one 2-args constructor
 * Has a total of 5 public methods and 2 pairs of getters and setters (health, attack)
 * @author gcanales6
 * @version 1.3
 */

public abstract class Pet implements Comparable<Pet> {
    private int health;
    private int attack;

    /**
     * 2-args constructor to be used on a super called by a child of Pet.
     * @param health int representing the health of the Pet
     * @param attack int representing the attack power of the Pet
     */
    public Pet(int health, int attack) {
        if (health <= 0) {
            this.health = 1;
        } else {
            this.health = health;
        }
        if (attack < 0) {
            this.attack = 0;
        } else {
            this.attack = attack;
        }
    }

    /**
     * hasFainted() method, determines whether a Pet's health is 0 or below.
     * @return boolean representing if a Pet can keep battling or not
     */
    public boolean hasFainted() {
        return this.health <= 0;
    }

    /**
     * getAttacked() method, an attack is performed on the Pet.
     * @param damage int representing the damage the Pet will take
     */
    public void getAttacked(int damage) {
        this.health -= damage;
    }

    /**
     * attackPet() method, this Pet attacks other Pet.
     * @param other Pet representing the Pet to be attacked
     */
    public void attackPet(Pet other) {
        other.getAttacked(this.attack);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", this.attack, this.health);
    }

    @Override
    public int compareTo(Pet other) {
        if (other == null) {
            return 100;
        } else {
            return (this.attack + this.health - other.attack - other.health);
        }
    }

    /**
     * getter for the health of the Pet.
     * @return int representing the current health of the Pet
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * getter for the attack power of the Pet.
     * @return int representing the current attack power of the Pet
     */
    public int getAttack() {
        return this.attack;
    }

    /**
     * setter for the health of the Pet.
     * @param health int representing the new health of the Pet
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * setter for the attack of the Pet.
     * @param attack int representing the new attack power of the Pet
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }
}