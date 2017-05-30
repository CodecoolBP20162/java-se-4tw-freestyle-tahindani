package com.codecool.logger;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class DummyTemperature implements TemperatureLogger {

    private static final Logger logger = LoggerFactory.getLogger(DummyTemperature.class);
    private Deque<Integer> temperatures = new LinkedList<>();

    public void logTemp(int temperature) {
        if(temperature > 30) {
            logger.warn("Temperature has risen above 30 degrees. Temperature is:" + temperature);
        }else if(temperature < 0) {
            logger.warn("Temperature has fallen below 0 degrees. Temperature is:" + temperature);
        } else {
            logger.info("Temperature is: " + temperature);
        }
    }

    public int getTemp() {
        Random random = new Random();
        int randomTemperature = random.nextInt(35 + 1 - -20) + -20;
        populateTemperaturesList(randomTemperature);
        return randomTemperature;
    }

    private void populateTemperaturesList(int temperature){
        if (temperatures.size() > 9) {
            temperatures.removeFirst();
            temperatures.addLast(temperature);
        } else {
            temperatures.addLast(temperature);
        }
    }

    public Deque<Integer> getTemperatures() {
        return temperatures;
    }

    public static void main(String[] args) {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        DummyTemperature dummyTemperature = new DummyTemperature();

        for (int i = 0; i < 20; i++) {
            dummyTemperature.logTemp(dummyTemperature.getTemp());
            System.out.println(dummyTemperature.temperatures);

        }
    }
}
