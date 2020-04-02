package türk.lira;

public class Peasant extends Person {

    static Peasant obj = new Peasant();

    public static Peasant getInstance() {
        return obj;
    }

    Location location = Location.getInstance();
    Mines mines = Mines.getInstance();

    float peasant_mine_position = 0;
    String nearest_mine_type = null;

    @Override
    public void setPersonLocation() {

    }

    public void set_NearestMine_deploy() {
        String mine = null;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                mine = location.getLocations()[i][j];
                if ("silver".equals(mine) || "gold".equals(mine) || "diamond".equals(mine)) {
                    peasant_mine_position = Float.parseFloat(String.valueOf(i) + "." + String.valueOf(j));
                    location.getLocations()[i][j] = null;
                    i = 20;
                    j = 20;
                }
            }
        }
        nearest_mine_type = (mine);
    }

    public float getPeasant_mine_position() {
        return peasant_mine_position;
    }

    public String getNearest_mine_type() {
        return nearest_mine_type;
    }
    
    

}
