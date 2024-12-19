package it.epicode.U5_W1_D4.configuration;

import it.epicode.U5_W1_D4.entities.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToppingConfig {
    @Bean(name = "toppings_tomato")
    public Topping toppingTomatoBean() {
        Topping t = new Topping();
        t.setCalories(0);
        t.setName("Tomato");
        t.setPrice(0);
        return t;
    }

    @Bean(name = "toppings_cheese")
    public Topping toppingCheeseBean() {
        Topping t = new Topping();
        t.setCalories(92);
        t.setName("Cheese");
        t.setPrice(0.69);
        return t;

    }

    @Bean(name = "toppings_ham")
    public Topping toppingHamBean() {
        Topping t = new Topping();
        t.setCalories(35);
        t.setName("Ham");
        t.setPrice(0.99);
        return t;
    }

    @Bean(name = "toppings_pineapple")
    public Topping toppingPineappleBean() {
        Topping t = new Topping();
        t.setCalories(24);
        t.setName("Pineapple");
        t.setPrice(0.79);
        return t;
    }

    @Bean(name = "toppings_salami")
    public Topping toppingSalamiBean() {
        Topping t = new Topping();
        t.setCalories(86);
        t.setName("Salami");
        t.setPrice(0.99);
        return t;
    }
}
