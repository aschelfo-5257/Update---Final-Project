import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class ChunkBorder extends Application {

    private static final int CHUNK_SIZE = 16; // 16x16 blocks
    private static final double BLOCK_SIZE = 1.0; // Size of each block

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        // Create a chunk border
        Group chunkBorder = createChunkBorder(0, 0, 0); // Position at x=0, y=0, z=0

        root.getChildren().add(chunkBorder);

        // Add a camera to view the scene
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateX(-5);
        camera.setTranslateY(-5);
        camera.setTranslateZ(-15);

        Scene scene = new Scene(root, 800, 600, true);
        scene.setCamera(camera);

        primaryStage.setTitle("Chunk Border in JavaFX 3D");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Group createChunkBorder(double chunkX, double chunkY, double chunkZ) {
        Group borderGroup = new Group();

        // Create the border blocks along the edges of the chunk
        for (int i = 0; i < CHUNK_SIZE; i++) {
            // Top border (X-axis)
            Box topBlock1 = createBorderBlock();
            topBlock1.setTranslateX(chunkX + i * BLOCK_SIZE);
            topBlock1.setTranslateY(chunkY);
            topBlock1.setTranslateZ(chunkZ);
            borderGroup.getChildren().add(topBlock1);

            Box topBlock2 = createBorderBlock();
            topBlock2.setTranslateX(chunkX + i * BLOCK_SIZE);
            topBlock2.setTranslateY(chunkY);
            topBlock2.setTranslateZ(chunkZ + CHUNK_SIZE * BLOCK_SIZE);
            borderGroup.getChildren().add(topBlock2);

            // Side border (Z-axis)
            Box sideBlock1 = createBorderBlock();
            sideBlock1.setTranslateX(chunkX);
            sideBlock1.setTranslateY(chunkY);
            sideBlock1.setTranslateZ(chunkZ + i * BLOCK_SIZE);
            borderGroup.getChildren().add(sideBlock1);

            Box sideBlock2 = createBorderBlock();
            sideBlock2.setTranslateX(chunkX + CHUNK_SIZE * BLOCK_SIZE);
            sideBlock2.setTranslateY(chunkY);
            sideBlock2.setTranslateZ(chunkZ + i * BLOCK_SIZE);
            borderGroup.getChildren().add(sideBlock2);
        }

        return borderGroup;
    }

    private Box createBorderBlock() {
        Box block = new Box(BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
        // You can customize the block's appearance here
        // For example, set a different color or material
        // block.setMaterial(new PhongMaterial(Color.RED));
        return block;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
