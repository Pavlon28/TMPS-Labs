package Lab_2.src.client;

import Lab_2.src.domain.Component;
import Lab_2.src.domain.TargetInterface;
import Lab_2.src.models.ConcreteComponent;
import Lab_2.src.models.LoggingDecorator;
import Lab_2.src.utilities.Adapter;
import Lab_2.src.utilities.Facade;
import Lab_2.src.utilities.LegacySystem;
import Lab_2.src.utilities.SubsystemA;
import Lab_2.src.utilities.SubsystemB;

public class MainClient {
    public static void main(String[] args) {
        // Adapter Pattern demonstration
        System.out.println("=== Adapter Pattern ===");
        TargetInterface adapter = new Adapter(new LegacySystem());
        adapter.performStandardAction();

        // Decorator Pattern demonstration
        System.out.println("\n=== Decorator Pattern ===");
        Component component = new LoggingDecorator(new ConcreteComponent());
        component.execute();

        // Facade Pattern demonstration
        System.out.println("\n=== Facade Pattern ===");
        Facade facade = new Facade(new SubsystemA(), new SubsystemB());
        facade.executeComplexOperation();
    }
}
