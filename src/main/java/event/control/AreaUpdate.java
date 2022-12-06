package main.java.event.control;

import main.java.Controller;

public class AreaUpdate {
public void areaUpdate(double D1, double D2) {
    int occupation =0;
    if (!Controller.getInstance().getPostesReparations().get(0).isFree()) {
        occupation++;
    }
    if (!Controller.getInstance().getPostesReparations().get(1).isFree()) {
        occupation++;
    }

    Controller.getInstance().setControlQueueArea(
            Controller.getInstance().getControlQueueArea() + ((D2 - D1) * Controller.getInstance().getQueueC()));
    Controller.getInstance().setRepairQueueArea(
            Controller.getInstance().getRepairQueueArea() + ((D2 - D1) * Controller.getInstance().getQueueR()));

    Controller.getInstance().setOccupationArea(Controller.getInstance().getOccupationArea() + ((D2 - D1) * occupation));
    }

}

