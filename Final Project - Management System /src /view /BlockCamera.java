import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class BlockCamera extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create 3D blocks
        Box box1 = new Box(1, 1, 1);
        box1.setTranslateX(0);
        box1.setTranslateY(0);
        box1.setTranslateZ(0);

        Box box2 = new Box(1, 1, 1);
        box2.setTranslateX(2);
        box2.setTranslateY(0);
        box2.setTranslateZ(0);

        // Create a group for the blocks
        Group world = new Group(box1, box2);

        // Create a camera with fixed eye position
        PerspectiveCamera camera = new PerspectiveCamera(true);

        // Set initial camera position and rotation
        camera.setTranslateX(-5);
        camera.setTranslateY(-5);
        camera.setTranslateZ(-10);
        camera.setRotationAxis(Rotate.Y_AXIS);
        camera.setRotate(45);

        // Create a scene with the world and camera
        Scene scene = new Scene(world, 800, 600, true);
        scene.setCamera(camera);

        // Add camera movement controls (simplified for example)
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W: camera.setTranslateZ(camera.getTranslateZ() + 1); break; // Move forward
                case S: camera.setTranslateZ(camera.getTranslateZ() - 1); break; // Move backward
                // Add more controls for left, right, up, down, rotate etc.
            }
        });

        // Set the scene and display the stage
        primaryStage.setTitle("Block Craft View");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
