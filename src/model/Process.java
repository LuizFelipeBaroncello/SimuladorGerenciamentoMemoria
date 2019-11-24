package model;

public class Process {

    private int length;
    private int id;
    
    public Process(int id, int length){
        this.id = id;
        this.length = length;
    }

    public int getId() {
        return this.id;
    }
    public int getLength() {
        return this.length;
    }

    public Process setId(int id) {
        this.id = id;
        return this;
    }
    public Process setLength(int length) {
        this.length = length;
        return this;
    }

}
