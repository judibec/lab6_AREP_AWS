package co.edu.escuelaing.arep.balancer;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancer {

    private static final LoadBalancer INSTANCE = new LoadBalancer();

    private static List<String> ports;

    private static int currentIndex;

    private LoadBalancer(){
        ports = new ArrayList<>();
        currentIndex = 0;
        ports.add("http://ec2-54-90-218-219.compute-1.amazonaws.com:4567");
        ports.add("http://ec2-52-204-66-107.compute-1.amazonaws.com:4567");
        ports.add("http://ec2-54-145-27-178.compute-1.amazonaws.com:4567");
    }

    public static LoadBalancer getInstance(){
        return INSTANCE;
    }



    public static String getPort(){
        synchronized(ports) {
            if (currentIndex >= ports.size()) {
                currentIndex = 0;
            }

            String port = ports.get(currentIndex);
            currentIndex++;

            return port;
        }
    }
}
