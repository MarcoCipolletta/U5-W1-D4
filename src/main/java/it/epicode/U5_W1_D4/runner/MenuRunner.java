package it.epicode.U5_W1_D4.runner;


import it.epicode.U5_W1_D4.entities.Drink;
import it.epicode.U5_W1_D4.entities.Menu;
import it.epicode.U5_W1_D4.entities.Pizza;
import it.epicode.U5_W1_D4.entities.Topping;
import it.epicode.U5_W1_D4.repo.DrinkRepository;
import it.epicode.U5_W1_D4.repo.MenuRepository;
import it.epicode.U5_W1_D4.repo.PizzaRepository;
import it.epicode.U5_W1_D4.repo.ToppingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Order(3)
public class MenuRunner implements ApplicationRunner {
    private final MenuRepository menuRepo;
    private final PizzaRepository pizzaRepo;
    private final DrinkRepository drinkRepo;
    private final ToppingRepository toppingRepo;
    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {


        Menu menu = new Menu();
        List<Pizza> pizze = pizzaRepo.findAll();
        List<Drink> drinks = drinkRepo.findAll();
        List<Topping> toppings = toppingRepo.findAll();
        menu.setPizzas(pizze);
        menu.setToppings(toppings);
        menu.setDrinks(drinks);

        menuRepo.save(menu);

        menu.stampaMenu();



    }
}