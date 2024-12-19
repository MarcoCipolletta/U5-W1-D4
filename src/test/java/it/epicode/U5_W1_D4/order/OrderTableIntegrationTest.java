package it.epicode.U5_W1_D4.order;

import it.epicode.U5_W1_D4.entities.ClientOrder;
import it.epicode.U5_W1_D4.entities.DiningTable;
import it.epicode.U5_W1_D4.repo.OrderRepository;
import it.epicode.U5_W1_D4.repo.TableRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class OrderTableIntegrationTest {

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testOrderWithTable() {
        DiningTable table = new DiningTable();
        table.setNumber(1);
        table.setMaxSeats(4);
        table.setOccupied(true);
        DiningTable savedTable = tableRepository.save(table);

        ClientOrder order = new ClientOrder();
        order.setOrderNumber(1);
        order.setNumberOfSeats(2);
        order.setDiningTable(table);
        orderRepository.save(order);

        DiningTable foundTable = tableRepository.findById(savedTable.getId()).get();
        assertTrue(savedTable.isOccupied());
    }
}
