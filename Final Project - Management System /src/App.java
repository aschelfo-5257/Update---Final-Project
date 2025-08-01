public class BlockCraftGame {
    private static boolean isRunning = true;

    public static void main(String[] args) {
        GraphicsInitializer.initialize();
        GameWindowCreator.create();
        ResourceLoader.load();
        InitialGameStateSetup.setup();

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (isRunning) {
            InputHandler.handle();
            GameStateUpdater.update();
            GameRenderer.render();

            System.out.print("Type 'exit' to quit or press Enter to continue: ");
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input.trim())) {
                isRunning = false;
            }
        }

        ResourceCleaner.cleanup();
    }
}
