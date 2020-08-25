package bootcamp.process.element;

import bootcamp.process.element.impl.ProcessingElementImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class ElementFactory {
    protected final Map<String, ProcessingElement> elementMap;

    public ElementFactory() {
        this.elementMap = new ProcessingElementImpl().getProcessingElement();
    }

    public abstract Optional<ProcessingElement> create(final String operator);
}

// ElementFactory is an abstract base class which implements the Template Method design pattern.
// Its subclasses create and return the respective processing elements to the Calculator. But the big question is, which factory to use.
// This is answered by organising them in a Chain of Responsibility.
// The ElementFactory class has two overloaded methods, getProcessingElement.
// The concrete one takes the operator, checks if the argument equals its instance variable operator.
// If so, it creates an instance of the processing element it is responsible for and returns it wrapped in an Optional.
// If not, it calls the getProcessingElement of the nextFactory. If nextFactory is null, it returns an empty Optional.
//
// Calculator class creates the chain in its constructor.