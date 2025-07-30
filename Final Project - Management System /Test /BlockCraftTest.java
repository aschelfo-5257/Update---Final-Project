public class BlockCraftTest {
    public static void main(String[] args) {
        // Create blocks
        Block woodBlock = new Block(Block.Type.WOOD);
        Block stoneBlock = new Block(Block.Type.STONE);

        // Create recipe: 2 WOOD -> 1 STONE
        Map<Block.Type, Integer> ingredients = new HashMap<>();
        ingredients.put(Block.Type.WOOD, 2);
        Recipe recipe = new Recipe(ingredients, Block.Type.STONE);

        // Set up crafting system
        CraftingSystem system = new CraftingSystem();
        system.addRecipe(recipe);

        // Try crafting with input
        Map<Block.Type, Integer> input = new HashMap<>();
        input.put(Block.Type.WOOD, 2);

        Optional<Block.Type> crafted = system.craft(input);
        System.out.println("Crafted: " + crafted.orElse(null));
    }
}
