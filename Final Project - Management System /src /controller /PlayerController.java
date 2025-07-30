import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class PlayerController {

    // Player input states
    private boolean movingForward, movingBackward, strafingLeft, strafingRight;
    private boolean jumping, leftClickPressed, rightClickPressed;

    // Camera angles
    private double yaw = 0;
    private double pitch = 0;

    private double lastMouseX = -1;
    private double lastMouseY = -1;

    public void registerInputHandlers(Scene scene) {
        scene.setOnKeyPressed(this::handleKeyPressed);
        scene.setOnKeyReleased(this::handleKeyReleased);
        scene.setOnMousePressed(this::handleMousePressed);
        scene.setOnMouseReleased(this::handleMouseReleased);
        scene.setOnMouseMoved(this::handleMouseMoved);
    }

    private void handleKeyPressed(KeyEvent e) {
        KeyCode code = e.getCode();
        switch (code) {
            case W -> movingForward = true;
            case S -> movingBackward = true;
            case A -> strafingLeft = true;
            case D -> strafingRight = true;
            case SPACE -> jumping = true;
        }
    }

    private void handleKeyReleased(KeyEvent e) {
        KeyCode code = e.getCode();
        switch (code) {
            case W -> movingForward = false;
            case S -> movingBackward = false;
            case A -> strafingLeft = false;
            case D -> strafingRight = false;
            case SPACE -> jumping = false;
        }
    }

    private void handleMousePressed(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            leftClickPressed = true;
        } else if (e.getButton() == MouseButton.SECONDARY) {
            rightClickPressed = true;
        }
    }

    private void handleMouseReleased(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            leftClickPressed = false;
        } else if (e.getButton() == MouseButton.SECONDARY) {
            rightClickPressed = false;
        }
    }

    private void handleMouseMoved(MouseEvent e) {
        if (lastMouseX >= 0 && lastMouseY >= 0) {
            double deltaX = e.getX() - lastMouseX;
            double deltaY = e.getY() - lastMouseY;

            yaw += deltaX * 0.2;
            pitch -= deltaY * 0.2;

            // Clamp pitch to avoid flipping camera
            pitch = Math.max(-90, Math.min(90, pitch));
        }

        lastMouseX = e.getX();
        lastMouseY = e.getY();
    }

    // Getters to check input state from game loop
    public boolean isMovingForward() { return movingForward; }
    public boolean isMovingBackward() { return movingBackward; }
    public boolean isStrafingLeft() { return strafingLeft; }
    public boolean isStrafingRight() { return strafingRight; }
    public boolean isJumping() { return jumping; }
    public boolean isLeftClickPressed() { return leftClickPressed; }
    public boolean isRightClickPressed() { return rightClickPressed; }
    public double getYaw() { return yaw; }
    public double getPitch() { return pitch; }
}
