package main.java;

import java.util.ArrayList;

public class Controller {
    private static Controller controllerInstance;

    private PosteControle posteControle;
    private ArrayList<PosteReparation> postesReparations;
    private int nbBusEntres, nbBusRepares;

    private Controller() {
        this.posteControle = new PosteControle(1);
        this.postesReparations = new ArrayList<>();

        this.postesReparations.add(new PosteReparation(1));
        this.postesReparations.add(new PosteReparation(2));

        this.nbBusEntres = 0;
        this.nbBusRepares = 0;
    }

    public static Controller getInstance() {
        if (controllerInstance == null) {
            controllerInstance = new Controller();
        }
        return controllerInstance;
    }
}
