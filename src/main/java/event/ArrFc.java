package main.java.event;

import main.java.Controller;
import main.java.Event;
import main.java.Scheduler;

public class ArrFc extends Event {

    /**
     * Instantiates a new main.java.Event.
     *
     * @param startingTime the starting time
     */
    public ArrFc(float startingTime) {
        super(startingTime);
    }

    @Override
    public void run() {
        //TODO aurélie suite 
        Controller.getControllerInstance().setControlQueueArea(Controller.getControllerInstance().getControlQueueArea() + 1);
        if (Controller.getControllerInstance().getPosteControle().isFree()){
            Scheduler.getInstance().addEvent();
        }
    }
}
