import java.util.ArrayList;
import java.util.List;

public class Set {
    public String cardName;
    public int budget;
    private int sceneNumber;
    List<Set.Part> parts = new ArrayList<Set.Part>();

    //ArrayList here for object Part()


    public class Part {
      public String partName;
      public int partLevel;
    }
}
