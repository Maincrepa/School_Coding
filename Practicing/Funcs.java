import java.util.Scanner;

public class Funcs {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("=== BASIC FUNCTIONS LEARNING PROJECT ===");

        boolean running = true;

        while (running == true) {
            System.out.println(" "); // visual
            ShowMenu();
            int selection = sc.nextInt();

            switch (selection) {
                case 1:
                    SimpleCalc();

                    break;
                case 2:
                    System.out.println("Has elegit sortir.");
                    running = false;

                    break;
                case 3:
                    System.out.println("Has elegit caculadora simple.");


                    break;
                default:
                System.out.println("Introdueix una selecció viable (1-2)");
                    break;
            }
        }
    }

    public static void ShowMenu() {
        System.out.println("  - MENU PRINCIPAL ---"); // visual
        System.out.println("1 - simple sum");
        System.out.println("2 - exit");
        System.out.println(" "); // visual
        System.out.print("  - Introdueix selecció: ");
    }


    public static void SimpleCalc() {
        System.out.println("Has elegit caculadora simple.");
    }
}
