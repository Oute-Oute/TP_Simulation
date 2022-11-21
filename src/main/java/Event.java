package main.java;

/**
 * The type main.java.Event.
 */
public abstract class Event {
    private final float startingTime;

    /**
     * Instantiates a new main.java.Event.
     *
     * @param startingTime the starting time
     */
    public Event(float startingTime) {
        this.startingTime = startingTime;
    }

    /**
     * Gets starting time.
     *
     * @return the starting time
     */
    public float getStartingTime() {
        return startingTime;
    }

    /**
     * The run method.
     * Will be defined in every main.java.event class to run each main.java.event.
     */
    public abstract void run();
}
