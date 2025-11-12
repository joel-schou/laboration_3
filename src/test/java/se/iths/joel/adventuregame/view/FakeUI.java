package se.iths.joel.adventuregame.view;

import se.sprinto.hakan.adventuregame.view.UI;

import java.util.LinkedList;
import java.util.Queue;

public class FakeUI implements UI {
    private final Queue<String> inputs = new LinkedList<>();

    @Override
    public void showMessage(String message) {
        inputs.add(message);
    }

    public void setInput(String input) {
        inputs.add(input);
    }

    @Override
    public String getInput(String prompt) {
        return inputs.poll();
    }
}
