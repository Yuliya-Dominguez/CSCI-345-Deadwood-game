public class WrappingUp {
    public String playerRole;
    public boolean mainActorRoleFilled;
    public int playerRank;

    Store store = Store.getStoreInstance();

    //Check for if there is an actor on a scene card on the same card.
    private boolean checkMainRoleFilled() {
        return mainActorRoleFilled;
    }

    //Pay bonus for main actor.
    public void playerMainBonus() {
        System.out.println("That's a wrap! End of Scene!");
        store.payBonus();
    }

    //Pay bonus for extra actor.
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
