package co.edu.escuelaing.arep.services;

import org.json.JSONObject;

public interface MongoDBService {

    void createLog(String cadena);

    JSONObject getLog();
}
