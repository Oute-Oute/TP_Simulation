package main.java.event;

import main.java.Controller;
import main.java.Event;
import main.java.Scheduler;

public class ArriveeFileC extends Event {

    /**
     * Instantiates a new main.java.Event.
     *
     * @param startingTime the starting time
     */
    public ArriveeFileC(float startingTime) {
        super(startingTime);
    }

    @Override
    public void run() {
        Controller.getControllerInstance().getPosteControle().setQueue(Controller.getControllerInstance().getPosteControle().getQueue() + 1);
        if (Controller.getControllerInstance().getPosteControle().isFree()){
            Scheduler.getInstance().addEvent(new AccesControle(Scheduler.getInstance().getCurrentTime()));
        }
    }
}
