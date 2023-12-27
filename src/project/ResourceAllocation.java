package project;

public class ResourceAllocation {
    private static final int PRINTER_COUNT = 2;
    private static final int SCANNER_COUNT = 1;
    private static final int MODEM_COUNT = 1;
    private static final int CD_DRIVE_COUNT = 2;

    private int availablePrinters;
    private int availableScanners;
    private int availableModems;
    private int availableCdDrives;

    public ResourceAllocation() {
        this.availablePrinters = PRINTER_COUNT;
        this.availableScanners = SCANNER_COUNT;
        this.availableModems = MODEM_COUNT;
        this.availableCdDrives = CD_DRIVE_COUNT;
    }

    // Yazıcı tahsis et
    public boolean allocatePrinter() {
        if (availablePrinters > 0) {
            availablePrinters--;
            return true;
        }
        return false;
    }

    // Tarayıcı tahsis et
    public boolean allocateScanner() {
        if (availableScanners > 0) {
            availableScanners--;
            return true;
        }
        return false;
    }

    // Modem tahsis et
    public boolean allocateModem() {
        if (availableModems > 0) {
            availableModems--;
            return true;
        }
        return false;
    }

    // CD Sürücü tahsis et
    public boolean allocateCdDrive() {
        if (availableCdDrives > 0) {
            availableCdDrives--;
            return true;
        }
        return false;
    }

    // Kaynakları serbest bırak
    public void deallocateResources(Process process) {
        if (process.isPrinterRequired()) {
            availablePrinters++;
        }
        if (process.isScannerRequired()) {
            availableScanners++;
        }
        if (process.isModemRequired()) {
            availableModems++;
        }
        if (process.isCdDriveRequired()) {
            availableCdDrives++;
        }
    }
}
