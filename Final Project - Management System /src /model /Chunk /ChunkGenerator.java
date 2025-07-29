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
                double height = noise.getValue(worldX * 0.05, worldZ * 0.05); // Scale coordinates for desired terrain features
                int surfaceHeight = (int) (height * worldHeight * 0.5 + worldHeight * 0.3); // Map noise to a surface height

                // Fill the chunk with blocks based on the surface height
                for (int y = 0; y < worldHeight; y++) {
                    if (y < surfaceHeight - 5) {
                        chunkBlocks[x][y][z] = new Block(BlockType.STONE); // Deeper underground, assume stone
                    } else if (y < surfaceHeight) {
                        chunkBlocks[x][y][z] = new Block(BlockType.DIRT); // Below surface, dirt
                    } else if (y == surfaceHeight) {
                        chunkBlocks[x][y][z] = new Block(BlockType.GRASS); // At the surface, grass
                    } else {
                        chunkBlocks[x][y][z] = new Block(BlockType.AIR); // Above surface, air
                    }
                }
            }
        }
        return chunkBlocks;
    }
}
