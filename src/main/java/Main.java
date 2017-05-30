import com.codecool.logger.DummyTemperature;
import com.codecool.logger.TemperatureLogger;
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

        TemperatureLogger dummyTemperature = new DummyTemperature();

        get("/", (Request req, Response res) -> {
            dummyTemperature.getTemp();
            dummyTemperature.getTemp();
            dummyTemperature.getTemp();
            return new ThymeleafTemplateEngine().render(RenderController.renderTemperature(req, res, dummyTemperature.getTemperatures()));
        });




    }
}
