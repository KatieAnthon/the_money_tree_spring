package com.makers.moneytree.db;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {
    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(mongoUri);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), databaseName);
    }
}



//    public static Document convertUserToDocument(User userObj){
//        return new Document("name", userObj.getName())
//                .append("email", userObj.getEmail())
//                .append("password", userObj.getPassword());
//    };
//    public static void main(String[] args) {
//        mongoClient = MongoClients.create(CONNECTION_STRING);
//        database = mongoClient.getDatabase(DATABASE_NAME);
//        users = database.getCollection("users");
//
//        User userObj = new User();
//        userObj.setEmail("user@email");
//        userObj.setName("user");
//        userObj.setPassword("123");
//        users.insertOne(convertUserToDocument(userObj));
////        here to recover what we have in the database
//        Document query = new Document("name", "user");
//        Document result = users.find(query).first();
//
//        if (result != null) {
//            System.out.println("Retrieved Document:" + result.toJson());
//        } else {
//            System.out.println("Document not found");
//        }
//
//    }
//}