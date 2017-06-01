package controller;/*
Created by tahin on 2017.05.30..
*/

import com.codecool.logger.temperature.Temperature;
import com.sun.xml.internal.bind.v2.TODO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RenderController {

    public static ModelAndView renderTemperature(Request req, Response res, String temperatures) {
        // TODO: 2017.06.01. don't need to pass temperatures here
        Map params = new HashMap<>();
        params.put("temperatures", temperatures);

        return new ModelAndView(params, "index");
    }
}
