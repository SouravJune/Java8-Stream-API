package com.souravjune.model;

import java.util.Arrays;
import java.util.List;

public class Process {
    private int id;
    private String name;
    private boolean isRunning;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public Process(int id, String name, boolean isRunning) {
        this.id = id;
        this.name = name;
        this.isRunning = isRunning;
    }

    @Override
    public String toString() {
        return "Process{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isRunning=" + isRunning +
                '}';
    }

    public static List<Process> getProcesses() {
        return Arrays.asList(
                new Process(1, "chrome.exe", true),
                new Process(2, "server.exe", true),
                new Process(3, "explorer.exe", true),
                new Process(4, "notepad.exe", false),
                new Process(5, "java.exe", true)
        );
    }

}

