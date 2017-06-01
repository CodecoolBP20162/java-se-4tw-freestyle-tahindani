package com.codecool.logger.temperature;

import java.util.Deque;

public interface TemperatureLogger {

    void logTemp(Temperature temperature);
    Temperature getTemp();
    String getTemperaturesJson();

}
