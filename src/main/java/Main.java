package main.java;
import main.java.event.control.AreaUpdate;
import main.java.event.control.DebutSimulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

    private static void Execute(StringBuilder sb) {
        Scheduler scheduler = Scheduler.getInstance();
        AreaUpdate areaUpdate = new AreaUpdate();
        scheduler.addEvent(new DebutSimulation(0));
        while(scheduler.getNbEvent() > 0) {
            Event event = scheduler.getNextEvent();
            areaUpdate.areaUpdate(scheduler.getCurrentTime(), event.getStartingTime());
            scheduler.setCurrentTime(event.getStartingTime());
            event.run();
        }
        double meanWaitingTimeBeforeControl = Controller.getInstance().getControlQueueArea()/ (Controller.getInstance().getNbBusEntres()-Controller.getInstance().getQueueC());
        double meanWaitingTimeBeforeReparation = Controller.getInstance().getRepairQueueArea()/(Controller.getInstance().getNbBusRepares()-Controller.getInstance().getQueueR());
        double ReparationCenterUseRate = Controller.getInstance().getOccupationArea()/(2*Scheduler.getInstance().getCurrentTime());

        sb.append(meanWaitingTimeBeforeControl);
        sb.append(',');

        sb.append(meanWaitingTimeBeforeReparation);
        sb.append(',');

        sb.append(ReparationCenterUseRate);
        sb.append(',');
        sb.append('\n');

        Scheduler.getInstance().cleanScheduler();
        Controller.getInstance().cleanController();
    }
    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(new File("test.csv"))) {
            StringBuilder sb = new StringBuilder();

            sb.append("temps avant controle");
            sb.append(',');
            sb.append("temps avant réparation");
            sb.append(',');
            sb.append("taux d'utilisation du poste de contrôle");
            sb.append('\n');

            for (int i = 0; i < 100; i++) {
                Execute(sb);
            }
            writer.write(sb.toString());
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}