package project;

public class MemoryManagement {
    private static final int TOTAL_MEMORY = 1024; // MB
    private static final int REAL_TIME_MEMORY_LIMIT = 64; // MB
    private static final int USER_MEMORY_LIMIT = TOTAL_MEMORY - REAL_TIME_MEMORY_LIMIT;

    private int availableUserMemory; // Toplam kullanıcı belleği
    private int availableRealTimeMemory; // Gerçek zamanlı prosesler için ayrılan bellek

    public MemoryManagement() {
        this.availableUserMemory = USER_MEMORY_LIMIT;
        this.availableRealTimeMemory = REAL_TIME_MEMORY_LIMIT;
    }

    // Kullanıcı prosesine bellek tahsis et
    public boolean allocateUserMemory(Process process) {
        if (process.getPriority() == 0 && process.getRunTime() <= availableUserMemory) {
            availableUserMemory -= process.getRunTime();
            process.setMemoryAllocated(process.getRunTime());
            return true;
        }
        return false;
    }

    // Gerçek zamanlı proseslere bellek tahsis et
    public boolean allocateRealTimeMemory(Process process) {
        if (process.getPriority() == 1 && process.getRunTime() <= availableRealTimeMemory) {
            availableRealTimeMemory -= process.getRunTime();
            process.setMemoryAllocated(process.getRunTime());
            return true;
        }
        return false;
    }

    // Belleği serbest bırak
    public void deallocateMemory(Process process) {
        if (process.getPriority() == 0) {
            availableUserMemory += process.getMemoryAllocated();
        } else if (process.getPriority() == 1) {
            availableRealTimeMemory += process.getMemoryAllocated();
        }
        process.setMemoryAllocated(0);
    }
}
