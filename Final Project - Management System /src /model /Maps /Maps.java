import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.shape.Box;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.stage.Stage;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Maps extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BLOCK_SIZE = 50;

    private Group world = new Group();
    private PerspectiveCamera camera = new PerspectiveCamera(true);

    private double mousePosX, mousePosY;
    private double mouseOldX, mouseOldY;
    private Rotate cameraXRotate = new Rotate(0, Rotate.X_AXIS);
    private Rotate cameraYRotate = new Rotate(0, Rotate.Y_AXIS);
    private Translate cameraTranslate = new Translate(0, 0, -1000); // Initial camera position

    @Override
    public void start(Stage primaryStage) {
        // Create the scene and add camera and world
        Scene scene = new Scene(world, WIDTH, HEIGHT, true);
        scene.setFill(Color.SKYBLUE); // Set background color
        scene.setCamera(camera);

        // Add camera transformations for movement
        camera.getTransforms().addAll(
            cameraXRotate,
            cameraYRotate,
            cameraTranslate
        );

        // Generate a simple block world
        for (int x = -5; x < 5; x++) {
            for (int z = -5; z < 5; z++) {
                Box box = new Box(BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                PhongMaterial material = new PhongMaterial(Color.GREEN);
                box.setMaterial(material);
                box.setTranslateX(x * BLOCK_SIZE);
                box.setTranslateY(0); // Ground level
                box.setTranslateZ(z * BLOCK_SIZE);
                world.getChildren().add(box);
            }
        }

        // Mouse interaction for camera rotation
        scene.setOnMousePressed((MouseEvent me) -> {
            mousePosX = me.getSceneX();
            mousePosY = me.getSceneY();
            mouseOldX = me.getSceneX();
            mouseOldY = me.getSceneY();
        });

        scene.setOnMouseDragged((MouseEvent me) -> {
            mouseOldX = mousePosX;
            mouseOldY = mousePosY;
            mousePosX = me.getSceneX();
            mousePosY = me.getSceneY();

            cameraYRotate.setAngle(cameraYRotate.getAngle() - (mousePosX - mouseOldX));
            cameraXRotate.setAngle(cameraXRotate.getAngle() + (mousePosY - mouseOldY));
        });

        // Keyboard interaction for camera movement
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case W:
                    cameraTranslate.setZ(cameraTranslate.getZ() + 10);
                    break;
                case S:
                    cameraTranslate.setZ(cameraTranslate.getZ() - 10);
                    break;
                case A:
                    cameraTranslate.setX(cameraTranslate.getX() + 10);
                    break;
                case D:
                    cameraTranslate.setX(cameraTranslate.getX() - 10);
                    break;
            }
        });

        primaryStage.setTitle("Map Block Craft");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
