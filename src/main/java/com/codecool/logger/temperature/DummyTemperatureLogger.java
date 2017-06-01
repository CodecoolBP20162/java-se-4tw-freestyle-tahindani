package com.codecool.logger.temperature;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class DummyTemperatureLogger implements TemperatureLogger {

    private static final Logger logger = LoggerFactory.getLogger(DummyTemperatureLogger.class);
    private Deque<String> temperaturesJson = new LinkedList<>();

    public void logTemp(Temperature temperature) {
        if(temperature.getValue() > 30) {
            logger.warn("Temperature has risen above 30 degrees. Temperature is: " + temperature.getValueString());
        }else if(temperature.getValue() < 0) {
            logger.warn("Temperature has fallen below 0 degrees. Temperature is: " + temperature.getValueString());
        } else {
            logger.info("Temperature is: " + temperature.getValueString());
        }
    }

    public Temperature getTemp() {
        Random random = new Random();
        int randomNumber = random.nextInt(35 + 1 - -20) + -20;
        Temperature randomTemperature = new Temperature(randomNumber);
        populateTemperaturesList(randomTemperature);
        return randomTemperature;
    }

    private void populateTemperaturesList(Temperature temperature){
        if (temperaturesJson.size() > 9) {
            temperaturesJson.removeFirst();
            temperaturesJson.addLast(temperature.toJSON());
        } else {
            temperaturesJson.addLast(temperature.toJSON());
        }
    }

    public String getTemperaturesJson() {
        return temperaturesJson.toString();
    }

    public static void main(String[] args) {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        DummyTemperatureLogger dummyTemperatureLogger = new DummyTemperatureLogger();
        dummyTemperatureLogger.getTemp();
        dummyTemperatureLogger.getTemp();
        dummyTemperatureLogger.getTemp();
        dummyTemperatureLogger.getTemp();
        System.out.println(dummyTemperatureLogger.getTemperaturesJson());
    }
}
