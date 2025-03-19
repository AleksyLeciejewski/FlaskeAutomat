package UseCase;

import Model.Bottle;
import java.util.Random;

public class Producer implements Runnable {
    private final BufferService bufferService;
    private final BottleBuilder bottleBuilder;
    private final Random random = new Random();

    public Producer(BufferService bufferService, BottleBuilder bottleBuilder) {
        this.bufferService = bufferService;
        this.bottleBuilder = bottleBuilder;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
                Bottle bottle = produceBottle();
                bufferService.addBottle(bottle);
                System.out.println("Produceret: " + bottle);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private Bottle produceBottle() {
        int[] sizes = {330, 500, 750, 1000, 1500};
        String[] names = {"øl", "sodavand"};
        char[] pantTypes = {'A', 'B', 'C'};

        int size = sizes[random.nextInt(sizes.length)];
        String name = names[random.nextInt(names.length)];
        char pant = pantTypes[random.nextInt(pantTypes.length)];

        return bottleBuilder.createBottle(size, name, pant, 99);
    }
}
