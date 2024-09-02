package com.souravjune.model;

import java.util.Arrays;
import java.util.List;

public class Ticket {
    private int id;
    private String description;
    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Ticket(int id, String description, Status status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

    public static List<Ticket> getTickets() {
        return Arrays.asList(
                new Ticket(1, "Issue with login", Status.CLOSED),
                new Ticket(2, "Page not loading", Status.CLOSED),
                new Ticket(3, "Error in payment gateway", Status.OPEN),
                new Ticket(4, "Error in authentication", Status.IN_PROGRESS)
        );
    }

}

