package it.epicode.U5_W1_D4.entities;


import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Drink extends FoodAndDrink {


    @Override
    public String Descrizione() {

        return this.getName();
    }

    @Override
    public String prezzo() {
        return this.getPrice() + "€";
    }

    @Override
    public String calorie() {
        return this.getCalories() + " kcal";
    }
}

