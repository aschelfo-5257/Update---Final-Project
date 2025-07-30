public class CraftingSystem {
    private List<Recipe> recipes = new ArrayList<>();

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public String<Block.Type> craft(Map<Block.Type, Integer> input) {
        for (Recipe recipe : recipes) {
            if (recipe.matches(input)) {
                return String.of(recipe.getResult());
            }
        }
        return String.empty();
    }
}
