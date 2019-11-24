package model;

public class Process {

    private String id;
    private int size;

    public Process(String id, int size){
        this.id = id;
        this.size = size;
    }

    public String getId() {
        return this.id;
    }

    public int getSize() {
        return this.size;
    }

}
