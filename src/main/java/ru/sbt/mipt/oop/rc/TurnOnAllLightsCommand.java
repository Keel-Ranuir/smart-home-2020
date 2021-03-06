package ru.sbt.mipt.oop.rc;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SmartHome;

public class TurnOnAllLightsCommand implements Command {
    private SmartHome smartHome;

    public TurnOnAllLightsCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(component -> {
            if(component instanceof Light) {
                ((Light) component).setOn(true);
            }
        });
    }
}
