package controller;/*
Created by tahin on 2017.05.30..
*/

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RenderController {

    public static ModelAndView renderTemperature(Request req, Response res, Deque<Integer> temperatures) {

        Map params = new HashMap<>();
        params.put("temperatures", temperatures);

        return new ModelAndView(params, "index");
    }
}
