import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;


public class TextureLoader {
    public static BufferedImage loadImage(String path) {
        // Assuming you have a BufferedImage 'textureImage'
        // and have set up OpenGL context

        int textureID = GL11.glGenTextures();
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureID);

        // Set texture parameters (e.g., filtering, wrapping)
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);

        /**
         * Convert BufferedImage to ByteBuffer for OpenGL
         * (This part requires more advanced image manipulation for pixel data)
         *
         * Upload texture data
         * GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, width, height, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, byteBuffer);
         *
         * When rendering your block
         * GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureID);
         * Render your block's faces with appropriate texture coordinates
         *
        **/
          try {
          return ImageIO.read(new File(path));
          } catch (IOException e) {
          e.printStackTrace();
          return null;
        }
    }
}
