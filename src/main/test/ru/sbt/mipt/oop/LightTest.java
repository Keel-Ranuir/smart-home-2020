package ru.sbt.mipt.oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class LightTest {

    @Test
    public void testExecute() {
        Light light = new Light("kitchenlight", false);
        light.execute(component -> {
            Light currentLight = (Light) component;
            currentLight.setOn(true);
        });
        assertTrue(light.isOn());
    }
}