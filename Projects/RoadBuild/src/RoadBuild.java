package src;

import java.util.Scanner;

public class RoadBuild {
    private Scanner input;
    private int[][] gameSpace;
    private String[][] gameBlocks;
    private boolean generated;
    private boolean debugMode;
    private int[] playerPosition;
    private int[][] buildQueue;
    private boolean buildQueueCooldwn;

    /*---------------------------------------------------------------------------------------------------------
    ------------- CONSTRUCTOR
    ---------------------------------------------------------------------------------------------------------
    */

    public RoadBuild() {
        this.input = new Scanner(System.in);
        this.playerPosition = new int[2];
        this.gameSpace = new int[5][5];

        this.gameBlocks = new String[][] { // all displaynames are to be 3 chars
                { "PlayerSel", "< >" }, // 0
                { "Background", " · " }, // 1
                { "Rock", " ■ " }, // 2
                { "Road_X", "-+-" }, // 3
                { "Road_V", " | " }, // 4
                { "Road_H", "---" }, // 5
                { "Road_C1", " / " }, // 6
                { "Road_C2", " \' " }, // 7
                { "Building", " $ " }, // 8
                { "Unused", "" }, // 9
                { "Unused", "" }, // 10
                { "Unused", "" }, // 11
                { "Unused", "" }, // 12
                { "Unused", "" }, // 13
                { "Unused", "" }, // 14
        };
        this.buildQueueCooldwn = false;
        this.buildQueue = new int[][] {
            //{BlockIdentifier, PositionX, PositionY},
            {-1, 0, 0}, // Slot 1
            {-1, 0, 0}, // Slot 2
            {-1, 0, 0} // Slot 3
        }; // 3 slots for the queue

        this.generated = false;
        this.debugMode = false;
    }

    /*---------------------------------------------------------------------------------------------------------
    ------------- GAME LOOP
    ---------------------------------------------------------------------------------------------------------
    */

    // Main game loop func
    public void run() {
        boolean game = true;

        while (game) { // main game loop
            System.out.println(" / / / / / / / / / / / / / / / / /");
            if (!generated) {
                generateEnv();
            }
            printPlayerTopbar(); // display position
            if (debugMode) { // game env. display default/debug
                printEnv(true);
            } else {
                printEnv(false);
            }
            buildQueueCooldwn = !buildQueueCooldwn;
            System.out.println("CURRENT STATUS BQUEUE: " + buildQueueCooldwn);
            System.out.println();
            printPlayerHotbar(); // display control hotbar
            askPlayerControl();
            QueueBuild();
            checkbuildings();

            
        }
    }

    /*---------------------------------------------------------------------------------------------------------
    ------------- GENERATION
    ---------------------------------------------------------------------------------------------------------
    */

    private void generateEnv() { // env. generator
        for (int i = 0; i < gameSpace.length; i++) {
            for (int j = 0; j < gameSpace[i].length; j++) {
                gameSpace[i][j] = 1; // set to solid
            }
        }
        playerPosition[0] = 2; // player x-pos set to center
        playerPosition[1] = 2; // player y-pos set to center

        generated = true;
    }

    /*---------------------------------------------------------------------------------------------------------
    ------------- PRINTS
    ---------------------------------------------------------------------------------------------------------
    */

    private void printEnv(boolean debugview) {
        for (int i = 0; i < gameSpace.length; i++) {
            System.out.print("| "); // Left border
            for (int j = 0; j < gameSpace[i].length; j++) {
                if (debugview) { // debug view, show block names
                    System.out.printf("%-6s", gameBlocks[gameSpace[i][j]][0]);
                    System.out.print(" ");
                } else { // normal view, show symbols
                    if (i == playerPosition[0] && j == playerPosition[1]) { // if player;
                        String print = ""+gameBlocks[0][1].charAt(0) + gameBlocks[gameSpace[i][j]][1].charAt(1) + gameBlocks[0][1].charAt(2);
                        System.out.printf("%-1s", print);
                    } else {
                        System.out.printf("%-1s", gameBlocks[gameSpace[i][j]][1]);
                    }
                    System.out.print(" ");
                }
            }
            System.out.println("|"); // Right border
        }
    }

    private void printPlayerTopbar() {
        System.out.println("Selected Tile: [" + playerPosition[0] + " - " + playerPosition[1] + "]");
    }

