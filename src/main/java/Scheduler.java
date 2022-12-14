package main.java;


import main.java.event.control.AreaUpdate;
import main.java.event.control.DebutSimulation;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.log;


/**
 * The type main.java.Scheduler.
 */
public final class Scheduler {
    private static Scheduler SchedulerInstance;
    private final ArrayList<Event> incomingEvent;
    private double currentTime;

    private double welchTime;

    private ArrayList<Double> dataByColumns = new ArrayList<Double>();


    private Scheduler() {
        this.incomingEvent = new ArrayList<>();
        this.currentTime = 0;
        this.welchTime = 0;
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Scheduler getInstance() {
        if (SchedulerInstance == null) {
            SchedulerInstance = new Scheduler();
        }

        return SchedulerInstance;
    }


    public static double generateRandomUniformNumber(double min, double max) {
        Random r = new Random();
        return min + r.nextDouble() * (max - min);
    }

    public static double generateRandomExponentialNumber(double lambda) {
        Random r = new Random();
        return -(1 / lambda) * log(1 - r.nextDouble());

    }

    /**
     * Gets current time.
     *
     * @return the current time
     */
    public double getCurrentTime() {
        return this.currentTime;
    }

    /**
     * Sets current time.
     *
     * @param currentTime the current time
     */
    public void setCurrentTime(double currentTime) {
        this.currentTime = currentTime;
    }

    public double getWelchTime() {
        return this.welchTime;
    }

    public void setWelchTime(double welchTime) {
        this.welchTime = welchTime;
    }

    public ArrayList<Double> getDataByColumns() {
        return this.dataByColumns;
    }



    /**
     * Gets the number of main.java.event.
     *
     * @return the number of main.java.event
     */
    public int getNbEvent() {
        return this.incomingEvent.size();
    }

    /**
     * Add an main.java.event to the incomingEvent arraylist.
     *
     * @param event the main.java.event to add.
     */
    public void addEvent(Event event) {
        if (SchedulerInstance.incomingEvent.isEmpty()) {
            SchedulerInstance.incomingEvent.add(event);
        } else {
            boolean found = false;

            int i;
            for (i = 0; i < SchedulerInstance.incomingEvent.size() && !found; ++i) {
                if (event.getStartingTime() < SchedulerInstance.incomingEvent.get(i).getStartingTime()) {
                    SchedulerInstance.incomingEvent.add(i, event);
                    found = true;
                }
            }

            if (i == this.incomingEvent.size() && !found) {
                this.incomingEvent.add(i, event);
            }
        }

    }

    /**
     * Start the main.java.event when their starting time is the same as the current time.
     *
     * @param currentTime the current time
     */
    public void startingEvent(float currentTime) {
        int i = 0;

        while (i < SchedulerInstance.getNbEvent() && SchedulerInstance.incomingEvent.get(i).getStartingTime() <= currentTime) {
            SchedulerInstance.incomingEvent.get(i).run();
            SchedulerInstance.incomingEvent.remove(i);
        }
    }

    public void cleanScheduler() {
        SchedulerInstance.incomingEvent.clear();
    }

    public Event getNextEvent() {
        Event event = SchedulerInstance.incomingEvent.get(0);
        if(event.getStartingTime()>getWelchTime()+1) {
            setWelchTime(event.getStartingTime());
            dataByColumns.add(event.getStartingTime());

        }
        SchedulerInstance.incomingEvent.remove(0);
        return event;
    }

    /**
     * Sets current time.
     *
     * @param currentTime the current time
     */
    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
    }

    public void resetScheduler() {
        SchedulerInstance.incomingEvent.clear();
        SchedulerInstance.currentTime = 0;
        SchedulerInstance.welchTime = 0;
    }
}