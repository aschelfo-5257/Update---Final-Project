import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import org.lwjgl.opengl.GL11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;

public class TextureLoader {

    public static int loadTexture(String path) {
        Image image;
        try {
            image = new Image(new FileInputStream(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return -1;
        }

        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        PixelReader reader = image.getPixelReader();
        if (reader == null) {
            System.err.println("PixelReader is null for image: " + path);
            return -1;
        }

        // Prepare ByteBuffer for OpenGL RGBA pixel data
        byte[] pixels = new byte[width * height * 4];
        reader.getPixels(0, 0, width, height, PixelFormat.getByteBgraInstance(), pixels, 0, width * 4);

        // JavaFX uses BGRA; convert to RGBA for OpenGL
        for (int i = 0; i < pixels.length; i += 4) {
            byte b = pixels[i];
            pixels[i] = pixels[i + 2];     // R <- B
            pixels[i + 2] = b;             // B <- R
        }

        ByteBuffer buffer = ByteBuffer.allocateDirect(pixels.length);
        buffer.put(pixels);
        buffer.flip();

        // Upload to OpenGL
        int textureID = GL11.glGenTextures();
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureID);

        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);

        GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA8, width, height, 0,
                          GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, buffer);

        return textureID;
    }
}
