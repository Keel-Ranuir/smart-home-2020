package ru.sbt.mipt.oop.rc;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SmartHome;

public class TurnOffAllLightsCommand implements Command {
    private SmartHome smartHome;

    public TurnOffAllLightsCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(component ->{
            if(component instanceof Light){
                ((Light) component).setOn(false);
            }
        });
    }

}
