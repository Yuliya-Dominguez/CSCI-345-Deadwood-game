public class Acting {
    public String playerRole;
    public int shotsFinished;

    Player player = new Player();
    Store store = new Store();

    public void successMainRole() {
        System.out.println("Success!");
        shotsFinished++;
        store.payForShot();
    }

    public void successExtraRole() {
        System.out.println("Success!");
        shotsFinished++;
        store.payForShot();
    }

    public void failureMainRole() {
        System.out.println("Failure.");
        
    }

    public void failureExtraRole() {
        System.out.println("Failure.");
        
    }
}
