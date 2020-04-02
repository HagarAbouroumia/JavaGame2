package türk.lira;

public class Mines {

    Location location = Location.getInstance();
    static Mines obj = new Mines();

    public static Mines getInstance() {
        return obj;
    }
    public void setMinesLocations() {
        int range = 20; // max - min +1 for the array[20][20]
        int range2 = 3; // for the 3 types of the mines
        int random, random1, random2, checker;
        for (int counter = 0; counter < 41; counter = counter + 2) {
            random = (int) (Math.random() * range2) + 1;
            random1 = (int) (Math.random() * range) + 0;
            random2 = (int) (Math.random() * range) + 0;
            switch (random) {
                case 1:
                    checker = location.setLocations("silver", random1, random2);
                    counter = (checker == 1) ? counter - 2 : counter;
                    break;
                case 2:
                    checker = location.setLocations("gold", random1, random2);
                    counter = (checker == 1) ? counter - 2 : counter;
                    break;
                case 3:
                    checker = location.setLocations("diamond", random1, random2);
                    counter = (checker == 1) ? counter - 20 : counter;
                    break;
            }
        }
    }
}
