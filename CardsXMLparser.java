//Parses cards.xml file
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;

public class CardsXMLparser {

    // this method taken from Dr. Moushumi's ParseXML example
    public Document getDocFromFile(String filename) throws ParserConfigurationException {
        {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = null;

            try {
                doc = db.parse(filename);
            } catch (Exception ex) {
                System.out.println("XML parse failure");
                ex.printStackTrace();
            }
            return doc;
        }
    }

    //Parse cards.xml
    public ArrayList<Card> readCardsData(Document d) {
        ArrayList<Card> cardsList = new ArrayList<Card>();

        Element root = d.getDocumentElement();
        NodeList cards = root.getElementsByTagName("card");

        for (int i = 0; i < cards.getLength(); i++) {

            Node card = cards.item(i);
            Element cardElem = (Element) card;
            String cardName = cardElem.getAttribute("name");
            String img = cardElem.getAttribute("img");
            int budget = Integer.parseInt(cardElem.getAttribute("budget"));

            Card newCard = new Card(cardName, img, budget);

            NodeList cardChildren = card.getChildNodes();

            for (int j = 0; j < cardChildren.getLength(); j++) {
                Node cardChild = cardChildren.item(j);

                if ("scene".equals(cardChild.getNodeName())) {
                    //scene number and description
                    Element scene = (Element) cardChild;
                    int num = Integer.parseInt(scene.getAttribute("number"));
                    String description = scene.getTextContent();

                    Scene newScene = new Scene(num, description);
                    newCard.setScene(newScene);

                }
                else if ("part".equals(cardChild.getNodeName())) {
                    // part name and level
                    Element partElem = (Element) cardChild;
                    String partName = partElem.getAttribute("name");
                    int partLVL = Integer.parseInt(partElem.getAttribute("level"));

                    // part area
                    NodeList partChildren = cardChild.getChildNodes();
                    Area area = null;

                    for (int r = 0; r < partChildren.getLength(); r++) {
                        Node partChild = partChildren.item(r);
                        if ("area".equals(partChild.getNodeName())) {

                            Element partArea = (Element) partChild;
                            int px = Integer.parseInt(partArea.getAttribute("x"));
                            int py = Integer.parseInt(partArea.getAttribute("y"));
                            int ph = Integer.parseInt(partArea.getAttribute("h"));
                            int pw = Integer.parseInt(partArea.getAttribute("w"));
                            area = new Area(px, py, ph, pw);
                        } else if ("line".equals(partChild.getNodeName())) {

                            Element partLine = (Element) partChild;
                            String line = partLine.getTextContent();
                            //System.out.println("Line: \"" + line + "\"");
                            Parts newPart = new Parts(partName, partLVL, area, line);
                            newCard.addPart(newPart);
                        }
                    }
                }
            }
            cardsList.add(newCard);
        }
        return cardsList;
    }
}
