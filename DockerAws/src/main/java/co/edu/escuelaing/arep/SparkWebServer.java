package co.edu.escuelaing.arep;

import co.edu.escuelaing.arep.services.MongoDBService;
import co.edu.escuelaing.arep.services.MongoDBServices;

import static spark.Spark.*;

public class SparkWebServer {

    private static final MongoDBService mongoDBService = MongoDBServices.getInstance();
    public static void main(String... args){
        port(getPort());
        get("hello/:cadena",(req,res) -> {
            res.header("Content-Type","application/json");
            mongoDBService.createLog(req.params("cadena"));
            return mongoDBService.getLog();
        });

        get("hello/test",(req,res) -> {
            return "hello";
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
