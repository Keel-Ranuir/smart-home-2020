package ru.sbt.mipt.oop.rc;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;

public class TurnOnHallLightCommand implements Command {
    private SmartHome smartHome;

    public TurnOnHallLightCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(component ->{
            if(!(component instanceof Room))  {
                return;
            }
            Room room = (Room) component;
            if(room.getName().equals("hall")) {
                room.execute(roomComponent-> {
                    if (roomComponent instanceof Light) {
                        ((Light) roomComponent).setOn(true);
                    }
                });
            }
        });
    }
}
