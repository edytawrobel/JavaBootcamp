package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;

import java.util.Map;

public class ProcessingElementImpl {
    public Map<String, ProcessingElement> getProcessingElement() {
        return Map.of("+", new Adder(),
                "/", new Divider());
    }
}
