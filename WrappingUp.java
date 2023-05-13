public class WrappingUp {
    public String playerRole;
    public boolean mainActorRoleFilled;
    public int playerRank;

    Store store = Store.getStoreInstance();

    private boolean checkMainRoleFilled() {
        return mainActorRoleFilled;
    }

    public void playerMainBonus() {
        System.out.println("End of Scene!");
        store.payBonus();
    }

    public void playerExtraBonus() {
        System.out.println("End of Scene!");
        if (checkMainRoleFilled()) {
            store.payBonus();
        }
        else {
            System.out.println("No actor on card, so no bonus.");
        }
    }

}
