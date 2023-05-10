package com.example.nosqlproject.domain.model;

import java.net.URL;

import javax.annotation.processing.Generated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "items")
public class Item {
    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private Double price;

    private String description;

    @NotNull
    private String imageUrl;
}

