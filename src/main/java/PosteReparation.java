package main.java;

public class PosteReparation {
    private Boolean free;
    private final int id;

    private int queue;

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public PosteReparation(int id) {
        this.id = id;
        this.free = true;
    }

    public Boolean isFree() {
        return this.free;
    }

    public void setIsFree(Boolean isFree) {
        this.free = isFree;
    }

    public int getId() {
        return this.id;
    }

}
