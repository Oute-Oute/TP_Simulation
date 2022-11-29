package main.java;

import java.util.ArrayList;

public class Controller {
    private static Controller controllerInstance;

    private PosteControle posteControle;
    private ArrayList<PosteReparation> postesReparations;

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

    private int nbBusEntres, nbBusRepares;

    //Areas
    private float controlQueueArea;
    private float repairQueueArea;
    private float occupationArea;

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

    public static Controller getControllerInstance() {
        return controllerInstance;
    }

    public static void setControllerInstance(Controller controllerInstance) {
        Controller.controllerInstance = controllerInstance;
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

    public float getControlQueueArea() {
        return controlQueueArea;
    }

    public void setControlQueueArea(float controlQueueArea) {
        this.controlQueueArea = controlQueueArea;
    }

    public float getRepairQueueArea() {
        return repairQueueArea;
    }

    public void setRepairQueueArea(float repairQueueArea) {
        this.repairQueueArea = repairQueueArea;
    }

    public float getOccupationArea() {
        return occupationArea;
    }

    public void setOccupationArea(float occupationArea) {
        this.occupationArea = occupationArea;
    }
}
