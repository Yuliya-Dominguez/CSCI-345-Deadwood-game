//Singleton class that provides instances of the data from cards.xml
import java.util.ArrayList;
import java.util.List;

public class Card {
    private String cardName;
    private String img;
    private int budget;
    private Scene scene;
    private List<Parts> parts;

    private static Card instance = null;//

    Card(String cardName, String img, int budget) {
        this.cardName = cardName;
        this.img = img;
        this.budget = budget;
        this.parts = new ArrayList<Parts>();
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardName() {
        return cardName;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getBudget() {
        return budget;
    }

    public void addPart(Parts part) {
        this.parts.add(part);
    }

    public List<Parts> getParts() {
        return parts;
    }

    public void setParts(List<Parts> parts) {
        this.parts = parts;
    }

    public static Card getInstance(String cardName, String img, int budget) {
        if (instance == null) {
            instance = new Card(cardName, img, budget);
        }
        return instance;
    }

}