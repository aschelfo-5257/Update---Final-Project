public class Block {
  private BlockType type;
  private int x, y, z; // Coordinates in the World

  public Block(BlockType type, int x, int y, int z) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public BlockType getType() {
        return type;
    }
}
