package türk.lira;

public class Security extends Person {

    Location location = Location.getInstance();
    boolean security_activation = false;
    static Security obj = new Security();

    public static Security getInstance() {
        return obj;
    }

    @Override
    public void setPersonLocation() {
        security_activation = true;
    }

    public boolean isSecurity_activation() {
        return security_activation;
    }

}
