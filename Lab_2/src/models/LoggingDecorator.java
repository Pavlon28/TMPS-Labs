package Lab_2.src.models;

import Lab_2.src.domain.Component;

public class LoggingDecorator implements Component {
    private final Component wrappedComponent;

    public LoggingDecorator(Component wrappedComponent) {
        this.wrappedComponent = wrappedComponent;
    }

    @Override
    public void execute() {
        System.out.println("[Decorator] Logging before execution");
        wrappedComponent.execute();
        System.out.println("[Decorator] Logging after execution");
    }
}
