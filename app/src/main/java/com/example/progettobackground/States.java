package com.example.progettobackground;

public class States {
    private Boolean started = false;


    private Boolean startedForeground = false;

    public Boolean isStartedForeground() {
        return startedForeground;
    }

    public void setStartedForeground(Boolean startedForeground) {
        this.startedForeground = startedForeground;
    }

    public Boolean isStarted() {
        return started;
    }

    public void setStarted(Boolean started) {
        this.started = started;
    }
}
