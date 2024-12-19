package it.epicode.U5_W1_D4.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Pizza extends FoodAndDrink{

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<Topping> toppingList = new ArrayList<>();

    public void setCalories(){
        int calories = 1000;
        if (!toppingList.isEmpty()){
            for (int i = 0; i < toppingList.size(); i++) {
                Topping topping = toppingList.get(i);
                calories += topping.getCalories();
            }
            setCalories(calories);
        }
    }

    public void setPrice(){
        double price = 4.40;
        if (!toppingList.isEmpty()){
            for (int i = 0; i < toppingList.size(); i++) {
                Topping topping = toppingList.get(i);
                price += topping.getPrice();
            }
            setPrice(price);
        }
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + getName() + '\'' +
                ", calories=" + getCalories() +
                ", price=" + getPrice() +
                ", toppingList=" + toppingList +
                '}';
    }


    @Override
    public String Descrizione() {
        String nome = this.getName() + " (";

        // inserisce i nomi dei toppings
        // alla fine c'è una virgola in più)
        for (Topping topping : toppingList) {
            nome += topping.getName() + ", ";
        }

        // rimuove l'ultima virgola e concatena  una parentesi chiusa
        return nome.substring(0, nome.length() - 2) + ")";

    }

    @Override
    public String prezzo() {
        return getPrice() + "€";
    }

    @Override
    public String calorie() {
        return getCalories() + "Kcal ";
    }
}
