import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Recipe {
    private final Map<String, Integer> ingredients; // Key = item name, Value = quantity
    private final String outputItem;
    private final int outputQuantity;

    public Recipe(Map<String, Integer> ingredients, String outputItem, int outputQuantity) {
        this.ingredients = Collections.unmodifiableMap(new HashMap<>(ingredients));
        this.outputItem = outputItem;
        this.outputQuantity = outputQuantity;
    }

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }

    public String getOutputItem() {
        return outputItem;
    }

    public int getOutputQuantity() {
        return outputQuantity;
    }

    // Checks if the provided ingredients match the recipe exactly
    public boolean matches(Map<String, Integer> inputIngredients) {
        return ingredients.equals(inputIngredients);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "ingredients=" + ingredients +
                ", outputItem='" + outputItem + '\'' +
                ", outputQuantity=" + outputQuantity +
                '}';
    }
}
