package com.example.nosqlproject.repository;

import com.example.nosqlproject.domain.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
    Item findByName(String name);
}