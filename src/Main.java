public class Main {

    public static void main(String[] args) {

        Simulation simulation = new Simulation();

        int totalCostForU1 =
                simulation.runSimulation(simulation.loadRocket(new U1(), simulation.loadItems("phase-1.txt"))) +
                simulation.runSimulation(simulation.loadRocket(new U1(), simulation.loadItems("phase-2.txt")));
        int totalCostForU2 =
                simulation.runSimulation(simulation.loadRocket(new U2(), simulation.loadItems("phase-1.txt"))) +
                simulation.runSimulation(simulation.loadRocket(new U2(), simulation.loadItems("phase-2.txt")));

        System.out.println("The total cost of phase one and phase two for U-1 rocket is " +
                totalCostForU1 + " million dollars.");
        System.out.println("The total cost of phase one and phase two for U-2 rocket is " +
                totalCostForU2 + " million dollars.");
    }
}
