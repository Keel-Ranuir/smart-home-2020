package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventProcessor implements EventProcessor {

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (isLightEvent(event)) {
            for (Room room : smartHome.getRooms()) {
                for (Light light : room.getLights()) {
                    if (light.getId().equals(event.getObjectId())) {
                        light.setOn(event.getType() == LIGHT_ON);
                        String lightState = (event.getType() == LIGHT_ON) ? "on." : "off.";
                        System.out.println("Light "  + light.getId() + " in room " + room.getName() + " was turned " + lightState);
                    }
                }
            }
        }
    }

    private static boolean isLightEvent(SensorEvent event) {
        return event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF;
    }
}
