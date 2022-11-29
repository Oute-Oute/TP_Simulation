package main.java.event;

import main.java.Controller;
import main.java.Event;
import main.java.Scheduler;

public class ArriveeBus extends Event {

    /**
     * Instantiates a new main.java.Event.
     *
     * @param startingTime the starting time
     */
    public ArriveeBus(double startingTime) {
        super(startingTime);
    }

    @Override
    public void run() {
        // Insérer dans l'échéancier un événement ArrivéeBus à l'instant DateSimu + E(1/2
        // Incrémenter le nombre de bus (NbBus ←− NbBus + 1)
        // Insérer dans l'échéancier un événement ArrivéeFileC à l'instant DateSimu

        Scheduler.getInstance().addEvent(new ArriveeBus(Scheduler.getInstance().getCurrentTime() + Scheduler.getInstance().generateRandomExponentialNumber(0.5)));

        Controller.getInstance().setNbBusEntres(Controller.getInstance().getNbBusEntres()+1);

        Scheduler.getInstance().addEvent(new ArriveeFileC(Scheduler.getInstance().getCurrentTime()));


    }
}
