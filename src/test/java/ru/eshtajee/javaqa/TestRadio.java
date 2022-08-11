package ru.eshtajee.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;


public class TestRadio {
    Radio radio = new Radio();

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/Station.csv")
    public void shouldSetCurrentStation(int newCurrentStation, int expected) {

        radio.setCurrentStation(newCurrentStation);

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource({
            "3,4",
            "9,0",
            "0,1"
    })
    public void shouldSetNextStation(int newCurrentStation, int expected) {

        radio.nextStation(newCurrentStation);

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource({
            "0,9",
            "5,4",
            "9,8"
    })
    public void shouldSetPrevStation(int newCurrentStation, int expected) {

        radio.prevStation(newCurrentStation);

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/Volume.csv")
    public void shouldSetCurrentVolume(int newCurrentVolume, int expected) {

        radio.setCurrentVolume(newCurrentVolume);

        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "5,6",
            "10,10",
            "11,10"
    })
    public void shouldSetVolumeUp(int newCurrentVolume, int expected) {

        radio.volumeUp(newCurrentVolume);

        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "8,7",
            "0,0",
            "-1,0"
    })
    public void shouldSetVolumeDown(int newCurrentVolume, int expected) {

        radio.volumeDown(newCurrentVolume);

        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}
