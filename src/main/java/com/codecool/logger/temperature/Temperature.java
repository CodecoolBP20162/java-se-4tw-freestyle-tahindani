package com.codecool.logger.temperature;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Temperature {

    private Date date;
    private String unit = "°C";
    private int value;

    public Temperature(int value) {
        this.value = value;
        this.date = new Date();
    }

    public String getDateString() {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd E 'at' kk:mm:ss");
        return ft.format(date).toString();
    }

    public String getUnit() {
        return unit;
    }

    public int getValue() {
        return value;
    }

    public String getValueString(){
        return Integer.toString(value) + unit;
    }

    public String toJSON()  {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void main(String[] args) {
        Temperature temp = new Temperature(21);
        System.out.println(temp.getDateString());
        System.out.println(temp.getValueString());
        System.out.println(temp.toJSON());
    }
}
