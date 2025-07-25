import javafx.scene.Group;
import javafx.scene.shape.Box;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.image.Image;

public class BlockView extends Group {
    private Block block;
    private Box cube;

    public BlockView(Block block) {
        this.block = block;
        createBlockMesh();
    }

    private void createBlockMesh() {
        cube = new Box(1, 1, 1); // A 1x1x1 unit cube

        // Apply material (texture/color) based on block type
        PhongMaterial material = new PhongMaterial();
        Image texture = getTextureForBlockType(block.getType());
        material.setDiffuseMap(texture); 
        cube.setMaterial(material);

        // Set the block's position in the 3D world
        setTranslateX(block.getX() + 0.5); // Center the block
        setTranslateY(block.getY() + 0.5);
        setTranslateZ(block.getZ() + 0.5);

        getChildren().add(cube);
    }

    private Image getTextureForBlockType(BlockType type) {
        // Implement logic to load the correct texture image for each block type
        // For example:
        switch (type) {
            case GRASS:
                return new Image(getClass().getResourceAsStream("textures/grass_block_side.png"));
            case DIRT:
                return new Image(getClass().getResourceAsStream("textures/dirt.png"));
            // ... other block types
            default:
                return new Image(getClass().getResourceAsStream("textures/default.png"));
        }
    }
}
