public class Scene {
    private int number;
    private String description;

    public Scene(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}