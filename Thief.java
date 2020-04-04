package HW1;

public class Thief extends Person {

    static Thief obj = new Thief();
    public static Thief getInstance() {
        return obj;
    }

    PBank bank = PBank.getInstance();
    Location location = Location.getInstance();
    Peasant peasant = Peasant.getInstance();
    Mines mines = Mines.getInstance();
    Security security = Security.getInstance();
    float thief_position;
    int total_stolen_money = 0;
    int initial=0;

    @Override
    public void setPersonLocation() {
        int range = 20;
        int checker = 1;
        int random1, random2;
        while (checker == 1) {
            random1 = (int) (Math.random() * range) + 0;
            random2 = (int) (Math.random() * range) + 0;
            checker = location.setLocations("thief", random1, random2);
            thief_position = Float.parseFloat(String.valueOf(random1) + "." + String.valueOf(random2));
        }
    }

    public float getThief_position() {
        return thief_position;
    }

    public int getStolen_money() {
        return total_stolen_money;
    }

    public void setStolen_money(String mine, int deploy_time) {
        int x = mines.check_mine_type(mine);
        this.total_stolen_money = this.total_stolen_money + x + x * (deploy_time);
    }


    public void steal_mines(String[] deployed_mines, int deployed_mines_size, int deploy_time, int[] old_deployed_time) {
        if (peasant.getPeasant_mine_position() > getThief_position() && deployed_mines_size != 0 && stop_thief() == false) {
            for (int i =initial; i < 21; i++) {
                if (deployed_mines[i] != null) {
                    setStolen_money(deployed_mines[i], deploy_time);
                    bank.remove_stolen_mines(deployed_mines[i], old_deployed_time[i]);
                    System.out.println("The Thief is stealing " + deployed_mines[i] + " with interests = " + mines.check_mine_type(deployed_mines[i]));
                    initial = i; 
                    break;
                }
            }
        }
    }
    private boolean stop_thief() {
        if (bank.getTotal_money_bank() >= 80) {
            security.setPersonLocation();
            return true;
        }
        return false;

    }

}
