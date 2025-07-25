import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game_ui.fxml"));
        Parent root = loader.load();

        // Inject your game logic
        Controller controller = loader.getController();
        BlockCraftGame game = new BlockCraftGame();
        controller.setGame(game);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Block Craft Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
