import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class MovingBlock extends Application {

    private double blockX = 0;
    private double blockY = 0;
    private Rectangle block;

    @Override
    public void start(Stage primaryStage) {
        block = new Rectangle(50, 50, 50, 50); // x, y, width, height
        Pane root = new Pane(block);
        Scene scene = new Scene(root, 400, 300);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.RIGHT) {
                blockX += 10;
                block.setTranslateX(blockX);
            } else if (e.getCode() == KeyCode.LEFT) {
                blockX -= 10;
                block.setTranslateX(blockX);
            } else if (e.getCode() == KeyCode.UP) {
                blockY -= 10;
                block.setTranslateY(blockY);
            } else if (e.getCode() == KeyCode.DOWN) {
                blockY += 10;
                block.setTranslateY(blockY);
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Moving Craft Block");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
