public class ChunkGenerator {

    private final Noise noise; // An instance of your noise function (Perlin or Simplex)
    private final int chunkSize = 16;
    private final int worldHeight = 256;

    public ChunkGenerator(long seed) {
        this.noise = new Noise(seed); // Initialize noise with a seed
    }

    public Block[][][] generateChunk(int chunkX, int chunkZ) {
        Block[][][] chunkBlocks = new Block[chunkSize][worldHeight][chunkSize];

        for (int x = 0; x < chunkSize; x++) {
            for (int z = 0; z < chunkSize; z++) {
                // Calculate global coordinates for noise input
                int worldX = chunkX * chunkSize + x;
                int worldZ = chunkZ * chunkSize + z;
                
                // Generate a height value using the noise function
                double height = noise.getValue(worldX * 0.05, worldZ * 0.05);
                int surfaceHeight = BASE_TERRAIN_HEIGHT + (int)(height * HEIGHT_VARIATION);
                
                // Fill the chunk with blocks based on the surface height
                for (int y = 0; y <= surfaceHeight; y++) {
                    if (y == 0) chunkBlocks[x][y][z] = new Block(BlockType.BEDROCK);
                    else if (y < surfaceHeight - STONE_DEPTH) chunkBlocks[x][y][z] = new Block(BlockType.STONE);
                    else if (y < surfaceHeight) chunkBlocks[x][y][z] = new Block(BlockType.DIRT);
                    else chunkBlocks[x][y][z] = new Block(BlockType.GRASS);
                }
        
                for (int y = surfaceHeight + 1; y < worldHeight; y++) {
                    chunkBlocks[x][y][z] = new Block(BlockType.AIR);
                }
            }
        }
        return chunkBlocks;
    }
}
