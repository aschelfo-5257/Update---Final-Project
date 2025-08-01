import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String WINDOW_TITLE = "Block Craft Game";

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/game_ui.fxml"));
        Parent root = loader.load();

        // Inject your game logic using a factory for better separation
        Controller controller = loader.getController();
        BlockCraftGame game = BlockCraftGameFactory.createGame();
        controller.setGame(game);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle(WINDOW_TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
