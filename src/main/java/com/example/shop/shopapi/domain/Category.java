package com.example.shop.shopapi.domain;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name="category")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, unique=true) private String name;
    @Column(nullable=false, unique=true) private String slug;
}
