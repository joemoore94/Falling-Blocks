package org.game;

import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static org.game.Utility.*;

public class Menu {
    static Group root = new Group();
    static Group instructionRoot = new Group();
    static Scene scene = new Scene(root, SIZE, SIZE, Color.CYAN);
    static Scene instructions = new Scene(instructionRoot, SIZE, SIZE, Color.CYAN);

    static boolean sceneSet = false;

    public static void stageMenu() {
        SCENE.switchToMenu();
        System.out.println(SCENE.getCurrentScene());

        if(!sceneSet)
            setMenuScene();

        STAGE.setScene(scene);
    }

    public static void stageInstructions() {
        SCENE.switchToInstructions();
        System.out.println(SCENE.getCurrentScene());

        if(!sceneSet)
            setMenuScene();

        STAGE.setScene(instructions);
    }

    public static void setMenuScene() {
        Text playText = new Text("PLAY");
        playText.setTextOrigin(VPos.CENTER);
        playText.setFont(new Font(UNIT(3)));
        playText.setLayoutX((SIZE - playText.prefWidth(-1)) / 2);
        playText.setLayoutY(SIZE / 6);
        playText.setFill(Color.WHITE);

        Text enterText = new Text("(PRESS ENTER)");
        enterText.setTextOrigin(VPos.CENTER);
        enterText.setFont(new Font(UNIT(1)));
        enterText.setLayoutX((SIZE - enterText.prefWidth(-1)) / 2);
        enterText.setLayoutY(SIZE / 6 + UNIT(2));
        enterText.setFill(Color.WHITE);

        Text instructionText = new Text("INSTRUCTIONS");
        instructionText.setTextOrigin(VPos.CENTER);
        instructionText.setFont(new Font(UNIT(2)));
        instructionText.setLayoutX((SIZE - instructionText.prefWidth(-1)) / 2);
        instructionText.setLayoutY(SIZE / 6 + UNIT(6));
        instructionText.setFill(Color.WHITE);

        Text spaceText = new Text("(PRESS SPACE)");
        spaceText.setTextOrigin(VPos.CENTER);
        spaceText.setFont(new Font(UNIT(1)));
        spaceText.setLayoutX((SIZE - spaceText.prefWidth(-1)) / 2);
        spaceText.setLayoutY(SIZE / 6 + UNIT(8));
        spaceText.setFill(Color.WHITE);

        Text quitText = new Text("QUIT");
        quitText.setTextOrigin(VPos.CENTER);
        quitText.setFont(new Font(UNIT(2)));
        quitText.setLayoutX((SIZE - quitText.prefWidth(-1)) / 2);
        quitText.setLayoutY(SIZE / 6 + UNIT(12));
        quitText.setFill(Color.WHITE);

        Text escapeText = new Text("(PRESS ESC)");
        escapeText.setTextOrigin(VPos.CENTER);
        escapeText.setFont(new Font(UNIT(1)));
        escapeText.setLayoutX((SIZE - escapeText.prefWidth(-1)) / 2);
        escapeText.setLayoutY(SIZE / 6 + UNIT(14));
        escapeText.setFill(Color.WHITE);

        root.getChildren().add(playText);
        root.getChildren().add(enterText);
        root.getChildren().add(instructionText);
        root.getChildren().add(spaceText);
        root.getChildren().add(quitText);
        root.getChildren().add(escapeText);

        setInstructionsScene();

        sceneSet = true;
    }

    public static void setInstructionsScene() {
        Text rulesText = new Text(
                "Avoid the black Boxes falling \nfrom the sky. You" +
                        "may move \nwherever you want on the \nscreen, " +
                        "just don't get trapped. \nThe boxes will push " +
                        "you down \nand once you are pushed below \nthe " +
                        "bottom edge, you lose! Use \nthe arrow keys to " +
                        "move. Press \nESC to return the main Menu."
        );
        rulesText.setTextOrigin(VPos.CENTER);
        rulesText.setFont(new Font(UNIT));
        rulesText.setLayoutX((SIZE - rulesText.prefWidth(-1)) / 2);
        rulesText.setLayoutY(SIZE / 2);
        rulesText.setFill(Color.WHITE);

        instructionRoot.getChildren().add(rulesText);
    }
}
