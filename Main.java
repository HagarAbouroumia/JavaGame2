package türk.lira;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] deployed_mines = new String[21];
        int deployed_mines_size = 0;
        int deploy_time = 0;
        Scanner input = new Scanner(System.in);
        PBank bank = PBank.getInstance();
        Mines mines = Mines.getInstance();
        Peasant peasant = Peasant.getInstance();
        Thief thief = Thief.getInstance();
        bank.setLocation();
        mines.setMinesLocations();
        thief.setPersonLocation();

        int choice = 1;
        while (choice != 2) {
            System.out.println("Choose one option\n(1) Collect Mine\n(2) Terminate");
            choice = input.nextInt();
            if (choice == 1) {
                if (deployed_mines_size == 20) {
                    System.out.println("Warning! There are 20 mine pieces inside the bank, choose another choice");
                } else {
                    peasant.set_NearestMine_deploy();
                    System.out.println("Enter deploy hour");
                    deploy_time = input.nextInt();
                    thief.steal_mines(deployed_mines, deployed_mines_size, deploy_time);
                    deployed_mines[deployed_mines_size++] = peasant.getNearest_mine_type();
                    System.out.println("Minimum distance = " + peasant.getPeasant_mine_position());
                    System.out.println("Closest mine is type = " + deployed_mines[deployed_mines_size - 1] + " with distance = " + peasant.getPeasant_mine_position());
                    bank.calculate_total_money(deployed_mines[deployed_mines_size - 1], deploy_time);
                }

            }

        }
    }
}
