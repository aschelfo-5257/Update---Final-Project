import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BlockLoader {
    private String name;
    private String texturePath;
    private boolean solid;

    public Block(String name, String texturePath, boolean solid) {
        this.name = name;
        this.texturePath = texturePath;
        this.solid = solid;
    }

    public String getName() {
        return name;
    }

    public String getTexturePath() {
        return texturePath;
    }

    public boolean isSolid() {
        return solid;
    }
  
    public static ImageView getBlockImageView(Block block) {
        Image image = new Image(BlockLoader.class.getResourceAsStream(block.getTexturePath()));
        ImageView imageView = new ImageView(image);
        return imageView;
    }
    public String getName() {
        return name;
    }
}
