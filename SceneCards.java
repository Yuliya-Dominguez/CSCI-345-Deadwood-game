//SceneCards accesses and controls data from Singleton class Set, and parses the cards.xml document
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

        return budget;
    }

    public static String getName(int index) {
        Card card = cardsList.get(index);
        String name = card.getCardName();

        return name;
    }

    public int getSceneNumber(int index) {
        Card card = cardsList.get(index);
        Scene scene = card.getScene();
        int number = scene.getNumber();

        return number;
    }

    public String getSceneDescription(int index) {
        Card card = cardsList.get(index);
        Scene scene = card.getScene();
        String description = scene.getDescription();

        return description;
    }

    public static List<Parts> getPartsList(int index) {

        Card card = cardsList.get(index);
        List<Parts> partsList = card.getParts();

        return partsList;
    }

    public static String getPartName(int cardIndex, int partIndex) {
        Card card = cardsList.get(cardIndex);
        List<Parts> partsList = card.getParts();
        Parts part = partsList.get(partIndex);
        String name = part.getName();

        return name;
    }

    public static int getPartLevel(int cardIndex, int partIndex) {
        Card card = cardsList.get(cardIndex);
        List<Parts> partsList = card.getParts();
        Parts part = partsList.get(partIndex);
        int level = part.getLevel();

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

        return area;
    }

    public static String getPartLine(int cardIndex, int partIndex) {
        Card card = cardsList.get(cardIndex);
        List<Parts> partsList = card.getParts();
        Parts part = partsList.get(partIndex);
        String line = part.getLine();

        return line;
    }

}
