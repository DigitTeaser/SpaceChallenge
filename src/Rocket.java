/**
 * This class implements interface {@link SpaceShip}'s methods and defines the rocket parameters.
 */
public class Rocket implements SpaceShip {

    /**
     * The cost for each rocket launch.
     */
    public int cost;

    /**
     * The weight of the rocket.
     * It starts off with the rocket own weight, and adds up as the rocket loads more cargoes.
     */
    public int weight;

    /**
     * The maximum weight of the rocket.
     * It includes the rocket own weight.
     */
    public int maxWeight;

    /**
     * Fail percentage of the rocket launch.
     */
    public int launchFailPercentage;

    /**
     * Fail percentage of the rocket landing.
     */
    public int landingFailPercentage;

    /**
     * Here always return true, meaning the rocket launch always succeed.
     * This method should be overridden by the subclass to get their launch status.
     */
    @Override
    public boolean launch() {
        return true;
    }

    /**
     * Here always return true, meaning the rocket landing always succeed.
     * This method should be overridden by the subclass to get their landing status.
     */
    @Override
    public boolean land() {
        return true;
    }

    /**
     * This method tells whether the rocket can load the cargo item or not.
     * It can not be overridden by any subclasses.
     *
     * @param item the rocket cargo {@link Item} object, which includes the name and weight of the item.
     * @return true when the rocket weight is less than the maximum weight.
     */
    @Override
    public final boolean canCarry(Item item) {
        return weight + Integer.valueOf(item.getWeight()) <= maxWeight;
    }

    /**
     * This method tells the rocket weight after loading the .
     * It can not be overridden by any subclasses.
     *
     * @param item the rocket cargo {@link Item} object, which includes the name and weight of the item.
     * @return the current weight of the rocket.
     */
    @Override
    public final int carry(Item item) {
        // Add the cargo item weight to the rocket weight and return it.
        weight += Integer.valueOf(item.getWeight());
        return weight;
    }
}
