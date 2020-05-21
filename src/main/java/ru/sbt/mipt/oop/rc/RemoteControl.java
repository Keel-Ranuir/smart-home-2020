package ru.sbt.mipt.oop.rc;

import java.util.HashMap;
import java.util.Map;

public class RemoteControl implements rc.RemoteControl {

    private Map<String, Command> commandPanel = new HashMap<>();

    @Override
    public void onButtonPressed(String buttonCode, String rcId) {
        if (commandPanel.containsKey(buttonCode)) {
            commandPanel.get(buttonCode).execute();
        }
    }

    public void setCommand(String buttonCode, Command command) {
        if (commandPanel.containsKey(buttonCode)) {
            commandPanel.replace(buttonCode, command);
        } else {
            commandPanel.put(buttonCode, command);
        }
    }
}