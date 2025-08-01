private void craftItem() {
    Map<String, Integer> craftingGridItems = getItemsFromCraftingGrid();
    Recipe matchingRecipe = findMatchingRecipe(craftingGridItems);

    if (matchingRecipe == null) {
        displayMessage("No matching recipe found.");
        return;
    }

    for (Map.Entry<String, Integer> entry : matchingRecipe.getIngredients().entrySet()) {
        if (!playerInventory.hasItem(entry.getKey(), entry.getValue())) {
            displayMessage("Not enough ingredients to craft.");
            return;
        }
    }

    // All ingredients available – proceed to remove
    for (Map.Entry<String, Integer> entry : matchingRecipe.getIngredients().entrySet()) {
        playerInventory.removeItem(entry.getKey(), entry.getValue());
    }

    // Add crafted item
    playerInventory.addItem(matchingRecipe.getOutputItem(), matchingRecipe.getOutputQuantity());

    updateUI(); // e.g., refresh grid and inventory display
    displayMessage("Item crafted: " + matchingRecipe.getOutputItem());
}
