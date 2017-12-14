package io.lker.recipes.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    // Need more than 255 chars.
    @Lob
    private String directions;

    // Ordinal: default, as 1,2,3
    // String: Gets string of Enum. String is best, surives
    // additions to Enum
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    // Mapped by = Property on child class. Defines relationship
    //  recipe is a variable in the Ingredient pojo
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    // Large object storage
    @Lob
    private Byte[] image;

    // Delete recipe, deletes notes.
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    // name the table RECIPE_CATEGORY
    // inverseJoin is Category pojo id variable
    //
    @ManyToMany
    @JoinTable(name = "RECIPE_CATEGORY",
        // Made join column name recipe_id, but join it with the category_id
        joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredient(Ingredient ingredient){
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }
}
