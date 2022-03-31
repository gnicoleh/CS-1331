import java.util.ArrayList;

public class Driver {
    /**
     * wee
     * @param args wee.
     */
    public static void main(String[] args) {
        Store store = new Store("My Store");
        Cake cake1 = new Cake("chocolate"); //45.0 --5
        Cake cake2 = new Cake("chocolate", 35, "chocolate"); //--4
        Cake cake3 = new Cake("Chocolate", 35, "chocolate"); //--3
        Cake cake4 = new Cake("napolitan", 15, "vanilla"); //--2
        Cake cake5 = new Cake("Strawberry", 35, "vanilla");
        IceCream iceCream1 = new IceCream(); //45.0 vanilla --6
        IceCream iceCream2 = new IceCream(1, true); //45.0 vanilla --7
        IceCream iceCream3 = new IceCream("napolitan", 10, 2, true); //--1
        IceCream iceCream4 = new IceCream("Strawberry", 70, 2, true); //--8
        store.addDessert(cake1);
        store.addDessert(cake2);
        store.addDessert(cake3);
        store.addDessert(cake5);
        store.addDessert(iceCream4);
        store.addDessert(iceCream1);
        store.addDessert(iceCream3);
        store.addDessert(iceCream2);
        //System.out.println(store.getDesserts().get(2));
        //System.out.println("------ BEFORE REMOVING CAKE3 ------");
        //Driver.showDesserts(store.getDesserts());
        //System.out.println("cake1.equals(cake2): " + cake1.equals(cake2));
        //System.out.println("cake2.equals(cake3): " + cake2.equals(cake3));
        //System.out.println("iceCream1.equals(iceCream2): " + iceCream1.equals(iceCream2));
        //System.out.println("iceCream2.equals(iceCream3): " + iceCream2.equals(iceCream3));
        //System.out.println("cake2.compareTo(cake1): " + cake2.compareTo(cake1));
        //System.out.println("cake2.compareTo(cake3): " + cake2.compareTo(cake3));
        //System.out.println("iceCream1.compareTo(iceCream2): " + iceCream1.compareTo(iceCream2));
        //System.out.println("iceCream2.compareTo(iceCream3): " + iceCream2.compareTo(iceCream3));
        //System.out.println("------ AFTER REMOVING CAKE4 ------");
        //System.out.println("Removed dessert: " + store.removeDessert(cake4));
        //System.out.println("------ AFTER REMOVING CAKE3  && ADDING CAKE 4 ------");
        //System.out.println("Removed dessert: " + store.removeDessert(cake3));
        store.addDessert(cake4);
        Driver.showDesserts(store.getDesserts());
        //System.out.println("------ SORTING STORE ------");
        //store.sortStore();
        //System.out.println("Store sorted, displaying desserts: " );
        //Driver.showDesserts(store.getDesserts());
        //System.out.println("------ LOOKING FOR ICECREAM3 ------");
        //System.out.println("Found dessert: " + store.findDessert(iceCream3));
        //System.out.println("------ CHECKIN STORE FOR CAKE5 ------");
        //System.out.println(store.checkStore(cake5));
        //Store storeA = new Store("My Other Store");
        //storeA.addDessert(iceCream4);
        //storeA.addDessert(cake3);
        //storeA.addDessert(iceCream3);
        //storeA.addDessert(cake5);
        //storeA.addDessert(iceCream1);
        //storeA.addDessert(iceCream2);
        //storeA.addDessert(cake2);
        //Store storeC = new Store("My Other-Other Store");
        //System.out.println("StoreA desserts are all present in Store: " + Bob.compareStores(storeA, store));
        System.out.println("Bob was able to find his dessert: " + Bob.shop(store, iceCream3));
    }

    /**
     * wee.
     * @param desserts wee
     */
    private static void showDesserts(ArrayList<Dessert> desserts) {
        for (Dessert d : desserts) {
            if (d != null) {
                System.out.println(d.toString());
            }
        }
    }
}
