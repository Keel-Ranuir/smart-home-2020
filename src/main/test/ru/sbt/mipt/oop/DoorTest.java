package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorTest {

    @Test
    public void testExecute() {
        Door door = new Door(true, "halldoor");
        door.execute(component -> {
            Door currentDoor = (Door) component;
            currentDoor.setOpen(false);
        });
        assertFalse(door.isOpen());
    }
}