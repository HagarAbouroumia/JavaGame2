package türk.lira;

public class Thief extends Person {

    Peasant peasant = Peasant.getInstance();

    public static Thief getInstance() {
        return obj;
    }
    static Thief obj = new Thief();
    Location location = Location.getInstance();
    float thief_position;
    int total_stolen_money = 0;
    int current_interest_value = 0;

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

        switch (mine) {
            case "silver":
                current_interest_value = 1;
                this.total_stolen_money = this.total_stolen_money + 1 + (deploy_time);
                break;
            case "gold":
                current_interest_value = 2;
                this.total_stolen_money = this.total_stolen_money + 2 + 2 * (deploy_time);
                break;
            case "diamond":
                current_interest_value = 3;
                this.total_stolen_money = this.total_stolen_money + 3 + 3 * (deploy_time);
                break;
        }
    }

    public int getCurrent_interest_value() {
        return current_interest_value;
    }

    public void steal_mines(String[] deployed_mines, int deployed_mines_size, int deploy_time) {
        if (stop_thief() == false) {
            if (peasant.getPeasant_mine_position() > getThief_position()) {
                int i = 0;
                int checker = 0;
                while (checker == 0) {
                    if (deployed_mines_size != 0) {
                        if (deployed_mines[i] != null) {
                            setStolen_money(deployed_mines[i], deploy_time);
                            checker = 1;
                            System.out.println("The Thief is stealing " + deployed_mines[i] + " with interests = " + getCurrent_interest_value());
                        }
                        i++;
                    } else {
                        checker = 1;
                    }
                }
            }
        }
    }

    private boolean stop_thief() {
        return total_stolen_money >= 30;
    }

}
