/**
 * Bob Class.
 * This class describes Bob's behaviors.
 * It has a total of 2 static methods.
 * @author gcanales6
 * @version 1.0
 */

public class Bob {
    /**
     * compareStores() method usesbinary search to corroborate if all the Desserts
     * in a given Store are present in the other Store.
     * @param storeA Store containing the Dessert list to be compared to StoreB
     * @param storeB Store that must contain all the Desserts present in StoreA
     * @return boolean repreenting if StoreB has all the dDesserts StoreA has
     */
    public static boolean compareStores(Store storeA, Store storeB) {
        int count = 0;
        for (int i = 0; i < storeA.getDesserts().size(); i++) {
            if (storeB.findDessert(storeA.getDesserts().get(i)) != null) {
                count++;
            }
        }
        return count == storeA.getDesserts().size() && count != 0;
    }

    /**
     * shop() method uses seletion sort and binary search to determine if
     * the given Dessert is present in the specified Store.
     * @param store Store containing the Dessert list to be sorted and searched
     * @param dessert Dessert to be found in the Store
     * @return boolean representing the presence of the specified Dessert in the Store
     */
    public static boolean shop(Store store, Dessert dessert) {
        store.sortStore();
        return store.findDessert(dessert) != null ? true : false;
    }
}
