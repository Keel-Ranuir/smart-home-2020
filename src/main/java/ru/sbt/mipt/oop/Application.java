package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String... args) throws IOException {
        SmartHome smartHome = new SmartHomeReader().readSmartHome("smart-home-1.js");
        SensorEvent event = new SensorEventCreator().getNextSensorEvent();
        List<EventProcessor> processors = Arrays.asList(new DoorEventProcessor(), new LightEventProcessor(), new HallDoorEventProcessor());
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventProcessor processor: processors) {
                processor.processEvent(smartHome, event);
            }
            event = new SensorEventCreator().getNextSensorEvent();
        }
    }

}
