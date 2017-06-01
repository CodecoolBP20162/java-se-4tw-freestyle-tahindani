package controller;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class RenderController {

    /**
     * This is a Spark method. It renders the html.
     * @param req
     * @param res
     * @return ModelAndView
     */
    // TODO: 2017.06.01. not sure that I need this method as I don't pass anything to the template
    public static ModelAndView renderTemperature(Request req, Response res) {

        Map params = new HashMap<>();
        params.put("temperatures", "");

        return new ModelAndView(params, "index");
    }
}
