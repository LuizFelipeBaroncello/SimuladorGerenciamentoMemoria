public class MemoryPosition {

    private boolean used;

    public MemoryPosition() {
        this.used = false;
    }

    public boolean isUsed() {
        return this.used;
    }

    public MemoryPosition setUsed() {
        this.used = true;
        return this;
    }

    public MemoryPosition unUsed() {
        this.used = false;
        return this;
    }

}
