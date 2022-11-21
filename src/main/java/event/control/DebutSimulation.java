package main.java.event.control;


import main.java.Event;
import main.java.Scheduler;

public class DebutSimulation extends Event {

    public DebutSimulation(float startingTime) {
        super(startingTime);
    }

    @Override
    public void run() {
        // TODO: arrivée bus à Date Simu + exp(1/2)
        Scheduler.getInstance().addEvent(new FinSimulation(160));
    }

}
