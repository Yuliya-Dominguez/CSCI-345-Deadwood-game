//Encapsulates parts' data taken from xml files
public class Parts {
    private String name;
    private int level;
    private Area area;
    private String line;

    public Parts(String name, int level, Area area, String line) {
        this.name = name;
        this.level = level;
        this.area = area;
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}