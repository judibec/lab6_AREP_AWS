package co.edu.escuelaing.arep.services;

import com.mongodb.client.*;
import org.bson.Document;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class MongoDBServices implements MongoDBService{

    private static final MongoDBServices INSTANCE = new MongoDBServices();

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    MongoCollection<Document> collection;

    private MongoDBServices(){
        this.mongoClient = MongoClients.create("mongodb://ec2-100-25-0-115.compute-1.amazonaws.com:27017");
        this.mongoDatabase = mongoClient.getDatabase("test");
        this.collection = mongoDatabase.getCollection("logService");
    }

    public static MongoDBServices getInstance(){
        return INSTANCE;
    }


    @Override
    public void createLog(String cadena) {
        TimeZone zonaHoraria = TimeZone.getTimeZone("America/Bogota");
        Document document = new Document("Cadena", cadena).append("fecha", LocalDateTime.now(zonaHoraria.toZoneId()));
//        collection.deleteMany(new Document());
        collection.insertOne(document);
    }

    @Override
    public JSONObject getLog() {
        JSONObject jsonObject = new JSONObject();
        List<Document> allDocuments = collection.find().sort(new Document("fecha", -1)).limit(10).into(new ArrayList<>());

        for(Document document:allDocuments){
            Document newDocument = new Document();
            String id = document.remove("_id").toString();
            newDocument.append("Cadena", document.get("Cadena")).append("fecha", document.get("fecha").toString());
            jsonObject.put(id,newDocument.toJson());
        }
        return jsonObject;
    }
}
