package ru.eshtajee.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;


public class TestRadio {
    Radio radio = new Radio();

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/Station.csv")
    public void shouldSetCurrentStation(int currentStation, int expected) {

        radio.setCurrentStation(currentStation);

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource({
            "3,4",
            "9,0",
            "0,1"
    })
    public void shouldSetNextStation(int currentStation, int expected) {

        radio.setCurrentStation(currentStation);
        radio.nextStation();

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource({
            "0,9",
            "5,4",
            "9,8"
    })
    public void shouldSetPrevStation(int currentStation, int expected) {

        radio.setCurrentStation(currentStation);
        radio.prevStation();

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/Volume.csv")
    public void shouldSetCurrentVolume(int currentVolume, int expected) {

        radio.setCurrentVolume(currentVolume);

        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "5,6",
            "10,10",
            "11,1"
    })
    public void shouldSetVolumeUp(int currentVolume, int expected) {
        radio.setCurrentVolume(currentVolume);
        radio.volumeUp();

        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "8,7",
            "0,0",
            "-1,0"
    })
    public void shouldSetVolumeDown(int currentVolume, int expected) {
        radio.setCurrentVolume(currentVolume);
        radio.volumeDown();

        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}
