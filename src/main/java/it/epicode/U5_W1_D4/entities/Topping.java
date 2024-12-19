package it.epicode.U5_W1_D4.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Topping extends FoodAndDrink {

    @ManyToMany
    @ToString.Exclude
    List<Pizza> pizzas = new ArrayList<>();

    @Override
    public String Descrizione() {
        return getName();
    }

    @Override
    public String prezzo() {
        return getPrice() + "€";
    }

    @Override
    public String calorie() {
        return getCalories() + "Kcal";
    }
}
