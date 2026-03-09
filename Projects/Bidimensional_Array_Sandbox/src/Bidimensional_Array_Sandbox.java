package src;

import java.util.Scanner;

public class Bidimensional_Array_Sandbox {
    private Scanner input;
    private int[][] gameSpace;
    private String[][] gameItems; // unused yet
    private String[][] gameBlocks;
    private boolean generated;
    private boolean debugMode; // 'z'
    private boolean miningMode; // 'm'
    private int[] playerPosition;

    // Constructor
    public Bidimensional_Array_Sandbox() {
        this.input = new Scanner(System.in);
        this.playerPosition = new int[2];
        this.gameSpace = new int[5][5];

        this.gameItems = new String[][] {
                { "Mining Tool", "", "" }, // 0
        };

        this.gameBlocks = new String[][] { // all displaynames are to be 3 chars
                { "Player", "<P>" }, // 0
                { "Air", "   " }, // 1
                { "Solid", "[■]" }, // 2
                { "Water", "~~~" }, // 3
                { "Unused", "" }, // 4
                { "Unused", "" }, // 5
                { "Unused", "" }, // 6
                { "Unused", "" }, // 7
                { "Unused", "" }, // 8
                { "Unused", "" }, // 9
                { "Unused", "" }, // 10
                { "Unused", "" }, // 11
                { "Unused", "" }, // 12
                { "Unused", "" }, // 13
                { "Unused", "" }, // 14

                { "Sun", "(@)" },// 15
        };

        this.generated = false;
        this.debugMode = false;
        this.miningMode = false;
    }

    // Main game loop func
    public void run() {
        boolean game = true;

        while (game) { // main game loop
            if (!generated) {
                generateEnv();
            }
            printPlayerTopbar(); // display position
            if (debugMode) { // game env. display default/debug
                printEnv(true);
            } else {
                printEnv(false);
            }
            System.out.println();
            printPlayerHotbar(); // display control hotbar
            wantmove(); // ask for movement

            System.out.println(" / / ");
        }
    }

    private void generateEnv() { // env. generator
        for (int i = 0; i < gameSpace.length; i++) {
            for (int j = 0; j < gameSpace[i].length; j++) {
                if (i >= 3) {
                    gameSpace[i][j] = 2; // set to solid
                } else {
                    gameSpace[i][j] = 1; // set to air
                }
            }
            
            if (i == 3) { // on middle line, random solids
                for (int j = 0; j < gameSpace[i].length; j++) {
                    int rnd = (int) (Math.random() * 2);
                    if ((rnd == 0) && (i != 2 && j != 2)) { // ensure center is always air, plr spawn
                        gameSpace[2][j] = 2;
                    }
                }
            }
                
        }
        gameSpace[0][0] = 15; // set to sun
        gameSpace[2][2] = 0; // set to player
        playerPosition[0] = 2; // player x-pos set to center
        playerPosition[1] = 2; // player y-pos set to center

        generated = true;
    }

    private void printEnv(boolean debugview) {
        for (int i = 0; i < gameSpace.length; i++) {
            System.out.print("| "); // Left border
            for (int j = 0; j < gameSpace[i].length; j++) {
                if (debugview) { // debug view, show block names
                    System.out.printf("%-6s", gameBlocks[gameSpace[i][j]][0]);
                    System.out.print(" ");
                } else { // normal view, show symbols
                    System.out.printf("%-1s", gameBlocks[gameSpace[i][j]][1]);
                    System.out.print(" ");
                }
            }
            System.out.println("|"); // Right border
        }
    }

    private void printPlayerTopbar() {
        System.out.println("Player Position: [" + playerPosition[0] + " - " + playerPosition[1] + "]");
    }

    private void printPlayerHotbar() {
        System.out.println("['a' left | 'd' right]");
        System.out.println("['m' mining tool mode]");
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

            case 'm': // special, mining mode
                if (miningMode) {
                    miningMode = false;  System.out.println("Disabled mining mode");
                } else {
                    miningMode = true;   System.out.println("Enabled mining mode");
                }
                mining();
                break;
            case 'z': // special, debug mode
                if (debugMode) {
                    debugMode = false;  System.out.println("Disabled debug mode");
                } else {
                    debugMode = true;   System.out.println("Enabled debug mode"); }
                break;
            default:
                System.out.println("Wrong Input");
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
            } else {
                //System.out.println("Checking diagonal up [" + (desiedpos[0] - 1) + "-" + desiedpos[1] + "]");
                //System.out.println("Checking diagonal up block: " + gameSpace[desiedpos[0] - 1][desiedpos[1]]);
                if (gameSpace[desiedpos[0] - 1][desiedpos[1]] == 1) {
                    desiedpos[0] -= 1;
                    moveplayer(desiedpos);
                } else {
                    System.out.println("There's no space to move to, position not updated");
                }
            }
        } else {
            System.out.println("! ! Trying to exit the map, position not updated");
        }
    }

    private void moveplayer(int[] desiedpos) {  // movement control, move player in the env.
        if (gameSpace[desiedpos[0] + 1][desiedpos[1]] == 1) { // gravity; if air underneath; fall
            desiedpos[0] += 1;
        }
        gameSpace[playerPosition[0]][playerPosition[1]] = 1; // set old to air
        gameSpace[desiedpos[0]][desiedpos[1]] = 0; // set new to player

        playerPosition[0] = desiedpos[0]; // update player x-pos set to desired
        playerPosition[1] = desiedpos[1]; // update player y-pos set to desired
    }

    private void mining() {
        
    }


    
    public static void main(String[] args) {
        Bidimensional_Array_Sandbox game = new Bidimensional_Array_Sandbox();
        game.run();
    }

}
