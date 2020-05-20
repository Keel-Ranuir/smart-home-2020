package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.SensorEventType.*;

public class LightEventProcessorTest {
    private Door livingRoomDoor = new Door(true, "livingroom");
    private Door kitchenDoor = new Door(false, "kitchen");
    private Light livingRoomLight = new Light("livingroom", true);
    private Light kitchenLight = new Light("kitchen", false);

    private SmartHome smartHome = new SmartHome(Arrays.asList(
            new Room(Arrays.asList(livingRoomLight), Arrays.asList(livingRoomDoor), "livingroom"),
            new Room(Arrays.asList(kitchenLight), Arrays.asList(kitchenDoor), "kitchen")
    ));

    private EventProcessor processor = new LightEventProcessor();

    @Test
    public void testLightTurnsOn() {
        processor.processEvent(smartHome, new SensorEvent(LIGHT_ON, "kitchen"));
        assertTrue(kitchenLight.isOn());
    }

    @Test
    public void testLightTurnsOff() {
        processor.processEvent(smartHome, new SensorEvent(LIGHT_OFF, "kitchen"));
        assertFalse(kitchenLight.isOn());
    }
}