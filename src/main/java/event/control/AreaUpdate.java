package main.java.event.control;

import main.java.Controller;

public class AreaUpdate {
public void areaUpdate(float D2, float D1) {
    int occupation =0;
    if (Controller.getInstance().getPostesReparations().get(0).isFree()) {
        occupation++;
    }
    if (Controller.getInstance().getPostesReparations().get(1).isFree()) {
        occupation++;
    }

    Controller.getInstance().setControlQueueArea(Controller.getInstance().getControlQueueArea() + (D2 - D1) * Controller.getInstance().getPosteControle().getQueue());
    Controller.getInstance().setRepairQueueArea(Controller.getInstance().getRepairQueueArea() + (D2 - D1) * (Controller.getInstance().getPostesReparations().get(0).getQueue()+Controller.getInstance().getPostesReparations().get(1).getQueue()));

    Controller.getInstance().setOccupationArea(Controller.getInstance().getOccupationArea() + (D2 - D1) * occupation);
    }

}

