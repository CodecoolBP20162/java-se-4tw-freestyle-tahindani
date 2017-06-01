package com.codecool.logger.temperature;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class contains methods which are modify or read the parameters
 * of the temperature.
 */
public class Temperature {

    private Date date;
    private String unit = "°C";
    private int value;

    /**
     * This is the constructor. It makes object from an int value and the current date.
     * @param value a temperature value
     */
    public Temperature(int value) {
        this.value = value;
        this.date = new Date();
    }

    /**
     * This method format the {@code date} attribute of a {@code Temperature} object
     * and convert it into String.
     * @return String formatted as "yyyy.MM.dd E 'at' kk:mm:ss"
     */
    public String getDateString() {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd E 'at' kk:mm:ss");
        return ft.format(date).toString();
    }

    /**
     * This method return the {@code unit} parameter of the {@code Temperature} object.
     * @return String
     */
    public String getUnit() {
        return unit;
    }

    /**
     * This method return the {@code value} parameter of the {@code Temperature} object.
     * @return int
     */
    public int getValue() {
        return value;
    }

    /**
     * This method return a formatted string like "20°C".
     * @return String
     */
    public String getValueString(){
        return Integer.toString(value) + unit;
    }

    /**
     * This method convert the {@code Temperature} object into json string.
     * @return String json
     */
    public String toJSON()  {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }

    }

}
