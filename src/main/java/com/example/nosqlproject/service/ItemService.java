package com.example.nosqlproject.service;

import com.example.nosqlproject.domain.dto.ItemDTO;
import com.example.nosqlproject.domain.model.Item;
import com.example.nosqlproject.repository.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(String id) {
        return itemRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item not found with id " + id));
    }

    public Item getItemByName(String name) {
        return itemRepository.findByName(name);
    }

    public void deleteItemById(String id) {
        itemRepository.deleteById(id);
    }
}

