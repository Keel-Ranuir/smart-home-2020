package ru.sbt.mipt.oop;

import java.util.List;

public class SmartHomeProcessor {
    private List<EventProcessor> processors;

    SmartHomeProcessor(List<EventProcessor> processors) {
        this.processors = processors;
    }

    public void process(SmartHome smartHome) {
        SensorEvent event = SensorEventCreator.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventProcessor processor: processors) {
                processor.processEvent(smartHome, event);
            }
            event = SensorEventCreator.getNextSensorEvent();
        }
    }
}
