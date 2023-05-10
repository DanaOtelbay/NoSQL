package com.example.nosqlproject.domain.dto;


import lombok.*;
import java.net.URL;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private String id;
    private int price;
    private String name;
    private URL url;
}
