package designPattern.FactoryMethod;

import org.junit.Test;

public class PizzaFactoryTest {
    @Test
    public void testMakePizza() {
        BasePizzaFactory pizzaFactory = new PizzaFactory();
        pizzaFactory.createPizza("cheese");
        pizzaFactory.createPizza("pepperoni");
    }
}
