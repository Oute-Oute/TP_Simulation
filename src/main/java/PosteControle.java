package main.java;

public class PosteControle {
    private Boolean free;
    private final int id;

    private int queue;



    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public PosteControle(int id) {
        this.id = id;
        this.free = true;
    }

    public Boolean isFree() {
        return this.free;
    }

    public void setFree(Boolean isFree) {
        this.free = free;
    }

    public int getId() {
        return this.id;
    }

}