    private void printPlayerHotbar() {
        System.out.println("['w' up | 's' down] ['a' left | 'd' right]");
        System.out.println("z: ['b' build]");
    }

    /*---------------------------------------------------------------------------------------------------------
    ------------- CONTROLS
    ---------------------------------------------------------------------------------------------------------
    */

    private void askPlayerControl() {
        System.out.print("Input Control (wasd/z): ");
        char plrmove = input.next().charAt(0);
        int[] desiedpos = new int[2];
        System.out.println();
        switch (plrmove) {
            case 'w':
                System.out.println("Moving up");
                desiedpos[0] = (playerPosition[0] - 1);
                desiedpos[1] = (playerPosition[1]);
                trymove(desiedpos);
                break;
            case 's':
                System.out.println("Moving down");
                desiedpos[0] = (playerPosition[0] + 1);
                desiedpos[1] = (playerPosition[1]);
                trymove(desiedpos);
                break;

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
            case 'z':
                otherControls();
                break;
            default:
                System.out.println("Wrong Input");
                break;
        }
        System.out.println();
    }

    private void otherControls() {
        System.out.print("Control Input: ");
        char plrmove = input.next().charAt(0);
        System.out.println();
        switch (plrmove) {
            case 'b': // special, build road
                System.out.println("Player wants to build a road at: [" + playerPosition[0] + "] [" + playerPosition[1] + "]");
                roadBuild();
                break;
            case 'z': // special, debug mode
                if (debugMode) {
                    debugMode = false;
                    System.out.println("Disabled debug mode");
                } else {
                    debugMode = true;
                    System.out.println("Enabled debug mode");
                }
                break;
            case 'q': // special, print queue
                printQueue();
                break;
            default:
                System.out.println("Wrong Input");
                break;
        }
        System.out.println();
    }

    /*---------------------------------------------------------------------------------------------------------
    ------------- PlAYER MOVEMENT
    ---------------------------------------------------------------------------------------------------------
    */

    private void trymove(int[] desiedpos) { // movement control, try to move in env.
        System.out.println("Player wants to move to [" + desiedpos[0] + "-" + desiedpos[1] + "]");
        if ((desiedpos[0] >= 0 && desiedpos[0] < gameSpace.length) && (desiedpos[1] >= 0 && desiedpos[1] < gameSpace[0].length)) {
            if (gameSpace[desiedpos[0]][desiedpos[1]] != 2) { // if it's the background, can move
                moveplayer(desiedpos);
            } else {
                System.out.println("There's no space to move to, position not updated");
            }
        } else {
            System.out.println("! ! Trying to exit the map, position not updated");
        }
    }

    private void moveplayer(int[] desiedpos) { // movement control, move player in the env.
        playerPosition[0] = desiedpos[0]; // update player x-pos set to desired
        playerPosition[1] = desiedpos[1]; // update player y-pos set to desired
    }

    /*---------------------------------------------------------------------------------------------------------
    ------------- BUILDING
    ---------------------------------------------------------------------------------------------------------
    */

    private void roadBuild() {
        if (gameSpace[playerPosition[0]][playerPosition[1]] == 1) { // can build;
            gameSpace[playerPosition[0]][playerPosition[1]] = 4;
            //addToQueue(4, playerPosition[0], playerPosition[1]);
        }
    }

    // The rest of this section is for a building queue, will be implemented in the future
    private void printQueue() {
        System.out.println("Printing Queue:");
        for (int i = 0; i < buildQueue.length; i++) {
            if (buildQueue[i][0] != -1) {
                System.out.println("Q" + i + " | Block: " + buildQueue[i][0] + " | Pos: X: " + buildQueue[i][1] + " Y: " + buildQueue[i][2]);
            } else {
                System.out.println("Q" + i + " | Slot Empty");
            }
        }
    }

    private void QueueBuild() {
        if (buildQueueCooldwn) {
            boolean buildin = false;
            if (buildQueue[0][0] != -1 && !buildin) {
                    gameSpace[buildQueue[0][1]][buildQueue[0][2]] = buildQueue[0][0];
                    removeQueue(0);
                    buildQueue[0] = buildQueue[1]; // move up
                    buildQueue[1] = buildQueue[2];
            }
        }
    }

