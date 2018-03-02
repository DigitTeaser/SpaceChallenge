/**
 * This class defines the U-1 type of rocket.
 */
public class U1 extends Rocket {

    /**
     * Defines the U-1 rocket by setting the following parameters:
     * 1. Rocket cost: 100 million dollars
     * 2. Rocket own weight: 10,000 kg
     * 3. Rocket maximum weight (including its own weight): 18,000 kg
     * 4. Fail percentage of rocket launch: 5 %
     * 5. Fail percentage of rocket landing: 1 %
     */
    public U1() {
        this.cost = 100;
        this.weight = 10000;
        this.maxWeight = 18000;
        this.launchFailPercentage = 5;
        this.landingFailPercentage = 1;
    }

    /**
     * Return true when the rocket launch succeeded, according to the Fail percentage of rocket launch.
     */
    @Override
    public boolean launch() {
        return Math.random() > launchFailPercentage * 0.01 * weight / maxWeight;
    }

    /**
     * Return true when the rocket landing succeeded, according to the Fail percentage of rocket landing.
     */
    @Override
    public boolean land() {
        return Math.random() > landingFailPercentage * 0.01 * weight / maxWeight;
    }
}
