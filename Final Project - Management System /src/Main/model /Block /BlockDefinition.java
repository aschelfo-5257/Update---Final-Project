public class BlockDefinition {
    private String id;
    private String name;
    private String texturePath;
    private int durability;
    private boolean solid;
    private CraftingDefinition crafting; // Nested object

    // Constructors, getters, setters (and a default constructor for Jackson)
    public BlockDefinition() {}

    public BlockDefinition(String id, String name, String texturePath, int durability, boolean solid, CraftingDefinition crafting) {
        this.id = id;
        this.name = name;
        this.texturePath = texturePath;
        this.durability = durability;
        this.solid = solid;
        this.crafting = crafting;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTexturePath() { return texturePath; }
    public void setTexturePath(String texturePath) { this.texturePath = texturePath; }

    public int getDurability() { return durability; }
    public void setDurability(int durability) { this.durability = durability; }

    public boolean isSolid() { return solid; }
    public void setSolid(boolean solid) { this.solid = solid; }

    public CraftingDefinition getCrafting() { return crafting; }
    public void setCrafting(CraftingDefinition crafting) { this.crafting = crafting; }
}

public class CraftingDefinition {
    private List<Ingredient> ingredients; // Nested array of objects
    private boolean craftable;

    // Constructors, getters, setters (and a default constructor for Jackson)
    public CraftingDefinition() {}

    public CraftingDefinition(List<Ingredient> ingredients, boolean craftable) {
        this.ingredients = ingredients;
        this.craftable = craftable;
    }

    public List<Ingredient> getIngredients() { return ingredients; }
    public void setIngredients(List<Ingredient> ingredients) { this.ingredients = ingredients; }

    public boolean isCraftable() { return craftable; }
    public void setCraftable(boolean craftable) { this.craftable = craftable; }
}

public class Ingredient {
    private String item;
    private int quantity;

    // Constructors, getters, setters (and a default constructor for Jackson)
    public Ingredient() {}

    public Ingredient(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
