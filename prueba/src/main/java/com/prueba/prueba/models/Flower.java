package com.prueba.prueba.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flowers")
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Flower implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer price;



    public Flower(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}
