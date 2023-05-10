package com.example.nosqlproject.service;

import com.example.nosqlproject.domain.dto.ItemDTO;
import com.example.nosqlproject.domain.model.Item;
import com.example.nosqlproject.repository.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ItemService {

    private ItemRepository itemRepository;

    public ItemDTO createItem(ItemDTO itemDTO) {
        Item item = convertToItem(itemDTO);
        Item savedItem = itemRepository.save(item);
        return convertToItemDTO(savedItem);
    }

    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return items.stream()
                .map(this::convertToItemDTO)
                .collect(Collectors.toList());
    }

    private Item convertToItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        item.setUrl(itemDTO.getUrl());
        return item;
    }

    private ItemDTO convertToItemDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setName(item.getName());
        itemDTO.setPrice(item.getPrice());
        itemDTO.setUrl(item.getUrl());
        return itemDTO;
    }

}
