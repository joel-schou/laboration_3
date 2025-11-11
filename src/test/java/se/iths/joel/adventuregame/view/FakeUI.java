package se.iths.joel.adventuregame.view;

import se.sprinto.hakan.adventuregame.view.UI;

import java.util.ArrayList;
import java.util.List;

public class FakeUI implements UI {
    private final List<String> messages = new ArrayList<>();
    private int inputIndex = 0;
    private final List<String> inputs = new ArrayList<>();

    @Override
    public void showMessage(String message) {
        messages.add(message);
    }

    public void setInputs(String... inputs) {
        this.inputs.clear();
        this.inputIndex = 0;
        for (String input : inputs) {
            this.inputs.add(input);
        }
    }

    @Override
    public String getInput(String prompt) {
        if (inputIndex < inputs.size()) {
            return inputs.get(inputIndex++);
        }
        return "";
    }

    public String getOutput() {
        return String.join("\n", messages);
    }

    public List<String> getMessages() {
        return messages;
    }
}
