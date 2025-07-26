public class CraftingStationController { // Example Controller
    @FXML
    private GridPane craftingGrid; // Your crafting grid UI
    @FXML
    private Button craftButton;
    @FXML
    private ImageView resultSlot; // Displays the crafted item

    private List<Recipe> recipes; // List of available recipes
    private Inventory playerInventory;

    public void initialize() {
        // Load recipes (e.g., from a file or database)
        // Initialize playerInventory

        craftButton.setOnAction(event -> craftItem());
    }
