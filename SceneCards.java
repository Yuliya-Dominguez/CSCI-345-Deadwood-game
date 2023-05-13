import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

public class SceneCards {

    public int cardRoleRank;
    public int boardRoleRank;
    public int shotCounter;
    public String[] cardRoles;
    public String[] boardRoles;

    private CardsXMLparser parser;//
    private static ArrayList<Card> cardsList;//

    public SceneCards() {
        Document doc = null;
        parser = new CardsXMLparser();
        try {
            doc = parser.getDocFromFile("cards.xml");
            cardsList = parser.readCardsData(doc);
        } catch (Exception e) {
            System.out.println("Error = " + e);
        }
    }

    public int getCardBudget(int index) {
        Card card = cardsList.get(index);
        int budget = card.getBudget();
        System.out.println("budget = "+ budget);
        return budget;
    }

    public static String getName(int index) {
        Card card = cardsList.get(index);
        String name = card.getCardName();
        System.out.println("name = "+ name);
        return name;
     }

    public int getSceneNumber(int index) {
        Card card = cardsList.get(index);
        Scene scene = card.getScene();
        int number = scene.getNumber();
        System.out.println("scene number = " + number);
        return number;
    }

    public String getSceneDescription(int index) {
        Card card = cardsList.get(index);
        Scene scene = card.getScene();
        String description = scene.getDescription();
        System.out.println("scene description = " + description);
        return description;
    }

    public static String getPartName(int cardIndex, int partIndex) {
        Card card = cardsList.get(cardIndex);
        List<Parts> partsList = card.getParts();
        Parts part = partsList.get(partIndex);
        String name = part.getName();
        System.out.println("part name = " + name);
        return name;
     }
     
     public static int getPartLevel(int cardIndex, int partIndex) {
        Card card = cardsList.get(cardIndex);
        List<Parts> partsList = card.getParts();
        Parts part = partsList.get(partIndex);
        int level = part.getLevel();
        System.out.println("part level = " + level);
        return level;
     }
     
     public static Area getPartArea(int cardIndex, int partIndex) {
        Card card = cardsList.get(cardIndex);
        List<Parts> partsList = card.getParts();
        Parts part = partsList.get(partIndex);
        Area area = part.getArea();
        int x = area.getX();
        int y = area.getY();
        int h = area.getH();
        int w = area.getW();
        System.out.println("part area: x= " + x + ", y=" + y + ", h=" + h + ", w=" + w);
        return area;
     }
     
     public static String getPartLine(int cardIndex, int partIndex) {
        Card card = cardsList.get(cardIndex);
        List<Parts> partsList = card.getParts();
        Parts part = partsList.get(partIndex);
        String line = part.getLine();
        System.out.println("part line = " + line);
        return line;
     }

    public void removeShot() {

    }

    public void hideCard() {

    }

    public void revealCard() {

    }

}
