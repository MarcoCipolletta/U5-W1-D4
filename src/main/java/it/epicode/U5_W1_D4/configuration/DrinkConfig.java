package it.epicode.U5_W1_D4.configuration;

import it.epicode.U5_W1_D4.entities.Drink;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DrinkConfig {

    @Bean(name = "water")
    public Drink water(){
        Drink drink = new Drink();
        drink.setCalories(0);
        drink.setName("Water");
        drink.setPrice(1.00);
        return drink;
    }
    @Bean(name = "lemonsoda")
    public Drink lemonsoda(){
        Drink drink = new Drink();
        drink.setCalories(128);
        drink.setName("Lemonsoda");
        drink.setPrice(2.50);
        return drink;
    }

    @Bean(name = "wine")
    public Drink wine(){
        Drink drink = new Drink();
        drink.setCalories(607);
        drink.setName("wine");
        drink.setPrice(5.50);
        return drink;
    }
}