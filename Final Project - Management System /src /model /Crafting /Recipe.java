public class Recipe {
    private Map<String, Integer> ingredients; // Ingredient name and quantity
    private String outputItem;
    private int outputQuantity;

    public Recipe(Map<String, Integer> ingredients, String outputItem, int outputQuantity) {
        this.ingredients = ingredients;
        this.outputItem = outputItem;
        this.outputQuantity = outputQuantity;
    }

    // Getters for ingredients, outputItem, outputQuantity
    // ...
    public ingredients getIngredients() {
      return ingredients;
    }

    public outputItem getOutputItem() {
      return outputItem;
    }

    public outputQuantity getOutputQuantity() {
      return outputQuantity;
    }
}
