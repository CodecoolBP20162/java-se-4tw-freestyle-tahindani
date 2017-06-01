import com.codecool.logger.temperature.DummyTemperatureLogger;
import com.codecool.logger.temperature.TemperatureLogger;
import controller.RenderController;
import spark.Request;
import spark.Response;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

/**
 * <h1>Temperature Logger</h1>
 * A simple Spark based application where data from a sensor
 * can be shown on a javascript chart.
 *
 * @author  TahinDani
 * @version 1.0
 * @since   2017-06-01
 */
public class Main {

    public static void main(String[] args) {
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFileLocation("/public");
        port(9999);
        enableDebugScreen();

        TemperatureLogger dummyTemperatureLogger = new DummyTemperatureLogger();

        get("/", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(RenderController.renderTemperature(req, res));
        });


        get("/getTemps", (Request req, Response res) -> {
            dummyTemperatureLogger.getTemp();
            return dummyTemperatureLogger.getTemperaturesJson();
        });
    }
}
