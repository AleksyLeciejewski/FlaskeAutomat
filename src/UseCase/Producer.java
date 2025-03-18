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
        while (true) {
            try {
                Thread.sleep(1000);
                Bottle bottle = produceBottle(); //Opdelt fra buffer for uafhængig debugging inden den videresendes
                bufferService.addBottle(bottle);
                System.out.println("Produceret: " + bottle);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private Bottle produceBottle() {
        int size = random.nextInt(1500) + 250;
        String[] names = {"øl", "sodavand"};
        String name = names[random.nextInt(names.length)];
        char[] pantType = {'A', 'B', 'C'};
        char pant = pantType[random.nextInt(pantType.length)];
        int type = 99;

        return bottleBuilder.createBottle(size, name, pant, type);
    }
}
