package model;

public class Configuration{

    private int memorySize;
    private int boardSize;
    private int maxSizeProcess;

    public Configuration(int boardSize, int maxSizeProcess, int memorySize) {
        this.memorySize = memorySize;
        this.boardSize = boardSize;
        this.maxSizeProcess = maxSizeProcess;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int getMaxSizeProcess() {
        return maxSizeProcess;
    }

}
