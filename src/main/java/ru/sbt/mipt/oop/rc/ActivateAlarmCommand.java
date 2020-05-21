package ru.sbt.mipt.oop.rc;

import ru.sbt.mipt.oop.SmartHome;

public class ActivateAlarmCommand implements Command {
    private SmartHome smartHome;
    private String code;

    public ActivateAlarmCommand(SmartHome smartHome, String code) {
        this.smartHome = smartHome;
        this.code = code;
    }

    @Override
    public void execute() {
        smartHome.getAlarm().activate(code);
    }
}
