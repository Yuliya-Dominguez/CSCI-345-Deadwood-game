import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;

public class BoardData {

    private BoardXMLparser parser;//
    private static ArrayList<Set> setList;//
    private static int sceneIndex;

    public BoardData() {
        Document doc = null;
        parser = new BoardXMLparser();
        try {
            doc = parser.getDocFromFile("board.xml");
            setList = parser.readBoardData(doc);
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

     public static int getSceneIndex(int index) {
        sceneIndex = index;
        return sceneIndex;
     }
  
    /*private String name;
    private List<Set> sets;

    public BoardData(String name) {
        this.name = name;
        sets = new ArrayList<>();
    }
    
    public void addSet(Set set) {
        sets.add(set);
    }

    public List<Set> getSets() {
        return sets;
    }

    public void setSets(List<Set> sets) {
        this.sets = sets;
    }

    public String getBoardName() {
        return name;
    }

    public void setBoardName(String name) {
        this.name = name;
    }*/
}
