package main.java;
import main.java.event.control.AreaUpdate;
import main.java.event.control.DebutSimulation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    static FileWriter output;

    static {
        try {
            output = new FileWriter(new File("output.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Main() throws IOException {
    }

    public static ArrayList<Double> moyennes(ArrayList<ArrayList<Double>> datas) {
        ArrayList<Double> moyennes = new ArrayList<>();

        for(int i = 0; i < datas.get(0).size(); i++) {
            double sum = 0;
            for(int j = 0; j < datas.size(); j++) {
                sum += datas.get(j).get(i);
            }
            moyennes.add(sum / datas.size());
        }

        ;
        return moyennes;
    }

    public static ArrayList<Double> moyennesLissees(ArrayList<Double> moyennes, int w){
        double yW=0;
        ArrayList<Double> moyennesLissees = new ArrayList<Double>();
        for (int i = 0; i < moyennes.size(); i++) {
            if (i<w){
                for(int j=-(i-1);j<i;j++){
                    yW+=moyennes.get(i+j);
                }
                yW=yW/(2*i-1);
                moyennesLissees.add(yW);
            }
            if(w+1<=i && i<=moyennes.size()-w){
                for(int j=-w;j<w;j++){
                    yW+=moyennes.get(i+j);
                }
                yW=yW/(2*w-1);
                moyennesLissees.add(yW);
            }
        }
        return moyennesLissees;
    }
    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<Double>> datas = new ArrayList<ArrayList<Double>>();
        for(int i=0;i<100;i++){
            Scheduler scheduler = Scheduler.getInstance();
            AreaUpdate areaUpdate = new AreaUpdate();
            scheduler.addEvent(new DebutSimulation(0));
            while(scheduler.getNbEvent() > 0) {
                Event event = scheduler.getNextEvent();
                areaUpdate.areaUpdate(scheduler.getCurrentTime(), event.getStartingTime());
                scheduler.setCurrentTime(event.getStartingTime());
                event.run();
            }
            datas.add(Scheduler.getInstance().getDataByColumns());
            scheduler.resetScheduler();
            Controller.getInstance().cleanController();
        }
        ArrayList<Double> moyennes = moyennes(datas);
        ArrayList<Double> moyennesLissees = moyennesLissees(moyennes, 1);
        System.out.println(moyennesLissees);

        for(int i=0; i<moyennesLissees.size(); i++) {
            output.write(i + ";" + moyennesLissees.get(i));
            output.write("\n");
        }




    }
}