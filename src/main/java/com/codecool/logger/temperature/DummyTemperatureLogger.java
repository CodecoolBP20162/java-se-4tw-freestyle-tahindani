package com.codecool.logger.temperature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class DummyTemperatureLogger implements TemperatureLogger {

    private static final Logger logger = LoggerFactory.getLogger(DummyTemperatureLogger.class);
    private Deque<String> temperaturesJson = new LinkedList<>();


    /**
     * This method get a random int, make a Temperature object from it, log it and
     * add it to the temperaturesJson.
     * @return a Temperature object but currently I don't use this value anywhere else.
     */
    public Temperature getTemp() {
        Random random = new Random();
        int randomNumber = random.nextInt(35 + 1 - -20) + -20;
        Temperature randomTemperature = new Temperature(randomNumber);
        logTemp(randomTemperature);
        populateTemperaturesList(randomTemperature);
        return randomTemperature;
    }


    /**
     * This method log the value of a Temperature object. Logging level is warn if temperature
     * less than 0 or greater than 30 else it is info.
     * @param temperature Temperature object
     */
    public void logTemp(Temperature temperature) {
        //PropertyConfigurator.configure("src/main/resources/log4j.properties");
        if(temperature.getValue() > 30) {
            logger.warn("Temperature has risen above 30 degrees. Temperature is: " + temperature.getValueString());
        }else if(temperature.getValue() < 0) {
            logger.warn("Temperature has fallen below 0 degrees. Temperature is: " + temperature.getValueString());
        } else {
            logger.info("Temperature is: " + temperature.getValueString());
        }
    }

    /**
     * This method add a Temperature object as a json string to the temperaturesJson Deque.
     * If more than ten element is in the Deque it remove the first element before
     * adding a new.
     * @param temperature Temperature object
     */
    public void populateTemperaturesList(Temperature temperature){
        if (temperaturesJson.size() > 9) {
            temperaturesJson.removeFirst();
            temperaturesJson.addLast(temperature.toJSON());
        } else {
            temperaturesJson.addLast(temperature.toJSON());
        }
    }

    /**
     * This method returns the temperaturesJson Deque as a json string.
     * @return the list of Temperature objects as a json string
     */
    public String getTemperaturesJson() {
        return temperaturesJson.toString();
    }

}
