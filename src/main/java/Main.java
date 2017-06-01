import com.codecool.logger.temperature.DummyTemperatureLogger;
import com.codecool.logger.temperature.Temperature;
import com.codecool.logger.temperature.TemperatureLogger;
import controller.RenderController;
import spark.Request;
import spark.Response;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

public class Main {

    public static void main(String[] args) {
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFileLocation("/public");
        port(9999);
        enableDebugScreen();

        TemperatureLogger dummyTemperatureLogger = new DummyTemperatureLogger();

        get("/", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(RenderController.renderTemperature(req, res, dummyTemperatureLogger.getTemperaturesJson()));
        });


        get("/getTemps", (Request req, Response res) -> {
            dummyTemperatureLogger.getTemp();
            return dummyTemperatureLogger.getTemperaturesJson();
        });
    }
}
