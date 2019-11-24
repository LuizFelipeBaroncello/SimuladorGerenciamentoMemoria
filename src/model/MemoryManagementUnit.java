package model;

public class MemoryManagementUnit {
    
    private Configuration configuration;
    private Memory memory;
    private TablePage tablePage;


    public  MemoryManagementUnit(int pageSize, int maxSizeProcess, int memorySize){
        this.createConfiguration(pageSize, maxSizeProcess, memorySize)
            .createMemory();
    }

    public MemoryManagementUnit createMemory() {
        this.memory = memory;
        return this;
    }

    public MemoryManagementUnit createConfiguration(int pageSize, int maxSizeProcess, int memorySize) {
        this.configuration = new Configuration(pageSize, maxSizeProcess, memorySize);
        return this;
    }

    public MemoryManagementUnit setTablePage(TablePage tablePage) {
        this.tablePage = tablePage;
        return this;
    }
}
