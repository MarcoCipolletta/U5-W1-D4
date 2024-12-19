package it.epicode.U5_W1_D4.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  long id;
    @OneToMany
    List<Topping> toppings = new ArrayList<>();
    @OneToMany
    List<Pizza> pizzas = new ArrayList<>();
    @OneToMany
    List<Drink> drinks = new ArrayList<>();

    public void stampaMenu() {
        System.out.println("Menu:");
        System.out.println("Pizze:");
        for (Pizza pizza : pizzas) {
            System.out.println(pizza.Descrizione() + " " + pizza.prezzo() + " " + pizza.calorie());
        }
        System.out.println("\nTopping:");
        for (Topping topping: toppings){
            System.out.println(topping.Descrizione()+ " " + topping.prezzo() + " " + topping.calorie());
        }
        System.out.println("\nBibite:");
        for (Drink bibita : drinks) {
            System.out.println(bibita.Descrizione() + " " + bibita.prezzo() + " " + bibita.calorie());
        }
        System.out.println();
    }
}
