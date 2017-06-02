package com.codecool.logger.temperature;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TemperatureTest {

    @Test
    public void testGetValue(){
        Temperature temp = new Temperature(20);
        assertEquals(20, temp.getValue());
    }


}