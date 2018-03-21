package tranditional.facade;

public class Main {
    public static void main(String[] args) {
        CPU cpu = new CPU();
        Memory memory = new Memory();
        Disk disk = new Disk();
        Computer computer = new Computer(cpu,memory,disk);

        computer.startUp();
        System.out.println("======================");
        computer.shutDown();
    }
}
