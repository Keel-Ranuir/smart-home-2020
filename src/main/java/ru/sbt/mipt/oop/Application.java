package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.Arrays;

public class Application {

    public static void main(String... args) throws IOException {
        SmartHome smartHome = new SmartHomeJsonReader().readSmartHome("smart-home-1.js");
        SmartHomeProcessor smartHomeProcessor = new SmartHomeProcessor(Arrays.asList(new DoorEventProcessor(),
                new LightEventProcessor(), new HallDoorEventProcessor()));
        smartHomeProcessor.process(smartHome);
    }

}
