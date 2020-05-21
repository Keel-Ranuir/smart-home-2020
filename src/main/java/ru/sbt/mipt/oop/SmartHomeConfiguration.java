package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

import static ru.sbt.mipt.oop.SensorEventType.*;

@Configuration
public class SmartHomeConfiguration {
    @Bean
    public SmartHome smartHome() {
        return new SmartHomeJsonReader().readSmartHome("smart-home-1.js");
    }

    @Bean
    EventProcessor doorEventProcessor(){
        return new DoorEventProcessor();
    }

    @Bean
    EventProcessor lightEventProcessor(){
        return new LightEventProcessor();
    }

    @Bean
    EventProcessor hallDoorEventProcessor(){
        return new HallDoorEventProcessor();
    }

    @Bean
    EventProcessor alarmEventProcessor(){
        return new AlarmEventProcessor();
    }

    @Bean
    Map<String, SensorEventType> ccStringToType() {
        return Map.ofEntries(
                Map.entry("LightIsOn", LIGHT_ON),
                Map.entry("LightIsOff", LIGHT_OFF),
                Map.entry("DoorIsOpen", DOOR_OPEN),
                Map.entry("DoorIsClosed", DOOR_CLOSED)
        );
    }

    @Bean
    CCEventProcessorAdapter eventProcessorAdapter(List<EventProcessor> processors, SmartHome smartHome,
                                                  Map<String, SensorEventType> ccStringToType){
        return new CCEventProcessorAdapter(new AlarmEventProcessorDecorator(processors), smartHome, ccStringToType);
    }

    @Bean
    public SensorEventsManager sensorEventsManager(CCEventProcessorAdapter adapter) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(adapter);
        return sensorEventsManager;
    }
}
