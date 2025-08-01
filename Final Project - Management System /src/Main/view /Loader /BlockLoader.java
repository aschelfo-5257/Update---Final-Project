class BlockLoader { // BlockLoader handles visual representation
    public static ImageView getBlockImageView(Block block) {
        Image image = new Image(BlockLoader.class.getResourceAsStream(block.getTexturePath()));
        ImageView imageView = new ImageView(image);
        return imageView;
    }
}

// Set up Engine methods
class GameEngine {
    private static void setupInitialGameState() {
        // Set up player, world, etc.
    }

    private static void handleInput() {
        // Handle key presses, etc.
    }

    private static void updateGameState() {
        // Update physics, game rules, etc.
    }

    private static void renderGame() {
        // Draw to screen
    }

    private static void cleanupResources() {
        // Free memory, close streams, etc.
    }
}
