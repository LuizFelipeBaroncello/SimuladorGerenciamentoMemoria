package model;

public class MemoryManagementUnit {
    
    private Configuration configuration;
    private Memory memory;

    public  MemoryManagementUnit(int boardSize, int maxSizeProcess, int memorySize) {
        this.createConfiguration(boardSize, maxSizeProcess, memorySize)
            .createMemory(memorySize, boardSize);
    }

    private MemoryManagementUnit createMemory(int memorySize, int boadSize) {
        this.memory = new Memory(memorySize, boadSize);
        return this;
    }

    private MemoryManagementUnit createConfiguration(int boardSize, int maxSizeProcess, int memorySize) {
        this.configuration = new Configuration(boardSize, maxSizeProcess, memorySize);
        return this;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public MemoryManagementUnit setConfiguration(Configuration configuration) {
        this.configuration = configuration;
        return this;
    }

    public Memory getMemory() {
        return memory;
    }

    public MemoryManagementUnit setMemory(Memory memory) {
        this.memory = memory;
        return this;
    }

}
