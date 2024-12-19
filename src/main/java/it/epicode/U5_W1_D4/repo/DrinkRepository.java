package it.epicode.U5_W1_D4.repo;

import it.epicode.U5_W1_D4.entities.Drink;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DrinkRepository extends JpaRepository<Drink, Long> {

}
