package org.game;

import javafx.stage.Stage;

import java.util.ArrayList;

public class Utility {
    public static final int UNIT = 20;
    public static final int HALF_UNIT = UNIT/2;
    public static int UNIT(int n) {return n*UNIT;}
    public static final int BLOCKS = 21; // odd number so player can be at center of screen
    public static final int SIZE = UNIT(BLOCKS);
    public static final int ORIGIN = 0;

    public static class position {
        public static int X = 0;
        public static int Y = 0;
    }

    public static class SCENE {
        public enum scene {
            MENU,
            INSTRUCTIONS,
            PLAY
        }

        private static scene current;

        public static scene getCurrentScene() {
            return current;
        }

        public static void switchToMenu() {
            current = scene.MENU;
        }

        public static void switchToInstructions() {
            current = scene.INSTRUCTIONS;
        }

        public static void switchToPlay() {
            current = scene.PLAY;
        }

    };

    public static ArrayList<ArrayList<Integer>> LAYOUT;

    public static Stage STAGE;
}
