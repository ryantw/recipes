package io.lker.recipes.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    // Mapped by recipes 'categories' property name
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

}
