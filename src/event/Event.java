package event;

/**
 * The type event.Event.
 */
public abstract class Event {
    private final float startingTime;

    /**
     * Instantiates a new event.Event.
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
     * Will be defined in every event class to run each event.
     */
    public abstract void run();
}
