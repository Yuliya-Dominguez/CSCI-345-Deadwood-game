import java.util.ArrayList;
import java.util.List;


public class Location {
    public String locationName;
    public String[] neighbors;
    private int boardNumber;
    public int takeCounters;
    List<Location.Scene> parts = new ArrayList<Location.Scene>();


    public class Scene {
      public String partName;
      public int partLevel;
    }
}
