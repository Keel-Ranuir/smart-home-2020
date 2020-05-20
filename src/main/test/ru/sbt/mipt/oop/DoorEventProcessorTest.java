package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventProcessorTest {

    private Door livingRoomDoor = new Door(true, "livingroom");
    private Door kitchenDoor = new Door(false, "kitchen");
    private Light livingRoomLight = new Light("livingroom", true);
    private Light kitchenLight = new Light("kitchen", false);

    private SmartHome smartHome = new SmartHome(Arrays.asList(
            new Room(Arrays.asList(livingRoomLight), Arrays.asList(livingRoomDoor), "livingroom"),
            new Room(Arrays.asList(kitchenLight), Arrays.asList(kitchenDoor), "kitchen")
    ));

    private EventProcessor processor = new DoorEventProcessor();

    @Test
    public void testClosedDoorOpens() {
        processor.processEvent(smartHome, new SensorEvent(DOOR_OPEN, "kitchen"));
        assertTrue(kitchenDoor.isOpen());
    }

    @Test
    public void testOpenedDoorCloses() {
        processor.processEvent(smartHome, new SensorEvent(DOOR_CLOSED, "kitchen"));
        assertFalse(kitchenDoor.isOpen());
    }
}