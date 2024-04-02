package com.makers.moneytree.repository;

import com.makers.moneytree.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public UserService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    public User findUserByName(String name) {
        return mongoTemplate.findById(name, User.class);
    }
}
