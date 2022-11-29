package main.java.event.control;



import main.java.Controller;
import main.java.Event;
import main.java.Scheduler;

import javax.naming.ldap.Control;

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
        float meanWaitingTimeBeforeControl = Controller.getInstance().getControlQueueArea()/ Controller.getInstance().getNbBusEntres();
        float meanWaitingTimeBeforeReparation = Controller.getInstance().getRepairQueueArea()/Controller.getInstance().getNbBusRepares();
        float ReparationCenterUseRate =Controller.getInstance().getOccupationArea()/(2*160);
    }
}
