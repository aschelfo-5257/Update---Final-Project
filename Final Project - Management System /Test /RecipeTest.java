public class RecipeTest {
    private Map<Block.Type, Integer> ingredients = new HashMap<>();
    private Block.Type result;

    public Recipe(Map<Block.Type, Integer> ingredients, Block.Type result) {
        this.ingredients = ingredients;
        this.result = result;
    }

    public boolean matches(Map<Block.Type, Integer> input) {
        return input.equals(ingredients); // simple match; expand as needed
    }

    public Block.Type getResult() {
        return result;
    }
}
