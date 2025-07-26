private void craftItem() {
        // Get items from crafting grid
        Map<String, Integer> craftingGridItems = getItemsFromCraftingGrid();

        // Find matching recipe
        Recipe matchingRecipe = findMatchingRecipe(craftingGridItems);

        if (matchingRecipe != null) {
            // Check if player has enough ingredients
            boolean hasEnoughIngredients = true;
            for (Map.Entry<String, Integer> entry : matchingRecipe.getIngredients().entrySet()) {
                if (!playerInventory.hasItem(entry.getKey(), entry.getValue())) {
                    hasEnoughIngredients = false;
                    break;
                }
            }

            if (hasEnoughIngredients) {
                // Remove ingredients from inventory
                for (Map.Entry<String, Integer> entry : matchingRecipe.getIngredients().entrySet()) {
                    playerInventory.removeItem(entry.getKey(), entry.getValue());
                }

                // Add crafted item to inventory
                playerInventory.addItem(matchingRecipe.getOutputItem(), matchingRecipe.getOutputQuantity());

                // Update UI (inventory and result slot)
                // ...
            } else {
                // Display message: not enough ingredients
            }
        } else {
            // Display message: no matching recipe
        }
    }

    private Map<String, Integer> getItemsFromCraftingGrid() {
        // Logic to extract items and quantities from the crafting grid UI
        return new HashMap<>(); // Placeholder
    }

    private Recipe findMatchingRecipe(Map<String, Integer> craftingGridItems) {
        // Logic to iterate through recipes and find a match
        return null; // Placeholder
    }
}
