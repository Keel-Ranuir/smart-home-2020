package ru.sbt.mipt.oop;

public class DeactivatedAlarmState implements AlarmState {
    protected Alarm alarm;

    public DeactivatedAlarmState(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate(String code) {
        alarm.setCode(code);
        alarm.setState(new ActivatedAlarmState(alarm));
    }

    @Override
    public void deactivate(String code) {
        //nothing to do
    }

    @Override
    public void alert() {
        //cannot alert deactivated alarm
    }
}
