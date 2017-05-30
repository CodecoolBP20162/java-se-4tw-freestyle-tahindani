package com.codecool.logger;

import java.util.Deque;

public interface TemperatureLogger {

    void logTemp(int temperature);
    int getTemp();
    Deque<Integer> getTemperatures();

}
