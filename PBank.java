package HW1;

import java.util.Scanner;

public class PBank {

    static PBank obj = new PBank();

    public static PBank getInstance() {
        return obj;
    }

    Location location = Location.getInstance();
    Mines mines = Mines.getInstance();
    int total_money_bank = 0;

    public void setLocation() {
        location.setLocations("PBank", 0, 0);
    }

    public void remove_stolen_mines(String mine, int deploy_time) {
        int x = mines.check_mine_type(mine);
        total_money_bank = total_money_bank - (x + x * deploy_time);
    }

    public void calculate_total_money(String string, int deploed_time) {
        switch (string) {
            case "silver":
                total_money_bank = total_money_bank + 1 + (deploed_time);
                break;
            case "gold":
                total_money_bank = total_money_bank + 2 + 2 * (deploed_time);
                break;
            case "diamond":
                total_money_bank = total_money_bank + 3 + 3 * (deploed_time);
                break;
        }
    }

    public int getTotal_money_bank() {
        return total_money_bank;
    }

    public void print_in_bank(String[] string, int[] hour, int size) {
        System.out.println("**********************Printing the mine in the bank**********************");
        int id = 1;
        for (int i = 0; i < size; i++) {

            System.out.println("Mine ID " + id++);
            System.out.println("Mine Type " + string[i]);
            System.out.println("Enter Hour " + hour[i]);
            System.out.println("-----------------------------------");
        }
        System.out.println("**********************Done Printing the mines in the bank**********************");

    }

    public static void main(String[] args) {
        String[] deployed_mines = new String[21];
        int[] deployed_mines_time = new int[21];
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
            System.out.println("Choose One option\n(1) Collect Mine\n(2) Terminate");
            choice = input.nextInt();
            if (choice == 1) {
                if (deployed_mines_size == 20) {
                    System.out.println("Warning! There are 20 mine pieces inside the bank, choose another choice");
                } else {
                    peasant.set_NearestMine_deploy();
                    System.out.println("\nEnter deploy hour");
                    deploy_time = input.nextInt();
                    thief.steal_mines(deployed_mines, deployed_mines_size, deploy_time, deployed_mines_time);
                    deployed_mines[deployed_mines_size] = peasant.getNearest_mine_type();
                    deployed_mines_time[deployed_mines_size++] = deploy_time;
                    System.out.println("Minimum distance = " + peasant.getPeasant_mine_position());
                    System.out.println("Closest mine is type = " + deployed_mines[deployed_mines_size - 1] + " with distance = " + peasant.getPeasant_mine_position());
                    bank.calculate_total_money(deployed_mines[deployed_mines_size - 1], deploy_time);
                }
            } else if (choice == 2) {
                bank.print_in_bank(deployed_mines, deployed_mines_time, deployed_mines_size);
                System.out.println("Terminated");
                System.out.println("The Primitive Bank value of " + bank.getTotal_money_bank() + " Turkish Lira");
            }
        }
    }
}
