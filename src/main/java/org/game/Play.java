package org.game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;

import static org.game.Menu.stageMenu;
import static org.game.Utility.*;

public class Play {
    static Group Player = new Group();
    static Group Blocks = new Group();
    static Group root = new Group(Player, Blocks);
    static Scene scene = new Scene(root, SIZE, SIZE, Color.CYAN);

    static boolean sceneSet = false;

    public static void stagePlay() {
        SCENE.switchToPlay();
        System.out.println(SCENE.getCurrentScene());

        resetGame();

        if (!sceneSet)
            setPlayScene();

        STAGE.setScene(scene);
    }

    public static void setPlayScene() {
        resetGame();

        Timeline everySecond = new Timeline(new KeyFrame(Duration.seconds(1),
                event -> {
                    moveBoard();
                }
        ));
        everySecond.setCycleCount(Timeline.INDEFINITE);
        everySecond.play();

        sceneSet = true;
    }

    public static void resetGame() {
        LAYOUT = new ArrayList<>();
        for (int i=0; i < BLOCKS; i++) {
            LAYOUT.add(new ArrayList<>(BLOCKS));
            for (int j=0; j < BLOCKS; j++) {
                LAYOUT.get(i).add(0);
            }
        }

        position.X = BLOCKS / 2;
        position.Y = BLOCKS / 2;

        moveBoard();
        movePlayer();
    }

    public static void moveBoard() {
        LAYOUT.remove(LAYOUT.size() - 1);
        LAYOUT.add(0, new ArrayList<>(BLOCKS));
        for (int i=0; i < BLOCKS; i++) {
            if(Math.random() > 0.7)
                LAYOUT.get(0).add(1);
            else
                LAYOUT.get(0).add(0);
        }
        Blocks.getChildren().clear();
        for (int i=0; i < BLOCKS; i++) {
            for (int j=0; j < BLOCKS; j++) {
                if (LAYOUT.get(i).get(j) == 1) {
                    Blocks.getChildren().add(
                            new Rectangle(ORIGIN + UNIT(j),ORIGIN + UNIT(i), UNIT, UNIT)
                    );
                    if(position.Y == i && position.X == j) {
                        position.Y++;
                        movePlayer();
                        if (position.Y == BLOCKS) {
                            System.out.println("you lose!");
                            stageMenu();
                        }
                    }
                }
            }
        }
    }

    public static void movePlayer() {
        Player.getChildren().clear();
        Player.getChildren().add(
                new Circle(UNIT(position.X) + HALF_UNIT, UNIT(position.Y) + HALF_UNIT,
                        HALF_UNIT, Color.WHITE)
        );
    }

}
