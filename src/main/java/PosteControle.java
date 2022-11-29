package main.java;

public class PosteControle {
    private Boolean free;
    private final int id;

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
