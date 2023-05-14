import java.util.ArrayList;
import java.util.List;

public class Set {
    private String setName;
    private List<Neighbors> neighbors;
    private Area area;
    private List<Takes> takes;
    private List<Parts> parts;

    private static Set instance = null;//

    Set(String setName) {
      this.setName = setName;
      this.neighbors = new ArrayList<Neighbors>();
      this.takes = new ArrayList<Takes>();
      this.parts = new ArrayList<Parts>();
    }

    public static Set getInstance(String setName) {
      if (instance == null) {
          instance = new Set(setName);
      }
      return instance;
    }

    public void setSetName(String setName) {
      this.setName = setName;
    }

    public String getSetName() {
        return setName;
    }//

    public void addNeighbors(Neighbors neighbors) {
      this.neighbors.add(neighbors);
    }

    public List<Neighbors> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Neighbors> neighbors) {
        this.neighbors = neighbors;
    }//

    public void addTakes(Takes takes) {
      this.takes.add(takes);
    }

    public List<Takes> getTakes() {
        return takes;
    }

    public void setTakes(List<Takes> takes) {
        this.takes = takes;
    }//

    public void addPart(Parts part) {
      this.parts.add(part);
    }

    public List<Parts> getParts() {
        return parts;
    }

    public void setParts(List<Parts> parts) {
        this.parts = parts;
    }

    public Area getArea() {
      return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
