public class Acting {
    public String playerRole;
    public int shotsFinished;

    //Player player = new Player();
    Store store = Store.getStoreInstance();

    public void successMainRole() {
        System.out.println("Success! Gain two credits.");
        shotsFinished++;
        store.payForShot();
    }

    public void successExtraRole() {
        System.out.println("Success! Gain a credit and dollar!");
        shotsFinished++;
        store.payForShot();
    }

    public void failureMainRole() {
        System.out.println("Failure. Nothing gained.");
        
    }

    public void failureExtraRole() {
        System.out.println("Failure. Dollar gained.");
    }
}
