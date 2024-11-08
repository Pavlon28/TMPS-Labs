package Lab_2.src.models;

import Lab_2.src.domain.Component;

public class ConcreteComponent implements Component {
    @Override
    public void execute() {
        System.out.println("Executing core functionality in ConcreteComponent");
    }
}
