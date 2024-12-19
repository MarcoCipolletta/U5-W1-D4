package it.epicode.U5_W1_D4.order;

import it.epicode.U5_W1_D4.entities.ClientOrder;
import it.epicode.U5_W1_D4.entities.Pizza;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTotalTest {

    @ParameterizedTest
    @CsvSource({
            "1, 5.50, 2, 2.50, 10.50",
            "2, 8.00, 3, 3.00, 17.00",
            "0, 0.00, 1, 1.50, 1.50"
    })
    public void testCalculateTotal(int pizzas, double pizzaPrice, int covers, double coverCharge, double expectedTotal) {
        ClientOrder order = new ClientOrder();
        order.setNumberOfSeats(covers);

        for (int i = 0; i < pizzas; i++) {
            Pizza pizza = new Pizza();
            pizza.setPrice(pizzaPrice);
            order.getMenuItems().add(pizza);
        }

        order.calculateTotal(coverCharge);
        assertEquals(expectedTotal, order.getTotalAmount());
    }
}
