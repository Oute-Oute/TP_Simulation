package main.java;

public class PosteReparation {
    private Boolean isFree;
    private final int id;

    public PosteReparation(int id) {
        this.id = id;
        this.isFree = true;
    }

    public Boolean getIsFree() {
        return this.isFree;
    }

    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    public int getId() {
        return this.id;
    }

}
