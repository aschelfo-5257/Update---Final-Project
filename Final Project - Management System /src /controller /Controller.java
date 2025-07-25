public class Controller {

    @FXML private Button placeBlockButton;
    @FXML private Slider blockSizeSlider;
    @FXML private Label selectedBlockLabel;

    private BlockCraftGame game; // Assuming a game logic class

    public void initialize() {
        // Initialize the controller
        // Set initial values for controls
        selectedBlockLabel.setText("Current Block: "); 
    }

    @FXML
    private void handlePlaceBlockAction() {
        // Logic to place a block in the game world
        game.placeBlock(); 
    }

    @FXML
    private void handleBlockSizeChange() {
        // Update block size in the game logic
        game.setBlockSize(blockSizeSlider.getValue());
    }

    public void setGame(BlockCraftGame game) {
        this.game = game;
    }
}
