import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Loader {

    public static List<BlockDefinition> loadBlockDefinitions(String jsonFilePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // Get the InputStream for the resource
        try (InputStream is = BlockLoader.class.getResourceAsStream(jsonFilePath)) {
            if (is == null) {
                throw new IOException("Resource not found: " + jsonFilePath);
            }
            // Read the JSON and deserialize it into a List of BlockDefinition objects
            return mapper.readValue(is, new TypeReference<List<BlockDefinition>>() {});
        }
    }

    public static void main(String[] args) {
        try {
            List<BlockDefinition> blocks = loadBlockDefinitions("/blocks.json"); // Note the leading slash for resource path
            for (BlockDefinition block : blocks) {
                System.out.println("Block ID: " + block.getId() + ", Name: " + block.getName() + ", Solid: " + block.isSolid());
            }
        } catch (IOException e) {
            System.err.println("Error loading block definitions: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
