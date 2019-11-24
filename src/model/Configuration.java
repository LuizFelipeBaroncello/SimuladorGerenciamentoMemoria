package model;

public class Configuration{

    private int memorySize;
    private int pageSize;
    private int maxSizeProcess;

    public Configuration(int pageSize, int maxSizeProcess, int memorySize) {
        this.memorySize = memorySize;
        this.pageSize = pageSize;
        this.maxSizeProcess = maxSizeProcess;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getMaxSizeProcess() {
        return maxSizeProcess;
    }

}
