package it.epicode.U5_W1_D4.runner;


import it.epicode.U5_W1_D4.entities.Drink;
import it.epicode.U5_W1_D4.repo.DrinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Order(2)
public class DrinkRunner implements ApplicationRunner {

    private final DrinkRepository drinkRepo;
    private final Drink water;
    private final Drink lemonsoda;
    private final Drink wine;
    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        drinkRepo.save(water);
        drinkRepo.save(lemonsoda);
        drinkRepo.save(wine);
    }
}