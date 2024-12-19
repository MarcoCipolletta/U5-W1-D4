package it.epicode.U5_W1_D4.entities;


import it.epicode.U5_W1_D4.interfacces.IMenuItem;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "food_and_drink")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class FoodAndDrink implements IMenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;
    private double price;
    private int calories;
}
