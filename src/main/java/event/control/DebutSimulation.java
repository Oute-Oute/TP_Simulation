package main.java.event.control;


import main.java.Controller;
import main.java.Event;
import main.java.Scheduler;
import main.java.event.ArriveeBus;

public class DebutSimulation extends Event {

    public DebutSimulation(double startingTime) {
        super(startingTime);
    }

    @Override
    public void run() {
        // TODO: arrivée bus à Date Simu + exp(1/2)
        Controller.getInstance().getPostesReparations().get(0).setIsFree(true);
        Controller.getInstance().getPostesReparations().get(1).setIsFree(true);
        Controller.getInstance().getPosteControle().setFree(true);
        Controller.getInstance().setQueueC(0);
        Controller.getInstance().setQueueR(0);
        Scheduler.getInstance().addEvent(new ArriveeBus(Scheduler.getInstance().getCurrentTime() + Scheduler.generateRandomExponentialNumber(0.75)));
        Scheduler.getInstance().addEvent(new FinSimulation(160));

    }

}
