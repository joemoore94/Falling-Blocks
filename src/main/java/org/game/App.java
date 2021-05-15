package org.game;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import static org.game.Utility.*;
import static org.game.Menu.*;
import static org.game.Play.*;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        STAGE = primaryStage;

        STAGE.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        STAGE.addEventHandler(KeyEvent.KEY_PRESSED,  keyboardEventHandler);

        stageMenu();

        STAGE.show();
    }

    public static EventHandler<KeyEvent> keyboardEventHandler = keyEvent -> {
        if (SCENE.getCurrentScene() == SCENE.scene.MENU) {
            switch (keyEvent.getCode().getCode()) {
                case 27: { // 27 = ESC key
                    STAGE.close();
                    break;
                }
                case 10: { // 10 = Enter key
                    stagePlay();
                    break;
                }
                case 32: { // 32 = Space key
                    stageInstructions();
                    break;
                }
                default: {
                    System.out.println("Unrecognized key");
                }
            }
        } else if (SCENE.getCurrentScene() == SCENE.scene.INSTRUCTIONS) {
            if (keyEvent.getCode().getCode() == 27) {
                stageMenu();
            }
        } else if (SCENE.getCurrentScene() == SCENE.scene.PLAY) {
            switch (keyEvent.getCode().getCode()) {
                case 27: { // 27 = ESC key
                    stageMenu();
                    break;
                }
                case 37: { // 37 = LEFT
                    if(position.X > 0 && LAYOUT.get(position.Y).get(position.X - 1) == 0) {
                        position.X--;
                        movePlayer();
                    }
                    break;
                }
                case 38: { // 38 = UP
                    if(position.Y > 0 && LAYOUT.get(position.Y - 1).get(position.X) == 0 ) {
                        position.Y--;
                        movePlayer();
                    }
                    break;
                }
                case 39: { // 39 = RIGHT
                    if(position.X < SIZE/UNIT - 1 && LAYOUT.get(position.Y).get(position.X + 1) == 0) {
                        position.X++;
                        movePlayer();
                    }
                    break;
                }
                case 40: { // 40 = DOWN
                    if(position.Y < SIZE/UNIT - 1 && LAYOUT.get(position.Y + 1).get(position.X) == 0) {
                        position.Y++;
                        movePlayer();
                    }
                    break;
                }
                default: {
                    System.out.println("Unrecognized key");
                }
            }
        }
    };

    public static EventHandler<MouseEvent> mouseEventHandler = mouseEvent -> {
        int y = (int) mouseEvent.getY() / UNIT;
        int x = (int) mouseEvent.getX() / UNIT;
        if (LAYOUT.get(y).get(x) == 0 && mouseEvent.getButton() == MouseButton.PRIMARY) {
            Blocks.getChildren().add(
                    new Rectangle(ORIGIN + UNIT(x),ORIGIN + UNIT(y), UNIT, UNIT)
            );
            LAYOUT.get(y).set(x, 1);
        } else if (LAYOUT.get(y).get(x) == 1 && mouseEvent.getButton() == MouseButton.SECONDARY) {
            Blocks.getChildren().remove(mouseEvent.getTarget());
            LAYOUT.get(y).set(x, 0);
        }
    };
}


