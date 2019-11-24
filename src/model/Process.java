package model;

public class Process {

    private int size;
    private String id;
    
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

    public Process setId(String id) {
        this.id = id;
        return this;
    }
    public Process setSize(int size) {
        this.size = size;
        return this;
    }

}
