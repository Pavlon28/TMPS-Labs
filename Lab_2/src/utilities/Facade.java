package Lab_2.src.utilities;

public class Facade {
    private final SubsystemA subsystemA;
    private final SubsystemB subsystemB;

    public Facade(SubsystemA subsystemA, SubsystemB subsystemB) {
        this.subsystemA = subsystemA;
        this.subsystemB = subsystemB;
    }

    public void executeComplexOperation() {
        System.out.println("Facade initiating complex operation...");
        subsystemA.operationA();
        subsystemB.operationB();
        System.out.println("Complex operation completed by Facade.");
    }
}
