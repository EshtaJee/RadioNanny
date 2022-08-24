package ru.eshtajee.javaqa;

public class Radio {
    private int currentStation;
    private int amountStation = 10;
    private int currentVolume;

    public Radio() {
    }

    public Radio(int amountRadioStation) {
        this.amountStation = amountRadioStation;
    }

    public int getCurrentRadioStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getAmountRadioStation() {
        return amountStation;
    }

    public void setCurrentRadioStation(int currentRadioStation) {
        if (currentRadioStation < 0) {
            return;
        }
        if (currentRadioStation > amountStation - 1) {
            return;
        }
        this.currentStation = currentRadioStation;

    }

    public void nextStation() {
        if (currentStation == amountStation - 1) {
            currentStation = 0;
        } else currentStation = currentStation + 1;
    }


    public void prevStation() {
        if (currentStation == 0) {
            currentStation = amountStation - 1;
        } else {
            currentStation = currentStation - 1;
        }
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume < 0) {
            return;
        }
        if (currentVolume > 100) {
            return;
        }
        this.currentVolume = currentVolume;
    }

    public void volumeUp() {
        if (currentVolume < 100) {
            currentVolume = currentVolume + 1;
        }
    }


    public void volumeDown() {
        if (currentVolume > 0) {
            currentVolume = currentVolume - 1;
        }
    }

}