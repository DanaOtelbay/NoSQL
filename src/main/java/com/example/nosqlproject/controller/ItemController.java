package com.example.nosqlproject.controller;

import com.example.nosqlproject.domain.dto.ItemDTO;
import com.example.nosqlproject.domain.model.Item;
import com.example.nosqlproject.repository.ItemRepository;
import com.example.nosqlproject.service.ItemService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.MalformedURLException;
import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class ItemController {
    private ItemService itemService;

    @PostMapping("/item")
    public ResponseEntity<Object> createItem(@Valid @RequestBody ItemDTO itemDTO, BindingResult result) throws MalformedURLException{
        if(result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        ItemDTO createdItem = itemService.createItem(itemDTO);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemDTO>> getAllItems(){
        List<ItemDTO> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }
}
