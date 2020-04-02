package türk.lira;

public class Location {

    static Location obj = new Location();

    public static Location getInstance() {
        return obj;
    }

    String[][] locations = new String[20][20];

    public int setLocations(String thing, int i, int j) {
        if (locations[i][j] == null) {
            locations[i][j] = thing;
            return 0;
            
        } else 
            return 1;
    } // position the location of the    


    public void print() {
        int count = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (locations[i][j] != null) {
                    System.out.println(locations[i][j]);
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    public String[][] getLocations() {
        return locations;
    }

}
