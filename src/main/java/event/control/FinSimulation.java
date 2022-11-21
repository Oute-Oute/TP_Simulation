package main.java.event.control;



import main.java.Event;
import main.java.Scheduler;

public class FinSimulation extends Event {
    /**
     * Instantiates a new main.java.Event.
     *
     * @param startingTime the starting time
     */
    public FinSimulation(float startingTime) {
        super(startingTime);
    }

    @Override
    public void run() {
        Scheduler.getInstance().cleanScheduler();
    }
}
