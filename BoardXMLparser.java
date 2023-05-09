import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class BoardXMLparser {

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

    public void readBoardData(Document d) {

        Element root = d.getDocumentElement();
        String boardName = root.getAttribute("name");
        System.out.println("Board Name: " + boardName);

        // sets
        NodeList sets = root.getElementsByTagName("set");

        for (int i = 0; i < sets.getLength(); i++) {

            System.out.println("This is a set # " + (i + 1));

            Node set = sets.item(i);

            String setName = set.getAttributes().getNamedItem("name").getNodeValue();
            System.out.println("Set name: " + setName);

            // set children
            NodeList setChildren = set.getChildNodes();

            for (int f = 0; f < setChildren.getLength(); f++) {
                Node setChild = setChildren.item(f);

                if ("neighbors".equals(setChild.getNodeName())) {

                    NodeList setNeighbors = setChild.getChildNodes();
                    System.out.println("Neighbors:");

                    for (int j = 0; j < setNeighbors.getLength(); j++) {

                        Node setNeighbor = setNeighbors.item(j);

                        if ("neighbor".equals(setNeighbor.getNodeName())) {

                            String neighborName = setNeighbor.getAttributes().getNamedItem("name").getNodeValue();
                            System.out.println("Neighbor #" + (j + 1) + ": " + neighborName);
                        }
                    }

                } else if ("area".equals(setChild.getNodeName())) { // set area

                    Element setArea = (Element) setChild;
                    int x = Integer.parseInt(setArea.getAttribute("x"));
                    int y = Integer.parseInt(setArea.getAttribute("y"));
                    int h = Integer.parseInt(setArea.getAttribute("h"));
                    int w = Integer.parseInt(setArea.getAttribute("w"));
                    System.out.println("Area = x: " + x + ", y: " + y + ", h: " + h + ", w: " + w);

                } else if ("takes".equals(setChild.getNodeName())) { // takes

                    NodeList takes = setChild.getChildNodes();
                    System.out.println("Takes:");

                    for (int p = 0; p < takes.getLength(); p++) {

                        Node take = takes.item(p);

                        if ("take".equals(take.getNodeName())) {

                            Element takeElem = (Element) take;
                            int takeNum = Integer.parseInt(takeElem.getAttribute("number"));
                            System.out.println("Take #: " + takeNum);
                            

                            // take area
                            NodeList takeChildren = take.getChildNodes();

                            for (int tc = 0; tc < takeChildren.getLength(); tc++) {
                                Node takeChild = takeChildren.item(tc);
                                if ("area".equals(takeChild.getNodeName())) {

                                    Element takeArea = (Element) takeChild;
                                    int tx = Integer.parseInt(takeArea.getAttribute("x"));
                                    int ty = Integer.parseInt(takeArea.getAttribute("y"));
                                    int th = Integer.parseInt(takeArea.getAttribute("h"));
                                    int tw = Integer.parseInt(takeArea.getAttribute("w"));
                                    System.out.println("x: " + tx + ", y: " + ty + ", h: " + th + ", w: " + tw);
                                }
                            }
                        }
                    }
                } else if ("parts".equals(setChild.getNodeName())) { // parts

                    NodeList parts = setChild.getChildNodes();
                    System.out.println("Parts:");

                    for (int q = 0; q < parts.getLength(); q++) {

                        Node part = parts.item(q);

                        if ("part".equals(part.getNodeName())) {

                            // part name and level
                            Element partElem = (Element) part;
                            String partName = partElem.getAttribute("name");
                            int partLVL = Integer.parseInt(partElem.getAttribute("level"));
                            System.out.println("Part name: " + partName + ", Level: " + partLVL);
                            

                            // upgrade area
                            NodeList partChildren = part.getChildNodes();

                            for (int r = 0; r < partChildren.getLength(); r++) {
                                Node partChild = partChildren.item(r);
                                if ("area".equals(partChild.getNodeName())) {

                                    Element partArea = (Element) partChild;
                                    int px = Integer.parseInt(partArea.getAttribute("x"));
                                    int py = Integer.parseInt(partArea.getAttribute("y"));
                                    int ph = Integer.parseInt(partArea.getAttribute("h"));
                                    int pw = Integer.parseInt(partArea.getAttribute("w"));
                                    System.out.println("x: " + px + ", y: " + py + ", h: " + ph + ", w: " + pw);
                                } else if ("line".equals(partChild.getNodeName())) {

                                    Element partLine = (Element) partChild;
                                    String line = partLine.getTextContent();
                                    System.out.println("Line: \"" + line + "\"");
                                }
                            }
                        }
                    }
                }
            }
        }

        // trailer
        NodeList trailers = root.getElementsByTagName("trailer");
        System.out.println("Trailer");

        Node trailer = trailers.item(0);

        // trailer children
        NodeList trailChildren = trailer.getChildNodes();
        System.out.println("Trailer Neighbors:");

        for (int l = 0; l < trailChildren.getLength(); l++) {

            Node trailChild = trailChildren.item(l);

            // trailer neighbors
            if ("neighbors".equals(trailChild.getNodeName())) {

                NodeList trailNeighbors = trailChild.getChildNodes();

                for (int c = 0; c < trailNeighbors.getLength(); c++) {

                    Node trailNeighbor = trailNeighbors.item(c);

                    if ("neighbor".equals(trailNeighbor.getNodeName())) {
                        Element trailNeighborElem = (Element) trailNeighbor;
                        String trailNeighborName = trailNeighborElem.getAttributes().getNamedItem("name")
                                .getNodeValue();
                        System.out.println("Neighbor #" + (c + 1) + ": " + trailNeighborName);
                    }
                }
            } else if ("area".equals(trailChild.getNodeName())) { // trailer area

                Element trailerArea = (Element) trailChild;
                int trX = Integer.parseInt(trailerArea.getAttribute("x"));
                int trY = Integer.parseInt(trailerArea.getAttribute("y"));
                int trH = Integer.parseInt(trailerArea.getAttribute("h"));
                int trW = Integer.parseInt(trailerArea.getAttribute("w"));
                System.out.println("x: " + trX + ", y: " + trY + ", h: " + trH + ", w: " + trW);
            }
        }

        // office
        NodeList officeLoc = root.getElementsByTagName("office");
        System.out.println("Office:");

        Node office = officeLoc.item(0);

        // office children
        NodeList officeChildren = office.getChildNodes();
        System.out.println("Office Neighbors:");

        for (int m = 0; m < officeChildren.getLength(); m++) {

            Node child = officeChildren.item(m);

            if ("neighbors".equals(child.getNodeName())) {

                NodeList officeNeighbors = child.getChildNodes();

                for (int c = 0; c < officeNeighbors.getLength(); c++) {

                    Node officeNeighbor = officeNeighbors.item(c);

                    if ("neighbor".equals(officeNeighbor.getNodeName())) {
                        Element officeNeighborElem = (Element) officeNeighbor;
                        String officeNeighborName = officeNeighborElem.getAttributes().getNamedItem("name")
                                .getNodeValue();
                        System.out.println("Neighbor #" + (c + 1) + ": " + officeNeighborName);
                    }
                }
            } else if ("area".equals(child.getNodeName())) { // office area

                Element officeArea = (Element) child;
                int ofX = Integer.parseInt(officeArea.getAttribute("x"));
                int ofY = Integer.parseInt(officeArea.getAttribute("y"));
                int ofH = Integer.parseInt(officeArea.getAttribute("h"));
                int ofW = Integer.parseInt(officeArea.getAttribute("w"));
                System.out.println("x: " + ofX + ", y: " + ofY + ", h: " + ofH + ", w: " + ofW);
            } else if ("upgrades".equals(child.getNodeName())) { // upgrades

                NodeList upgrades = child.getChildNodes();
                System.out.println("Upgrades:");

                for (int u = 0; u < upgrades.getLength(); u++) {

                    Node upgrade = upgrades.item(u);

                    if ("upgrade".equals(upgrade.getNodeName())) {

                        // levels and price
                        Element upgradeElem = (Element) upgrade;
                        int level = Integer.parseInt(upgradeElem.getAttribute("level"));
                        String currency = upgradeElem.getAttribute("currency");
                        int amt = Integer.parseInt(upgradeElem.getAttribute("amt"));
                        System.out.println("Level " + level + " Currency: " + currency + " Amount: " + amt);

                        // upgrade area
                        NodeList upgradeChildren = upgrade.getChildNodes();

                        for (int uc = 0; uc < upgradeChildren.getLength(); uc++) {
                            Node upgradeChild = upgradeChildren.item(uc);
                            if ("area".equals(upgradeChild.getNodeName())) {
                                Element upgradeArea = (Element) upgradeChild;
                                int upX = Integer.parseInt(upgradeArea.getAttribute("x"));
                                int upY = Integer.parseInt(upgradeArea.getAttribute("y"));
                                int upH = Integer.parseInt(upgradeArea.getAttribute("h"));
                                int upW = Integer.parseInt(upgradeArea.getAttribute("w"));
                                System.out.println("x: " + upX + ", y: " + upY + ", h: " + upH + ", w: " + upW);
                            }
                        }
                    }
                }
            }
        }
    }
}
