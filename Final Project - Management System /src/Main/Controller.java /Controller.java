public class Controller {

    @FXML private Button placeBlockButton;
    @FXML private Slider blockSizeSlider;
    @FXML private Label selectedBlockLabel;

    private BlockCraftGame game;

    public void initialize() {
        selectedBlockLabel.setText("Current Block: None");

        // Respond to slider value changes
        blockSizeSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (game != null) {
                game.setBlockSize(newVal.doubleValue());
            }
        });
    }

    @FXML
    private void handlePlaceBlockAction() {
        if (game != null) {
            game.placeBlock();
        } else {
            selectedBlockLabel.setText("Error: Game logic not set.");
        }
    }

    /**
     * Sets the game logic reference for this controller.
     * @param game the game logic object; BlockCraftGame represents the main game logic and state for the block crafting system.
     */
    public void setGame(BlockCraftGame game) {
        this.game = game;
    }
}
