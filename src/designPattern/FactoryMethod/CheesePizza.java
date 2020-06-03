package designPattern.FactoryMethod;

public class CheesePizza extends Pizza {
    @Override
    public void addIngredients() {
        System.out.println("Preparing Ingredients for cheese pizza.");
    }
}
