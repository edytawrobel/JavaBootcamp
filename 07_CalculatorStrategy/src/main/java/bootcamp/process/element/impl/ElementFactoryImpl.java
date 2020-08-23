package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.util.Objects;
import java.util.Optional;

public class ElementFactoryImpl implements ElementFactory {
    @Override
    public Optional<ProcessingElement> create(String operator) {
        if (operator == null) {
            return Optional.empty();
        }

        if (Objects.equals(operator, "-")) {
            Subtractor subtractor = new Subtractor();
            return Optional.of(subtractor);

        } else if (Objects.equals(operator, "+")) {
            Adder adder = new Adder();
            return Optional.of(adder);
        } else if (Objects.equals(operator, "x")) {
            Multiplier multiplier = new Multiplier();
            return Optional.of(multiplier);
        } else if (Objects.equals(operator, "/")) {
            Divider divider = new Divider();
            return Optional.of(divider);
        }
            return Optional.empty();
    }
}
