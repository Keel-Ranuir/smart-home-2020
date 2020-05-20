package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {

    public static void main(String... args) {
        SmartHome smartHome = new SmartHomeJsonReader().readSmartHome("smart-home-1.js");

        List<EventProcessor> processors = Arrays.asList(new DoorEventProcessor(),
                new LightEventProcessor(), new HallDoorEventProcessor());
        AlarmEventProcessorDecorator alarmEventProcessorDecorator = new AlarmEventProcessorDecorator(processors);
        SmartHomeProcessor smartHomeProcessor = new SmartHomeProcessor(Collections.singletonList(alarmEventProcessorDecorator));
        smartHomeProcessor.process(smartHome);
    }

}
