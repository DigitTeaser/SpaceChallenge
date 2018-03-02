/**
 * This class defines the U-2 type of rocket.
 */
public class U2 extends Rocket {

    /**
     * Defines the U-2 rocket by setting the following parameters:
     * 1. Rocket cost: 120 million dollars
     * 2. Rocket own weight: 18,000 kg
     * 3. Rocket maximum weight (including its own weight): 29,000 kg
     * 4. Fail percentage of rocket launch: 4 %
     * 5. Fail percentage of rocket landing: 8 %
     */
    public U2() {
        this.cost = 120;
        this.weight = 18000;
        this.maxWeight = 29000;
        this.launchFailPercentage = 4;
        this.landingFailPercentage = 8;
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