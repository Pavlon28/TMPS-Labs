package Lab_2.src.models;

import Lab_2.src.domain.Component;

public class LoggingDecorator implements Component {
    private final Component wrappedComponent;

    public LoggingDecorator(Component wrappedComponent) {
        this.wrappedComponent = wrappedComponent;
    }

    @Override
    public void execute() {
        System.out.println("[LoggingDecorator] Starting execution...");
        wrappedComponent.execute();
        System.out.println("[LoggingDecorator] Execution completed.");
    }
}
