import Model.Bottle;
import java.util.ArrayList;

public class BottleBuilder {

    public Bottle createBottle(int size, String name, char pant, int type) {
        return new Bottle(size, name, pant, type);
    }

    ArrayList<Bottle> BottleList = new ArrayList<>();

}
