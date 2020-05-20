package ru.sbt.mipt.oop;

import static org.junit.Assert.*;
import org.junit.Test;

public class AlarmTest {
    Alarm alarm = new Alarm();

    @Test
    public void testActivate() {
        alarm.activate("code");
        assertTrue(alarm.isActivated());
    }

    @Test
    public void testDeactivate() {
        alarm.activate("code");
        alarm.deactivate("code");
        assertTrue(alarm.isDeactivated());
    }

    @Test
    public void testWrongCode() {
        alarm.activate("code");
        alarm.deactivate("oops");
        assertTrue(alarm.isAlert());
    }
}