import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// Block class holds block properties
public class Block {
    private String name;
    private String texturePath;
    private boolean solid;
    private BlockType type;
    private int x, y, z;
    // ... other properties (e.g., durability, light level)

    public Block(BlockType type, int x, int y, int z) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Block(String name, String texturePath, boolean solid) {
        this.name = name;
        this.texturePath = texturePath;
        this.solid = solid;
    }

    public BlockType getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public String getName() {
        return name;
    }

    public String getTexturePath() {
        return texturePath;
    }

    public boolean isSolid() {
        return solid;
    }

    public enum BlockType {
    GRASS, DIRT, STONE, WOOD, // ... other block types
}
}
