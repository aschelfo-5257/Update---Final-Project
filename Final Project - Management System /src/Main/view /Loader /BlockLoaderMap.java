import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class BlockLoaderMap {

    public static List<Map<String, Object>> loadBlockDefinitionsAsMap(String jsonFilePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = BlockLoaderMap.class.getResourceAsStream(jsonFilePath)) {
            if (is == null) {
                throw new IOException("Resource not found: " + jsonFilePath);
            }
            return mapper.readValue(is, new TypeReference<List<Map<String, Object>>>() {});
        }
    }

    public static void main(String[] args) {
        try {
            List<Map<String, Object>> blocks = loadBlockDefinitionsAsMap("/blocks.json");
            for (Map<String, Object> block : blocks) {
                System.out.println("Block ID: " + block.get("id"));
                if (block.containsKey("crafting")) {
                    Map<String, Object> crafting = (Map<String, Object>) block.get("crafting");
                    System.out.println("  Craftable: " + crafting.get("craftable"));
                    if (crafting.containsKey("ingredients")) {
                        List<Map<String, Object>> ingredients = (List<Map<String, Object>>) crafting.get("ingredients");
                        for (Map<String, Object> ingredient : ingredients) {
                            System.out.println("    Ingredient: " + ingredient.get("item") + " (x" + ingredient.get("quantity") + ")");
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading block definitions: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
