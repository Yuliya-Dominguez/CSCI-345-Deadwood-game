public class Acting {
    public String playerRole;
    public int shotsFinished;

    Store store = Store.getStoreInstance();

    public void successMainRole() {
        System.out.println("Success! Gain two credits.");
        store.payForShot();
    }

    public void successExtraRole() {
        System.out.println("Success! Gain a credit and dollar!");
        store.payForShot();
    }

    public void failureMainRole() {
        System.out.println("Failure. Nothing gained.");
        
    }

    public void failureExtraRole() {
        System.out.println("Failure. Dollar gained.");
    }
}
