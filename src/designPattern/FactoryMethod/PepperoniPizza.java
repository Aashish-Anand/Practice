package designPattern.FactoryMethod;

public class PepperoniPizza extends Pizza{
    @Override
    public void addIngredients() {
        System.out.println("Preparing Ingredients for Pepperoni Pizza.");
    }
}
