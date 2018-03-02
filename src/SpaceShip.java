/**
 * This interface defines the status of the spaceship.
 */
public interface SpaceShip {

    /**
     * Return the status of the rocket launch.
     *
     * @return true if the launch was succeeded.
     */
    boolean launch();

    /**
     * Return the status of the rocket landing.
     *
     * @return true if the landing was succeeded.
     */
    boolean land();

    /**
     * Return the status of the rocket carry.
     *
     * @param item the rocket cargo {@link Item} object, which includes the name and weight of the item.
     * @return true if the rocket can carry the item.
     */
    boolean canCarry(Item item);

    /**
     * Return the current weight of the rocket after loading the item that pass in.
     *
     * @param item the rocket cargo {@link Item} object, which includes the name and weight of the item.
     * @return the current weight of the rocket.
     */
    int carry(Item item);
}
