import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// Block class holds block properties
public class Block {
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
}
