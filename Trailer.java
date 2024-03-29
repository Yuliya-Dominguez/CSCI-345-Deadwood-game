//Singleton class that provides instances of the data (for trailer) from board.xml
import java.util.ArrayList;
import java.util.List;

public class Trailer {
    private List<Neighbors> neighbors;
    private Area area;
    
    private static Trailer instance = null;

    Trailer() {
        this.neighbors = new ArrayList<Neighbors>();
    }
  
    public static Trailer getInstance() {
        if (instance == null) {
            instance = new Trailer();
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
