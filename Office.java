import java.util.ArrayList;
import java.util.List;

public class Office {
    private List<Neighbors> neighbors;
    private Area area;
    private List<Upgrade> upgrades;
    
    private static Office instance = null;

    Office() {
        this.neighbors = new ArrayList<Neighbors>();
        this.upgrades = new ArrayList<Upgrade>();
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

    public void addUpgrade(Upgrade upgrade) {
        this.upgrades.add(upgrade);
      }
  
      public List<Upgrade> getUpgrade() {
          return upgrades;
      }
  
      public void setUpgrade(List<Upgrade> upgrades) {
          this.upgrades = upgrades;
      }
}
