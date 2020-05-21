package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;

import java.util.Map;

public class CCEventProcessorAdapter implements EventHandler {
    private EventProcessor processor;
    private SmartHome smartHome;

    private final Map<String, SensorEventType> ccStringToType;

    public CCEventProcessorAdapter(EventProcessor processor, SmartHome smartHome,
                                 Map<String, SensorEventType> ccStringToType) {
        this.processor = processor;
        this.smartHome = smartHome;
        this.ccStringToType = ccStringToType;
    }

    @Override
    public void handleEvent(CCSensorEvent ccEvent) {
        SensorEvent event = new SensorEvent(ccStringToType.get(ccEvent.getEventType()), ccEvent.getObjectId());
        processor.processEvent(smartHome, event);
    }
}
