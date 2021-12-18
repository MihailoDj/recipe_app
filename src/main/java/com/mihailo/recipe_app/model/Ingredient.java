package com.mihailo.recipe_app.model;

import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasurement unitOfMeasurement;

    public Ingredient() {

    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasurement unitOfMeasurement) {
        this.description = description;
        this.amount = amount;
        this.unitOfMeasurement = unitOfMeasurement;
    }

}
