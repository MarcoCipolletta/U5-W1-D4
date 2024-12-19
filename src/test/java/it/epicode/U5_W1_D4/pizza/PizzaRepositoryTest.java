package it.epicode.U5_W1_D4.pizza;
import it.epicode.U5_W1_D4.entities.Pizza;
import it.epicode.U5_W1_D4.repo.PizzaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PizzaRepositoryTest {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Test
    @DisplayName("Test save pizza")
    public void testSavePizza() {
        Pizza pizza = new Pizza();
        pizza.setName("TestPizza");
        pizza.setCalories(900);
        pizza.setPrice(6.50);

        Pizza savedPizza = pizzaRepository.save(pizza);
        assertNotNull(savedPizza.getId());
    }
}
