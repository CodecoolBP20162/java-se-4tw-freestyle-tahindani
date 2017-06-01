package com.codecool.logger.temperature;

import java.util.Deque;

/**
This is the logging interface. It declares the three method which the logging class have to use.
 */
public interface TemperatureLogger {


    /**
     * This method asks the temperature value from a sensor
     * and make a {@code Temperature} object from it. It does not need to
     * return it.
     */
    Temperature getTemp();

    /**
     * This method populates a Deque with json objects made from
     * {@code Temperature} objects.
     * @param temperature {@code Temperature} object
     */
    void populateTemperaturesList(Temperature temperature);

    /**
     * This method returns the Deque of {@code Temperature} objects
     * as a json String.
     * @return a String of json objects
     */
    String getTemperaturesJson();

}
