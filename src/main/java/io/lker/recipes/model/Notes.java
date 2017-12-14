package io.lker.recipes.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(exclude = {"recipe"})
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // No cascade, can't delete the recipe it belongs to
    // if deleted
    @OneToOne
    private Recipe recipe;

    // Large object binary, don't have to worry about
    // size of string
    @Lob
    private String recipeNotes;

}
