import event.control.Debut;
import event.Event;
import java.util.ArrayList;


/**
 * The type Scheduler.
 */
public final class Scheduler {
    private static Scheduler SchedulerInstance = new Scheduler();
    private ArrayList<Event> incomingEvent = new ArrayList();
    private float currentTime = 0;

    private Scheduler() {
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

    /**
     * Gets current time.
     *
     * @return the current time
     */
    public float getCurrentTime() {
        return this.currentTime;
    }

    /**
     * Gets the number of event.
     *
     * @return the number of event
     */
    public int getNbEvent() {
        return this.incomingEvent.size();
    }

    /**
     * Add an event to the incomingEvent arraylist.
     *
     * @param event the event to add.
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
     * Start the event when their starting time is the same as the current time.
     *
     * @param currentTime the current time
     * @throws InterruptedException the interrupted exception
     */
    public void startingEvent(float currentTime) throws InterruptedException {
        int i = 0;

        while (i < SchedulerInstance.getNbEvent() && SchedulerInstance.incomingEvent.get(i).getStartingTime() <= currentTime) {
            SchedulerInstance.incomingEvent.get(i).run();
            SchedulerInstance.incomingEvent.remove(i);
        }
    }

    /**
     * Pass the time in the simulation
     *
     * @throws InterruptedException the interrupted exception
     */
    public void passingTime() throws InterruptedException {
        getInstance().incomingEvent.add(new Debut(getInstance().currentTime));
        while (getInstance().getNbEvent() != 0) {
            getInstance().startingEvent(getInstance().getCurrentTime());
            //TODO: màj des aires
                float date = getInstance().incomingEvent.get(0).getStartingTime();
            getInstance().setCurrentTime(date);
        }
    }

    /**
     * Start the simulation
     *
     * @throws InterruptedException the interrupted exception
     */
    public static void start() throws InterruptedException {
        getInstance().passingTime();
    }

    /**
     * Sets current time.
     *
     * @param currentTime the current time
     */
    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
    }

}
