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
        //TODO attendre le change de l'etat du poste de controle
        Controller.getInstance().setNbBusEntres(Controller.getInstance().getNbBusEntres()-1);

        //Changer l'état du poste de contrôle (BC ←− OCCUPE)
        Controller.getInstance().getPosteControle().setFree(false);

        //Insérer dans l'échéancier un événement DépartContrôle à l'instant DateSimu + U([1/4, 13/12])
        //TODO changer starting time
        Scheduler.getInstance().addEvent(new DepartControle(Scheduler.getInstance().getCurrentTime() + 1/2));




    }
}
