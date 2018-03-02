import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulation {

    /**
     * Loads rocket cargo items from files.
     *
     * @param phase is the file name string that needs to load.
     * @return the rocket cargo item list.
     */
    public List<Item> loadItems(String phase) {
        List<Item> cargoList = new ArrayList<>();
        try {
            // Read the cargo list file and get a file scanner.
            File file = new File("res/" + phase);
            Scanner scanner = new Scanner(file);

            // Add all the cargo list item to the ArrayList.
            while (scanner.hasNextLine()) {
                String currentItem = scanner.nextLine();
                String[] currentItemParts = currentItem.split("=");
                cargoList.add(new Item(currentItemParts[0], currentItemParts[1]));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No cargo list file found.");
        }

        return cargoList;
    }

    /**
     * Loads rocket lists to list according to the cargo list.
     *
     * @param rocket   can be U-1 or U-2 type of rocket that takes the mission.
     * @param itemList is the rocket cargo list.
     * @return the rocket list that launch with all the cargo.
     */
    public List<Rocket> loadRocket(Rocket rocket, List<Item> itemList) {
        List<Rocket> rocketList = new ArrayList<>();

        for (Item item : itemList) {
            // If this rocket can not load more cargo, add it to the list and use a new rocket.
            if (!rocket.canCarry(item)) {
                rocketList.add(rocket);
                rocket = new U1();
            }

            rocket.carry(item);
        }

        // Add the last rocket to the list.
        rocketList.add(rocket);

        return rocketList;
    }

    /**
     * Runs simulation with the rocket list considering the fail percentage of launch and landing.
     *
     * @param rocketList is the rocket list that launch with all the cargo.
     * @return the total cost of the mission.
     */
    public int runSimulation(List<Rocket> rocketList) {
        int rocketNumber = rocketList.size();

        for (int i = 0; i < rocketList.size(); i++) {
            // If the launch or the landing fails, try this rocket one more time and add one to the rocket number.
            if (!rocketList.get(i).launch() || !rocketList.get(i).land()) {
                i--;
                rocketNumber++;
            }
        }

        return rocketNumber * rocketList.get(0).cost;
    }
}
