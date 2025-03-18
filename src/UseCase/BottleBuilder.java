package UseCase;

import Model.Bottle;

public class BottleBuilder {

    public Bottle createBottle(int size, String name, char pant, int type) {
        return new Bottle(size, name, pant, type);
    }
}
