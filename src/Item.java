/**
 * This class saves the name and weight of each rocket cargo item.
 */
public class Item {

    private String name, weight;

    public Item(String name, String weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getWeight() {
        return weight;
    }
}
