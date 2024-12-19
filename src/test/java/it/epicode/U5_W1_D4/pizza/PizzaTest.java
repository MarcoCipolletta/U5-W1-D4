package it.epicode.U5_W1_D4.pizza;
import it.epicode.U5_W1_D4.entities.Pizza;
import it.epicode.U5_W1_D4.entities.Topping;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PizzaTest {

    @Test
    @DisplayName("Test creazione pizza")
    public void testPizzaProperties() {
        Pizza pizza = new Pizza();
        pizza.setName("Margherita");
        pizza.setCalories(1000);
        pizza.setPrice(4.50);

        assertEquals("Margherita", pizza.getName());
        assertEquals(1000, pizza.getCalories());
        assertEquals(4.50, pizza.getPrice());
    }

    @Test
    @DisplayName("Test setCalories")
    public void testSetCalories() {
        Pizza pizza = new Pizza();
        pizza.setName("Custom");
        pizza.setCalories(1000);

        Topping cheese = new Topping();
        cheese.setCalories(200);
        pizza.getToppingList().add(cheese);

        pizza.setCalories();
        assertEquals(1200, pizza.getCalories());
    }
}