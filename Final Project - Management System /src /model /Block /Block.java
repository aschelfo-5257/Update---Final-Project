import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents a block in a 3D world, with properties such as position, type, texture, and solidity.
 * A block may also have a name and visual texture.
 */
public class Block {
    private String name;
    private String texturePath;
    private boolean solid;
    private BlockType type;
    private int x, y, z;
    // Future properties (e.g., durability, light level) can be added here.

    /**
     * Constructs a Block with a specified type and coordinates in the world.
     * This constructor is useful when working with logical blocks placed in a 3D grid.
     *
     * @param type the type of the block (e.g., GRASS, STONE)
     * @param x    the X-coordinate of the block
     * @param y    the Y-coordinate of the block
     * @param z    the Z-coordinate of the block
     */
    public Block(BlockType type, int x, int y, int z) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Constructs a Block with a specified name, texture, and solidity.
     * This constructor is typically used for static definitions or display purposes.
     *
     * @param name        the name of the block
     * @param texturePath the path to the texture image
     * @param solid       whether the block is solid or passable
     */
    public Block(String name, String texturePath, boolean solid) {
        this.name = name;
        this.texturePath = texturePath;
        this.solid = solid;
    }

    /**
     * Gets the block type.
     *
     * @return the type of the block
     */
    public BlockType getType() {
        return type;
    }

    /**
     * Gets the X-coordinate of the block.
     *
     * @return the X-coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the Y-coordinate of the block.
     *
     * @return the Y-coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Gets the Z-coordinate of the block.
     *
     * @return the Z-coordinate
     */
    public int getZ() {
        return z;
    }

    /**
     * Gets the name of the block.
     *
     * @return the block's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the texture path of the block.
     *
     * @return the path to the texture image
     */
    public String getTexturePath() {
        return texturePath;
    }

    /**
     * Checks if the block is solid (i.e., cannot be passed through).
     *
     * @return true if solid, false if passable
     */
    public boolean isSolid() {
        return solid;
    }

    /**
     * Defines the different types of blocks available in the world.
     * These types may correspond to specific behaviors or appearances.
     */
    public enum BlockType {
        GRASS, DIRT, STONE, WOOD // Add more types as needed
    }
}
