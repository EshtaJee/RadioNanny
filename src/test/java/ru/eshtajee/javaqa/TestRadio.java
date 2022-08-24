package ru.eshtajee.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;


public class TestRadio {
    Radio radio = new Radio();

    @Test
    public void testStation() {

        Assertions.assertEquals(10, radio.getAmountRadioStation());
    }

    @Test
    public void amountRadioStation() {
        Radio amountStation = new Radio(15);

        Assertions.assertEquals(15, amountStation.getAmountRadioStation());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/Station.csv")
    public void shouldSetCurrentRadioStation(int currentRadioStation, int expected) {

        radio.setCurrentRadioStation(currentRadioStation);

        Assertions.assertEquals(expected, radio.getCurrentRadioStation());
    }

    @ParameterizedTest
    @CsvSource({
            "0,1",
            "9,0",
            "5,6"
    })
    public void shouldSetNextRadioStation(int currentRadioStation, int expected) {

        radio.setCurrentRadioStation(currentRadioStation);
        radio.nextStation();

        Assertions.assertEquals(expected, radio.getCurrentRadioStation());
    }

    @ParameterizedTest
    @CsvSource({
            "0,9",
            "5,4",
            "9,8"
    })
    public void shouldSetPrevRadioStation(int currentRadioStation, int expected) {

        radio.setCurrentRadioStation(currentRadioStation);
        radio.prevStation();

        Assertions.assertEquals(expected, radio.getCurrentRadioStation());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/Volume.csv")
    public void shouldSetCurrentVolume(int currentVolume, int expected) {

        radio.setCurrentVolume(currentVolume);

        Assertions.assertEquals(expected, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource({
            "100,100",
            "50,51",
            "0,1"
    })
    public void shouldSetVolumeUp(int currentVolume, int expected) {

        radio.setCurrentVolume(currentVolume);
        radio.volumeUp();

        Assertions.assertEquals(expected, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource({
            "100,99",
            "50,49",
            "0,0"
    })
    public void shouldSetVolumeDown(int currentVolume, int expected) {

        radio.setCurrentVolume(currentVolume);
        radio.volumeDown();

        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}
