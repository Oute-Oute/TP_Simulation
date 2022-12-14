package main.java;

import java.util.ArrayList;

public class Controller {
    private static Controller controllerInstance;

    private PosteControle posteControle;
    private ArrayList<PosteReparation> postesReparations;

    private int nbBusEntres, nbBusRepares;

    //Areas
    private double controlQueueArea;
    private double repairQueueArea;
    private double occupationArea;

    private int queueC;

    private int queueR;

    private Controller() {
        this.posteControle = new PosteControle(1);
        this.postesReparations = new ArrayList<>();

        this.postesReparations.add(new PosteReparation(1));
        this.postesReparations.add(new PosteReparation(2));

        this.nbBusEntres = 0;
        this.nbBusRepares = 0;

        //Areas
        this.controlQueueArea = 0;
        this.repairQueueArea = 0;
        this.occupationArea = 0;


    }

    public static Controller getInstance() {
        if (controllerInstance == null) {
            controllerInstance = new Controller();
        }
        return controllerInstance;
    }

    public int getQueueR() {
        return queueR;
    }

    public void setQueueR(int queueR) {
        this.queueR = queueR;
    }

    public int getQueueC() {
        return queueC;
    }

    public void setQueueC(int queueC) {
        this.queueC = queueC;
    }

    public int getNbBusEntres() {
        return nbBusEntres;
    }

    public void setNbBusEntres(int nbBusEntres) {
        this.nbBusEntres = nbBusEntres;
    }

    public int getNbBusRepares() {
        return nbBusRepares;
    }

    public void setNbBusRepares(int nbBusRepares) {
        this.nbBusRepares = nbBusRepares;
    }

    public PosteControle getPosteControle() {
        return posteControle;
    }

    public void setPosteControle(PosteControle posteControle) {
        this.posteControle = posteControle;
    }

    public ArrayList<PosteReparation> getPostesReparations() {
        return postesReparations;
    }

    public void setPostesReparations(ArrayList<PosteReparation> postesReparations) {
        this.postesReparations = postesReparations;
    }

    public double getControlQueueArea() {
        return controlQueueArea;
    }

    public void setControlQueueArea(double controlQueueArea) {
        this.controlQueueArea = controlQueueArea;
    }

    public double getRepairQueueArea() {
        return repairQueueArea;
    }

    public void setRepairQueueArea(double repairQueueArea) {
        this.repairQueueArea = repairQueueArea;
    }

    public double getOccupationArea() {
        return occupationArea;
    }

    public void setOccupationArea(double occupationArea) {
        this.occupationArea = occupationArea;
    }

    public void cleanController() {
        Controller.getInstance().posteControle = new PosteControle(1);
        Controller.getInstance().postesReparations = new ArrayList<>();

        Controller.getInstance().postesReparations.add(new PosteReparation(1));
        Controller.getInstance().postesReparations.add(new PosteReparation(2));

        Controller.getInstance().nbBusEntres = 0;
        Controller.getInstance().nbBusRepares = 0;

        //Areas
        Controller.getInstance().controlQueueArea = 0;
        Controller.getInstance().repairQueueArea = 0;
        Controller.getInstance().occupationArea = 0;
    }
}

