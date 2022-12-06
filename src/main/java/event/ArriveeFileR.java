package main.java.event;

import main.java.Controller;
import main.java.Event;
import main.java.Scheduler;

public class ArriveeFileR extends Event {

    public ArriveeFileR(double startingTime) {
        super(startingTime);
    }
    /**
     * The run method.
     * Will be defined in every main.java.event class to run each main.java.event.
     */
    @Override
    public void run() {
        Controller.getInstance().setQueueR(Controller.getInstance().getQueueR() + 1);
        if (Controller.getInstance().getPostesReparations().get(0).isFree() || Controller.getInstance().getPostesReparations().get(1).isFree()) {
            Scheduler.getInstance().addEvent(new AccesReparation(Scheduler.getInstance().getCurrentTime()));
        }
    }
}