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
        float meanWaitingTimeBeforeControl = Controller.getControllerInstance().getControlQueueArea()/ Controller.getControllerInstance().getNbBusEntres();
        float meanWaitingTimeBeforeReparation = Controller.getControllerInstance().getRepairQueueArea()/Controller.getControllerInstance().getNbBusRepares();
        float ReparationCenterUseRate =Controller.getControllerInstance().getOccupationArea()/(2*160);
    }
}
