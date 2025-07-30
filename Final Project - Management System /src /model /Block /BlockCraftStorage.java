import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class BlockCraftStorage extends Application {

    private static final double BLOCK_SIZE = 50.0;
    private Group root = new Group();

    @Override
    public void start(Stage primaryStage) {
        // Scene setup
        Scene scene = new Scene(root, 800, 600, true); // Enable depth buffer
        scene.setFill(Color.LIGHTSKYBLUE);

        // Camera setup
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setNearClip(0.1);
        camera.setFarClip(10000.0);
        camera.getTransforms().addAll(new Rotate(20, Rotate.Y_AXIS), new Rotate(-20, Rotate.X_AXIS), new Translate(0, 0, -800));
        scene.setCamera(camera);

        // Add a sample block
        addBlock(0, 0, 0, Color.GREEN);

        // Mouse click handler for placing blocks
        scene.setOnMouseClicked(event -> {
            //  Simplified logic: You'd need raycasting to accurately determine block placement position
            // For now, let's just add a block at a fixed offset from the existing block
            addBlock(BLOCK_SIZE * 1, 0, 0, Color.RED); 
        });


        primaryStage.setTitle("3D Block Craft Storage");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addBlock(double x, double y, double z, Color color) {
        Box box = new Box(BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
        box.setMaterial(new PhongMaterial(color));
        box.getTransforms().addAll(new Translate(x, y, z));
        root.getChildren().add(box);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
