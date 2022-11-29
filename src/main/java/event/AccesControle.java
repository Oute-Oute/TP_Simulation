package main.java.event;

import main.java.Controller;
import main.java.Event;
import main.java.Scheduler;

public class AccesControle  extends Event {
    /**
     * Instantiates a new main.java.Event.
     *
     * @param startingTime the starting time
     */
    public AccesControle(float startingTime) {
        super(startingTime);
    }

    @Override
    public void run() {
        //Décrémenter le nombre de bus dans la File C (QC ←− QC − 1)
        

    }
}
