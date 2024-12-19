package it.epicode.U5_W1_D4.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@jakarta.persistence.Table(name = "client_orders")
public class ClientOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private int orderNumber;
    private String status; // Values: "in corso", "pronto", "servito"
    private int numberOfSeats;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderTime;

    private double totalAmount;

    @ManyToOne
    private DiningTable diningTable;

    @ManyToMany
    private List<FoodAndDrink> menuItems = new ArrayList<>();

    public void calculateTotal(double coverCharge) {
        totalAmount = coverCharge * numberOfSeats;
        for (FoodAndDrink item : menuItems) {
            totalAmount += item.getPrice();
        }
    }
}
