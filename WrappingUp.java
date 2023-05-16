public class WrappingUp {
    public String playerRole;
    public boolean mainActorRoleFilled;
    public int playerRank;

    Store store = Store.getStoreInstance();

    private boolean checkMainRoleFilled() {
        return mainActorRoleFilled;
    }

    public void playerMainBonus() {
        System.out.println("That's a wrap! End of Scene!");
        store.payBonus();
    }

    public void playerExtraBonus() {
        System.out.println("That's a wrap! End of Scene!");
        if (checkMainRoleFilled()) {
            store.payBonusExtra();
        }
        else {
            System.out.println("That's a wrap! End of Scene! \tNo actor on card, so no bonus.");
        }
    }

}
