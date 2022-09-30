package  co.edu.escuelaing;

import static spark.Spark.*;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConexion {

    public static void main(String[] args) {
        port(getPort());
        post("/",(req, res)->{
            res.type("application/json");
            return insert(req.queryParams("value"));
        });
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static String insert(String a){
        try (MongoClient mongoClient = new MongoClient("db")) {
            MongoDatabase db = mongoClient.getDatabase("Lista");
            MongoCollection<org.bson.Document> collection = db.getCollection("datos");
            if(collection.countDocuments()==10){
                
            }
        }
        return a;

    }
}
