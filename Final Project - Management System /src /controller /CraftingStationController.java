import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.util.List;

public class CraftingStationController {
    @FXML
    private GridPane craftingGrid;
    @FXML
    private Button craftButton;
    @FXML
    private ImageView resultSlot;

    private List<Recipe> recipes;
    private Inventory playerInventory;

    public void initialize() {
        loadRecipes();
        initPlayerInventory();

        craftButton.setOnAction(event -> craftItem());
    }

    private void loadRecipes() {
        // Placeholder: load recipes from file or hardcode for now
    }

    private void initPlayerInventory() {
        // Placeholder: initialize the player's inventory
    }

    private void craftItem() {
        // 1. Gather input from craftingGrid
        // 2. Match a recipe
        // 3. Update resultSlot and modify inventory
    }
}
