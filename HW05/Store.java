import java.util.ArrayList;

/**
 * Store Class.
 * This class stores the data for the dessert store.
 * A store can sell all kinds of desserts.
 * @author gcanales6
 * @version 1.0
 */

public class Store {
    private String name;
    private ArrayList<Dessert> desserts;

    /**
     * 1-arg constructor for Store.
     * @param name String representing the Store name
     */
    public Store(String name) {
        this.name = name;
        this.desserts = new ArrayList<Dessert>();
    }

    /**
     * addDessert() method appends a dessert at the end of a dessert list.
     * @param dessert Dessert to be appended to the list
     */
    public void addDessert(Dessert dessert) {
        this.desserts.add(dessert);
    }

    /**
     * removeDessert() method removes the given dessert if present in as dessert list.
     * @param dessert Dessert to be removed from the list
     * @return Dessert that was removed
     */
    public Dessert removeDessert(Dessert dessert) {
        int index = this.desserts.indexOf(dessert);
        if (index != -1 && dessert.equals(this.desserts.get(index))) {
            return this.desserts.remove(index);
        } else {
            return null;
        }
    }

    /**
     * findDessert() method uses binary search to look within the list for the specified Dessert.
     * @param dessert Dessert to be used to compare and find in the given list
     * @return Dessert containing the same sweetness and flavor as the comparison
     */
    public Dessert findDessert(Dessert dessert) {
        int lowerBound = 0;
        int upperBound = desserts.size() - 1;
        int i = upperBound / 2;
        do {
            int compare = desserts.get(i).compareTo(dessert);
            if (compare == 0) {
                return desserts.get(i);
            } else if (compare < 0) {
                lowerBound = i + 1;
            }  else {
                upperBound = i - 1;
            }
            i = (lowerBound + upperBound) / 2;
        } while (lowerBound <= upperBound);
        return null;
    }

    /**
     * sortStore() method uses selection sort to sort a dessert list from a Store.
     */
    public void sortStore() {
        Dessert min = this.desserts.get(0);
        for (int i = 0; i < this.desserts.size() - 1; i++) {
            for (int j = i + 1; j < this.desserts.size(); j++) {
                if (this.desserts.get(i).compareTo(this.desserts.get(j)) > 0) {
                    min = this.desserts.get(j);
                    this.desserts.remove(j);
                    this.desserts.add(i, min);
                }
            }
        }
    }

    /**
     * checkStore() method loops though a Dessert list of a Store and finds the number of Desserts
     * that are greater or equal to the Dessert passed.
     * @param other Dessert to be used in the comparison
     * @return int representing the number of Desserts greater than the one given
     */
    public int checkStore(Dessert other) {
        int count = 0;
        for (int i = 0; i < this.desserts.size(); i++) {
            if (this.desserts.get(i).compareTo(other) >= 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Getter for desserts.
     * @return ArrayList representing the list of Desserts in a Store
     */
    public ArrayList<Dessert> getDesserts() {
        return this.desserts;
    }
}
