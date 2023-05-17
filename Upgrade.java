//Encapsulates upgrades' data taken from xml files
public class Upgrade {
    private int level;
    private String currency;
    private int amt;
    private Area area;

    public Upgrade(int level, String currency, int amt, Area area) {
        this.level = level;
        this.currency = currency;
        this.amt = amt;
        this.area = area;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

}