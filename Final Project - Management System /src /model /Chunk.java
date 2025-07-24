public class Chunk {
    private BlockType[][][] blocks; // Assuming BlockType is an enum or class

    public Chunk() {
        // Initialize the chunk with air or a basic terrain
        blocks = new BlockType[16][256][16]; 
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                // Example: set bottom layer to stone, rest to air
                blocks[x][0][z] = BlockType.STONE; 
                for (int y = 1; y < 256; y++) {
                    blocks[x][y][z] = BlockType.AIR;
                }
            }
        }
    }

    public BlockType getBlock(int x, int y, int z) {
        // Add bounds checking for safety
        if (x >= 0 && x < 16 && y >= 0 && y < 256 && z >= 0 && z < 16) {
            return blocks[x][y][z];
        }
        return BlockType.AIR; // Or throw an exception for out-of-bounds access
    }

    public void setBlock(int x, int y, int z, BlockType type) {
        // Add bounds checking for safety
        if (x >= 0 && x < 16 && y >= 0 && y < 256 && z >= 0 && z < 16) {
            blocks[x][y][z] = type;
        }
    }
}
