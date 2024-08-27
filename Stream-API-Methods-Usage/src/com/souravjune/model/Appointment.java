package com.souravjune.model;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class Appointment {
    private String description;
    private LocalTime time;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Appointment(String description, LocalTime time) {
        this.description = description;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "description='" + description + '\'' +
                ", time=" + time +
                '}';
    }

    public static List<Appointment> getAppointments() {
        return Arrays.asList(
                new Appointment("Meeting with client", LocalTime.of(14, 0)),
                new Appointment("Team lunch", LocalTime.of(13, 0)),
                new Appointment("Project review", LocalTime.of(15, 30))
        );
    }
}

