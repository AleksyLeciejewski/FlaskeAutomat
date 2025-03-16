import Model.Bottle;

import java.util.Random;

public class Producer {
    private BottleBuilder bottleBuilder;
    private Random random = new Random();

    public Producer(BottleBuilder bottleBuilder) {
        this.bottleBuilder = bottleBuilder;
    }

    public Bottle produceBottle() {
        int size = random.nextInt(1500) + 250;
        String[] names = {"øl", "sodavand"};
        String name = names[random.nextInt(names.length)];
        char[] pantType = {'A', 'B', 'C'};
        char pant = pantType[random.nextInt(names.length)];
        int type;

        return bottleBuilder.createBottle(size, name, pant, type);
    }
}
