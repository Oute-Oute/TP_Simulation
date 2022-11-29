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
    public AccesControle(double startingTime) {
        super(startingTime);
    }

    @Override
    public void run() {
        //Décrémenter le nombre de bus dans la File C (QC ←− QC − 1)
        Controller.getInstance().setQueueC(Controller.getInstance().getQueueC() - 1);

        //Changer l'état du poste de contrôle (BC ←− OCCUPE)
        Controller.getInstance().getPosteControle().setFree(false);

        //Insérer dans l'échéancier un événement DépartContrôle à l'instant DateSimu + U([1/4, 13/12])
        //TODO changer starting time
        Scheduler.getInstance().addEvent(new DepartControle(Scheduler.getInstance().getCurrentTime() + Scheduler.generateRandomUniformNumber(1/4, 13/12)));

    }
}
