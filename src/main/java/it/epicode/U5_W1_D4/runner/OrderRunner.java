package it.epicode.U5_W1_D4.runner;

import it.epicode.U5_W1_D4.entities.*;
import it.epicode.U5_W1_D4.repo.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@org.springframework.core.annotation.Order(4)
public class OrderRunner implements ApplicationRunner {

    private final TableRepository tableRepo;
    private final OrderRepository orderRepo;
    private final PizzaRepository pizzaRepo;
    private final DrinkRepository drinkRepo;
    private final ToppingRepository toppingRepo;

    @Value("${order.cover.charge}")
    private double coverCharge;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("----------------------CoverCharge: " +coverCharge);
        // Inizializzazione di un tavolo
        DiningTable diningTable = new DiningTable();
        diningTable.setNumber(1);
        diningTable.setMaxSeats(4);
        diningTable.setOccupied(true);
        tableRepo.save(diningTable);

        // Creazione di un ordine
        ClientOrder clientOrder = new ClientOrder();
        clientOrder.setOrderNumber(1);
        clientOrder.setStatus("in corso");
        clientOrder.setNumberOfSeats(2);
        clientOrder.setOrderTime(LocalDateTime.now());
        clientOrder.setDiningTable(diningTable);

        // Aggiunta di elementi al menu
        List<Pizza> pizzas = pizzaRepo.findAll();
        List<Drink> drinks = drinkRepo.findAll();

        if (!pizzas.isEmpty()) {
            clientOrder.getMenuItems().add(pizzas.get(0));
        }
        if (!drinks.isEmpty()) {
            clientOrder.getMenuItems().add(drinks.get(0));
        }

        // Calcolo del totale
        clientOrder.calculateTotal(coverCharge);

        // Salvataggio e stampa dell'ordine
        orderRepo.save(clientOrder);
        System.out.println("Ordine creato: " + clientOrder);
    }
}
