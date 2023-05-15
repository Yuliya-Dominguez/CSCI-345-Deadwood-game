import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;

public class BoardData {

    private BoardXMLparser parser;
    private static ArrayList<Set> setList;
    private static ArrayList<Trailer> trailerList;
    private static ArrayList<Office> officeList;
    private static int sceneIndex;

    public BoardData() {
        Document doc = null;
        parser = new BoardXMLparser();
        try {
            doc = parser.getDocFromFile("board.xml");
            setList = parser.readBoardData(doc);
            trailerList = parser.readTrailerData(doc);
            officeList = parser.readOfficeData(doc);
        } catch (Exception e) {
            System.out.println("Error = " + e);
        }
    }

    public static String getSetName(int index) {
        Set set = setList.get(index);
        String name = set.getSetName();
        return name;
     }
  
     public static List<Neighbors> getNeighborsList(int index) {
  
        Set set = setList.get(index);
        List<Neighbors> neighborsList = set.getNeighbors();
        return neighborsList;
     }
  
     public static String getNeighborName(int setIndex, int neighborIndex) {
        Set set = setList.get(setIndex);
        List<Neighbors> neighborsList = set.getNeighbors();
        Neighbors neighbors = neighborsList.get(neighborIndex);
        String name = neighbors.getName();
        return name;
     }
  
     //here we will need getArea
  
     public static List<Takes> getTakesList(int index) {
  
        Set set = setList.get(index);
        List<Takes> takesList = set.getTakes();
        return takesList;
     }
  
     public static int getTakesNum(int setIndex, int takeIndex) {
  
        Set set = setList.get(setIndex);
        List<Takes> takesList = set.getTakes();
        Takes takes = takesList.get(takeIndex);
        int num = takes.getNum();
        return num;
     }
  
     //here we will have getTakesArea
  
     public static List<Parts> getPartsList(int index) {
  
        Set set = setList.get(index);
        List<Parts> partsList = set.getParts();
        return partsList;
     }
  
     public static String getPartName(int setIndex, int partIndex) {
        Set set = setList.get(setIndex);
        List<Parts> partsList = set.getParts();
        Parts part = partsList.get(partIndex);
        String name = part.getName();
        return name;
     }
     
     public static int getPartLevel(int setIndex, int partIndex) {
        Set set = setList.get(setIndex);
        List<Parts> partsList = set.getParts();
        Parts part = partsList.get(partIndex);
        int level = part.getLevel();
        return level;
     }
     
     public static Area getPartArea(int setIndex, int partIndex) {
        Set set = setList.get(setIndex);
        List<Parts> partsList = set.getParts();
        Parts part = partsList.get(partIndex);
        Area area = part.getArea();
        int x = area.getX();
        int y = area.getY();
        int h = area.getH();
        int w = area.getW();
        return area;
     }
     
     public static String getPartLine(int setIndex, int partIndex) {
        Set set = setList.get(setIndex);
        List<Parts> partsList = set.getParts();
        Parts part = partsList.get(partIndex);
        String line = part.getLine();
        return line;
     }

     public void takeSceneIndex(int index) {
        sceneIndex = index;
     }

     public int getSceneIndex() {
        return sceneIndex;
     }
     
     public static List<Neighbors> getTrailerNeighbors() {//list of neighbors

        Trailer trailer = trailerList.get(0);
        List<Neighbors> neighborsList = trailer.getNeighbors();
        return neighborsList;
     }

     public static String getTrailNeighbor(int neighborIndex) {//name of a neighbor
        Trailer trailer = trailerList.get(0);
        List<Neighbors> neighborsList = trailer.getNeighbors();
        Neighbors neighbors = neighborsList.get(neighborIndex);
        String name = neighbors.getName();
        return name;
     }
  
     //here we will need trailer's area
  
     public static List<Neighbors> getOfficeNeighbors() {//list of neighbors
  
        Office office = officeList.get(0);
        List<Neighbors> neighborsList = office.getNeighbors();
        return neighborsList;
     }
  
     //here we will need office area
  
     public static String getOffNeighbor(int neighborIndex) {//name of a neighbor
        Office office = officeList.get(0);
        List<Neighbors> neighborsList = office.getNeighbors();
        Neighbors neighbors = neighborsList.get(neighborIndex);
        String name = neighbors.getName();
        return name;
     }

     //upgrades
     public static List<Upgrade> getUpgradesList() {

        Office upgrade = officeList.get(0);
        List<Upgrade> upList = upgrade.getUpgrade();
        return upList;
     }
  
     public static int getUpgradeLevel(int upIndex) {
        Office office = officeList.get(0);
        List<Upgrade> upList = office.getUpgrade();
        Upgrade upgrade = upList.get(upIndex);
        int level = upgrade.getLevel();
        return level;
     }
  
     public static String getUpgradeCurrency(int upIndex) {
        Office office = officeList.get(0);
        List<Upgrade> upList = office.getUpgrade();
        Upgrade upgrade = upList.get(upIndex);
        String currency = upgrade.getCurrency();
        return currency;
     }
  
     public static int getUpgradeAmt(int upIndex) {
        Office office = officeList.get(0);
        List<Upgrade> upList = office.getUpgrade();
        Upgrade upgrade = upList.get(upIndex);
        int amt = upgrade.getAmt();
        return amt;
     }
  
     public static Area getUpgradeArea(int upIndex) {
        Office office = officeList.get(0);
        List<Upgrade> upList = office.getUpgrade();
        Upgrade upgrade = upList.get(upIndex);
        Area area = upgrade.getArea();
        int x = area.getX();
        int y = area.getY();
        int h = area.getH();
        int w = area.getW();
        return area;
     }
    
}
