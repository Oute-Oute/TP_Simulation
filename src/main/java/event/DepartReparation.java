package main.java.event;

import main.java.Controller;
import main.java.Event;
import main.java.Scheduler;

public class DepartReparation extends Event {

    public DepartReparation(double startingTime) {
        super(startingTime);
    }

    @Override
    public void run() {
        if(!Controller.getInstance().getPostesReparations().get(0).isFree()) {
            Controller.getInstance().setNbBusRepares(Controller.getInstance().getNbBusRepares() + 1);
            Controller.getInstance().getPostesReparations().get(0).setIsFree(true);
        } else {
            Controller.getInstance().getPostesReparations().get(1).setIsFree(true);
        }
        if(Controller.getInstance().getQueueR() > 0){
            Scheduler.getInstance().addEvent(new AccesReparation(Scheduler.getInstance().getCurrentTime()));
        }
    }
}