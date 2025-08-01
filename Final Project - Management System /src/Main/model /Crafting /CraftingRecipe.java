import java.util.Arrays;
import java.util.List;

public class CraftingRecipe {
    private List<Item> ingredients;
    private Item output;

    public CraftingRecipe(List<Item> ingredients, Item output) {
        this.ingredients = ingredients;
        this.output = output;
    }

    public List<Item> getIngredients() {
        return ingredients;
    }

    public Item getOutput() {
        return output;
    }

    // This method checks if the given items match the recipe
    public boolean matches(List<Item> craftingGridItems) {
        if (craftingGridItems.size() != ingredients.size()) {
            return false;
        }

        // Create copies to avoid modifying the original lists during sorting
        List<Item> sortedIngredients = new java.util.ArrayList<>(ingredients);
        List<Item> sortedCraftingGridItems = new java.util.ArrayList<>(craftingGridItems);

        sortedIngredients.sort( (item1, item2) -> item1.getName().compareTo(item2.getName()) );
        sortedCraftingGridItems.sort( (item1, item2) -> item1.getName().compareTo(item2.getName()) );

        // Compare the sorted lists
        for (int i = 0; i < sortedIngredients.size(); i++) {
            if (!sortedIngredients.get(i).equals(sortedCraftingGridItems.get(i))) {
                return false;
            }
        }
        return true;
    }
}
