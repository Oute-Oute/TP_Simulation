package main.java.event.control;

import main.java.Controller;
import main.java.Event;
import main.java.Scheduler;

public class AccesReparation extends Event {

    public AccesReparation(float startingTime) {
        super(startingTime);
    }

    @Override
    public void run() {
        Controller.getInstance().setQueueR(Controller.getInstance().getQueueR() - 1);
        if (Controller.getInstance().getPostesReparations().get(0).isFree()) {
            Controller.getInstance().getPostesReparations().get(0).setIsFree(false);
            Scheduler.getInstance().addEvent(new DepartReparation(Scheduler.getInstance().getCurrentTime() + Scheduler.generateRandomUniformNumber(2.1, 4.5)));
        } else {
            Controller.getInstance().getPostesReparations().get(1).setIsFree(false);
            Scheduler.getInstance().addEvent(new DepartReparation(Scheduler.getInstance().getCurrentTime() + Scheduler.generateRandomUniformNumber(2.1, 4.5)));
        }
    }

    //Procédure AccèsRéparation
    //1. Décrémenter le nombre de bus dans la File R (QR ←− QR − 1)
    //2. Réquisitionner un poste dans le centre de réparation (BR ←− BR + 1)
    //3. Insérer dans l'échéancier un événement DépartRéparation à l'instant DateSimu + U([2.1, 4.5])
}

