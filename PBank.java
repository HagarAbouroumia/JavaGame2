package türk.lira;

public class PBank {

    Thief thief = Thief.getInstance();

    public static PBank getInstance() {
        return obj;
    }
    Location location = Location.getInstance();
    Peasant peasant = Peasant.getInstance();
    static PBank obj = new PBank();
    int total_money_bank = 0;

    public void setLocation() {
        location.setLocations("PBank", 0, 0);
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
}
