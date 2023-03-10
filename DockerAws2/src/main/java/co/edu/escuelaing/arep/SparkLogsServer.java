package co.edu.escuelaing.arep;
import co.edu.escuelaing.arep.balancer.ApiResponse;
import co.edu.escuelaing.arep.balancer.LoadBalancer;

import static spark.Spark.*;

public class SparkLogsServer {

    private static final LoadBalancer loadBalancer = LoadBalancer.getInstance();
    public static void main(String... args){
        port(getPort());
        get("hello/:cadena",(req,res) -> {
            res.header("Content-Type","application/json");
            String urlLoadBalancer = loadBalancer.getPort()+"/hello/"+req.params("cadena");
            return ApiResponse.get(urlLoadBalancer);
        });
        get("/",(req,res) -> {
            return respose();
        });
    }

    private static String respose(){
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Form Example</title>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Form with GET</h1>\n" +
                "    <form action=\"/hello\">\n" +
                "        <label for=\"newLog\">Name:</label><br>\n" +
                "        <input type=\"text\" id=\"newLog\" name=\"newLog\" value=\"John\"><br><br>\n" +
                "        <input type=\"button\" value=\"Submit\" onclick=\"loadGetMsg()\">\n" +
                "    </form>\n" +
                "    <div id=\"getrespmsg\"></div>\n" +
                "\n" +
                "    <script>\n" +
                "        function loadGetMsg() {\n" +
                "            let nameVar = document.getElementById(\"newLog\").value;\n" +
                "            const xhttp = new XMLHttpRequest();\n" +
                "            xhttp.onload = function() {\n" +
                "                document.getElementById(\"getrespmsg\").innerHTML =\n" +
                "                this.responseText;\n" +
                "            }\n" +
                "            xhttp.open(\"GET\", \"/hello/\"+nameVar);\n" +
                "            xhttp.send();\n" +
                "        }\n" +
                "    </script>\n" +
                "</body>\n" +
                "</html>";
    }

    private static int getPort() {
        if (System.getenv("PORT1") != null) {
            return Integer.parseInt(System.getenv("PORT1"));
        }
        return 4567;
    }
}
