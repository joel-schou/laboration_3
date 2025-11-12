package se.iths.joel.adventuregame.view;

import se.sprinto.hakan.adventuregame.view.UI;

import java.util.LinkedList;
import java.util.Queue;

public class FakeUI implements UI {

    private Queue<String> inputs = new LinkedList<>();
    private StringBuilder messages = new StringBuilder();

    @Override
    public void showMessage(String message) {
        messages.append(message);
    }

    public void setInputs(String... inputsArray) {
        this.inputs.clear();
        for (String input : inputsArray) {
            this.inputs.add(input);
        }
    }

    @Override
    public String getInput(String prompt) {
        if (inputs.isEmpty()) {
            return "";
        }
        return inputs.poll();
    }

    public String getOutput() {
        return messages.toString();
    }
}
