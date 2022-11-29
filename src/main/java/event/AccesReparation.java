package main.java.event;

import main.java.Controller;
import main.java.Event;
import main.java.Scheduler;

public class AccesReparation extends Event {

    public AccesReparation(double startingTime) {
        super(startingTime);
    }

    @Override
    public void run() {
        Controller.getInstance().setQueueR(Controller.getInstance().getQueueR() - 1);
        if (Controller.getInstance().getPostesReparations().get(0).isFree()) {
            Controller.getInstance().getPostesReparations().get(0).setIsFree(false);
            Scheduler.getInstance().addEvent(new DepartReparation(Scheduler.getInstance().getCurrentTime() + Scheduler.generateRandomUniformNumber(2.8, 5.5)));
        } else {
            Controller.getInstance().getPostesReparations().get(1).setIsFree(false);
            Scheduler.getInstance().addEvent(new DepartReparation(Scheduler.getInstance().getCurrentTime() + Scheduler.generateRandomUniformNumber(2.8, 5.5)));
        }
    }
}

