package com.makers.moneytree.db;
import com.makers.moneytree.model.UserObj;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDb {
    public static MongoClient mongoClient;
    public static MongoDatabase database;
    public static MongoCollection<Document> test;

    public static void main(String[] args) {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("moneytree");
        test = database.getCollection("test");


        UserObj userObj = new UserObj();
        userObj.setEmail("user@email");
        userObj.setName("user");
        userObj.setPassword("123");
        test.insertOne(convert(userObj));
//        here to recover what we have in the database
        Document query = new Document("name", "user");
        Document result = test.find(query).first();

        if (result != null) {
            System.out.println("Retrieved Document:" + result.toJson());
        } else {
            System.out.println("Document not found");
        }

    }
    public static Document convert(UserObj userObj){
        return new Document("name", userObj.getName())
                .append("email", userObj.getEmail())
                .append("password", userObj.getPassword());
    }
}