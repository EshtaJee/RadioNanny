package ru.eshtajee.javaqa;

public class Radio {
    private int currentStation;
    private int currentVolume;

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentStation(int newCurrentStation) {
        if (newCurrentStation < 0) {
            return;
        }
        if (newCurrentStation > 9) {
            return;
        }
        currentStation = newCurrentStation;
    }

    public void nextStation(int newCurrentStation) {
        if (newCurrentStation < 9) {
            currentStation = newCurrentStation + 1;
        }
        if (newCurrentStation >= 9) {
            currentStation = 0;
        }
    }

    public void prevStation(int newCurrentStation) {
        if (newCurrentStation > 0) {
            currentStation = newCurrentStation - 1;
        }
        if (newCurrentStation <= 0) {
            currentStation = 9;
        }
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume >= 0 & newCurrentVolume <= 10) {
            currentVolume = newCurrentVolume;
        }
    }

    public void volumeUp(int newCurrentVolume) {
        if (newCurrentVolume < 10) {
            currentVolume = newCurrentVolume + 1;
        }
        if (newCurrentVolume >= 10) {
            currentVolume = 10;
        }
    }

    public void volumeDown(int newCurrentVolume) {
        if (newCurrentVolume > 0) {
            currentVolume = newCurrentVolume - 1;
        }
        if (newCurrentVolume <= 0) {
            currentVolume = 0;
        }
    }

}