    private void addToQueue(int Block, int PosX, int PosY) {
        boolean canbuild = true;
        System.out.println("addToQueue triggered; arg1: " + Block + " arg2: " + PosX + " arg3: " + PosY);
        for (int i = 0; i < buildQueue.length; i++) {
            if (buildQueue[2][0] == -1) {
            //if (buildQueue[buildQueue.length - 1][0] != -1) {
                if (buildQueue[i][0] == -1 && canbuild) {
                    canbuild = false;
                    System.out.println("Added " + gameBlocks[Block][0] + " to queue position: " + i);
                    buildQueue[i][0] = Block;
                    buildQueue[i][1] = PosX;
                    buildQueue[i][2] = PosY;
                }
            } else {
                System.out.println("ALL SLOTS OCCUPIED");
            }
        }
    }

    private void removeQueue(int Position) {
        buildQueue[Position][0] = -1;
        buildQueue[Position][1] = 0;
        buildQueue[Position][2] = 0;
    }

    /*---------------------------------------------------------------------------------------------------------
    ------------- OTHER
    ---------------------------------------------------------------------------------------------------------
    */

    private void checkbuildings() {
        for (int i = 0; i < gameSpace.length; i++) {
            for (int y = 0; y < gameSpace[i].length; y++) {
                int BlockW = -1; // up
                int BlockA = -1; // left
                int BlockS = -1; // down
                int BlockD = -1; // right

                // Check up (W)
                if (i - 1 >= 0) {BlockW = gameSpace[i - 1][y];}
                // Check left (A)
                if (y - 1 >= 0) {BlockA = gameSpace[i][y - 1];}
                // Check down (S)
                if (i + 1 < gameSpace.length) {BlockS = gameSpace[i + 1][y];}
                // Check right (D)
                if (y + 1 < gameSpace[i].length) {BlockD = gameSpace[i][y + 1];}

                // Debug? : Print surrounding tiles
                if (debugMode) {
                    System.out.println("Tile [" + i + "][" + y + "] - Current: " + gameBlocks[gameSpace[i][y]][0]);
                    System.out.println("  Up(W): " + (BlockW != -1 ? gameBlocks[BlockW][0] + " at [" + (i-1) + "][" + y + "]" : "OUT OF BOUNDS"));
                    System.out.println("  Left(A): " + (BlockA != -1 ? gameBlocks[BlockA][0] + " at [" + i + "][" + (y-1) + "]" : "OUT OF BOUNDS"));
                    System.out.println("  Down(S): " + (BlockS != -1 ? gameBlocks[BlockS][0] + " at [" + (i+1) + "][" + y + "]" : "OUT OF BOUNDS"));
                    System.out.println("  Right(D): " + (BlockD != -1 ? gameBlocks[BlockD][0] + " at [" + i + "][" + (y+1) + "]" : "OUT OF BOUNDS"));
                    System.out.println();
                }

                // Road orientation logic - vertical roads next to each other horizontally become horizontal
                int currentBlock = gameSpace[i][y];
                if (currentBlock == 4) { // if current tile is a vertical road
                    // Check if there's another vertical road to the left or right
                    if (BlockA == 4 || BlockD == 4) {
                        gameSpace[i][y] = 5; // convert to horizontal road
                        if (debugMode) {
                            System.out.println(">>> Converting [" + i + "][" + y + "] to HORIZONTAL (Road_H)");
                        }
                        // Also convert the adjacent vertical road to horizontal
                        if (BlockA == 4 && y - 1 >= 0) {
                            gameSpace[i][y - 1] = 5;
                            if (debugMode) {
                                System.out.println(">>> Converting [" + i + "][" + (y-1) + "] to HORIZONTAL (Road_H)");
                            }
                        }
                        if (BlockD == 4 && y + 1 < gameSpace[i].length) {
                            gameSpace[i][y + 1] = 5;
                            if (debugMode) {
                                System.out.println(">>> Converting [" + i + "][" + (y+1) + "] to HORIZONTAL (Road_H)");
                            }
                        }
                    }
                }
                
            }
        }
    }


    /*---------------------------------------------------------------------------------------------------------
    ------------- RUN
    ---------------------------------------------------------------------------------------------------------
    */

    public static void main(String[] args) {
        RoadBuild game = new RoadBuild();
        game.run();
    }

}
