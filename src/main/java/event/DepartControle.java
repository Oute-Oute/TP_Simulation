package main.java.event;

import main.java.Controller;
import main.java.Event;
import main.java.Scheduler;

public class DepartControle extends Event {
    /**
     * Instantiates a new main.java.Event.
     *
     * @param startingTime the starting time
     */
    public DepartControle(double startingTime) {
        super(startingTime);
    }

    @Override
    public void run() {
        Controller.getInstance().getPosteControle().setFree(true);
        if(Controller.getInstance().getQueueC() > 0){
            Scheduler.getInstance().addEvent(new AccesControle(Scheduler.getInstance().getCurrentTime()));
        }
        if(Math.random() < 0.3 ){
            Scheduler.getInstance().addEvent(new ArriveeFileR(Scheduler.getInstance().getCurrentTime()));
        }
    }
}
