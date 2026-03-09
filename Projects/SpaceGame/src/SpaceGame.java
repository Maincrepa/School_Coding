package src;

import java.util.Scanner;

public class SpaceGame {
    private Scanner input;
    private int[][] gameSpace;
    private int[] playerPosition;
    private int playerHealth;
    private String[][] gameElements;
    private int[][] enemies;
    private int[][] projectiles;

    private boolean generated;

    public SpaceGame() {
        this.input = new Scanner(System.in);
        this.playerPosition = new int[2];
        this.playerHealth = 100;
        this.gameSpace = new int[5][5];

        this.gameElements = new String[][] { // all displaynames are to be 3 chars
                { "Player", "P>-" }, // 0
                { "Space", " · " }, // 1
                { "Asteroid", "[■]" }, // 2
                { "Enemy", "-<O" }, // 3
                { "Projectile", " - " }, // 4
        };

        /*
        int PositionX, PositionY
        boolean Shot
        int ShotFrom (0 = Player, 3 = Enemy)
        

        this.enemies = new String[][] {
            {PositionX, PositionY, Shot},
        };

        this.projectiles = new String[][] {
            {ShotFrom, PositionX, PositionY},
        };
        */
    }

    // Main game loop func
    public void run() {
        boolean GameRunning = true;

        while (GameRunning) {
            if (!generated) {
                generateEnv();
            }
            printPlayerTopbar(); // display position
            printEnv(false);
            System.out.println();
            printPlayerHotbar(); // display control hotbar
            wantmove(); // ask for movement

            System.out.println(" / / ");
        }
    }

    private void generateEnv() { // env. generator
        for (int i = 0; i < gameSpace.length; i++) {
            for (int j = 0; j < gameSpace[i].length; j++) {
                    gameSpace[i][j] = 1; // set to space
            }                
        }
        gameSpace[2][1] = 0; // set gamespace to player
        playerPosition[0] = 1; // player x-pos set to center
        playerPosition[1] = 2; // player y-pos set to center
    }

    private void printEnv(boolean debugview) {
        for (int i = 0; i < gameSpace.length; i++) {
            System.out.print("| "); // Left border
            for (int j = 0; j < gameSpace[i].length; j++) {
                if (debugview) { // debug view, show block names
                    System.out.printf("%-6s", gameElements[gameSpace[i][j]][0]);
                    System.out.print(" ");
                } else { // normal view, show symbols
                    System.out.printf("%-1s", gameElements[gameSpace[i][j]][1]);
                    System.out.print(" ");
                }
            }
            System.out.println("|"); // Right border
        }
    }

    private void printPlayerTopbar() {
        System.out.println("Player Position: [" + playerPosition[0] + " - " + playerPosition[1] + "]");
        System.out.println("Player Health: [" + playerHealth + "]");
    }

    private void printPlayerHotbar() {
        System.out.println("['a' left | 'd' right]");
        System.out.println("['f' fire laser | 'c' continue]");
    }

    private void wantmove() { // movement control, ask player
        System.out.print("Control Input: ");
        char plrmove = input.next().charAt(0);
        int[] desiedpos = new int[2];
        System.out.println();
        switch (plrmove) {
            case 'a':
                System.out.println("Moving left");
                desiedpos[0] = (playerPosition[0]);
                desiedpos[1] = (playerPosition[1] - 1);
                trymove(desiedpos);
                break;

            case 'd':
                System.out.println("Moving right");
                desiedpos[0] = (playerPosition[0]);
                desiedpos[1] = (playerPosition[1] + 1);
                trymove(desiedpos);
                break;

            case 'f': // fire laser
                
                break;
            
            case 'c': // continue, skip actions
                
                break;

            default:
                System.out.println("Select a valid input");
                break;
        }
        System.out.println();
    }

    private void trymove(int[] desiedpos) {  // movement control, try to move in env.
        System.out.println("Player wants to move to [" + desiedpos[0] + "-" + desiedpos[1] + "]");
        //System.out.println("Check result: " + ((desiedpos[0] >= 0 && desiedpos[0] < gameSpace.length) && (desiedpos[1] >= 0 && desiedpos[1] < gameSpace[0].length)));
        if ((desiedpos[0] >= 0 && desiedpos[0] < gameSpace.length) && (desiedpos[1] >= 0 && desiedpos[1] < gameSpace[0].length)) {
            //System.out.println("[" + desiedpos[0] + "-" + desiedpos[1] + "] is available, despos block: " + gameSpace[desiedpos[0]][desiedpos[1]]);
            if (gameSpace[desiedpos[0]][desiedpos[1]] == 1) { // is air, can move
                moveplayer(desiedpos);
            }
        } else {
            System.out.println("! ! Trying to exit the map, position not updated");
        }
    }

    private void moveplayer(int[] desiedpos) {  // movement control, move player in the env.
        gameSpace[playerPosition[0]][playerPosition[1]] = 1; // set old to air
        gameSpace[desiedpos[0]][desiedpos[1]] = 0; // set new to player

        playerPosition[0] = desiedpos[0]; // update player x-pos set to desired
        playerPosition[1] = desiedpos[1]; // update player y-pos set to desired
    }
    
    public static void main(String[] args) {
        SpaceGame game = new SpaceGame();
        game.run();
    }
}
