package it.epicode.U5_W1_D4.repo;

import it.epicode.U5_W1_D4.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    public Pizza findByName(String name);
    public List<Pizza> findByCaloriesGreaterThan(int calories);
}
