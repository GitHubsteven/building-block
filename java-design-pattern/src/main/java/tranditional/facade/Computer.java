package tranditional.facade;

public class Computer {
    private CPU cpu;
    private Memory memory;
    private Disk disk;

    public Computer(CPU cpu, Memory memory, Disk disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    public void startUp(){
        this.cpu.startUp();
        this.memory.startUp();
        this.disk.startUp();
    }

    public void shutDown(){
        this.cpu.shutDown();
        this.memory.shutDown();
        this.disk.shutDown();
    }
}
