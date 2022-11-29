package main.java.event.control;



import main.java.Controller;
import main.java.Event;
import main.java.Scheduler;

public class FinSimulation extends Event {

    /**
     * Instantiates a new main.java.Event.
     *
     * @param startingTime the starting time
     */
    public FinSimulation(double startingTime) {
        super(startingTime);
    }

    @Override
    public void run() {
        Scheduler.getInstance().cleanScheduler();
        double meanWaitingTimeBeforeControl = Controller.getInstance().getControlQueueArea()/ Controller.getInstance().getNbBusEntres();
        double meanWaitingTimeBeforeReparation = Controller.getInstance().getRepairQueueArea()/Controller.getInstance().getNbBusRepares();
        double ReparationCenterUseRate =Controller.getInstance().getOccupationArea()/(2*getStartingTime());
        System.out.println("Mean waiting time before control: " + meanWaitingTimeBeforeControl);
        System.out.println("Mean waiting time before reparation: " + meanWaitingTimeBeforeReparation);
        System.out.println("Reparation center use rate: " + ReparationCenterUseRate);
    }
}
