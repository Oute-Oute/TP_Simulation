package main.java;
import main.java.event.control.AreaUpdate;
import main.java.event.control.DebutSimulation;

public class Main {
    public static void main(String[] args) {
        Scheduler scheduler = Scheduler.getInstance();
        AreaUpdate areaUpdate = new AreaUpdate();
        scheduler.addEvent(new DebutSimulation(0));
        while(scheduler.getNbEvent() > 0) {
            Event event = scheduler.getNextEvent();
            areaUpdate.areaUpdate(scheduler.getCurrentTime(), event.getStartingTime());
            scheduler.setCurrentTime(event.getStartingTime());
            event.run();
        }
    }
}