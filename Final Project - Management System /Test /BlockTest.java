public class BlockTest {
    public enum Type { WOOD, STONE, DIRT }

    private Type type;

    public Block(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
