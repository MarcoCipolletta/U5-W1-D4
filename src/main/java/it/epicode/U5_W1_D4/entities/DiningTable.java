package it.epicode.U5_W1_D4.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "dining_tables")
public class DiningTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private int number;
    private int maxSeats;
    private boolean isOccupied;
}
