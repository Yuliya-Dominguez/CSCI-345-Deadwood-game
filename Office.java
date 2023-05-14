import java.util.ArrayList;
import java.util.List;

public class Office {
    private List<Neighbors> neighbors;
    private Area area;
    
    private static Office instance = null;

    Office() {
        this.neighbors = new ArrayList<Neighbors>();
    }
  
    public static Office getInstance() {
        if (instance == null) {
            instance = new Office();
        }
    return instance;
    }

    public void addNeighbors(Neighbors neighbors) {
        this.neighbors.add(neighbors);
      }
  
    public List<Neighbors> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Neighbors> neighbors) {
        this.neighbors = neighbors;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
