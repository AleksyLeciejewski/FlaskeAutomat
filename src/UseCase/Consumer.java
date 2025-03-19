package UseCase;

import Model.Bottle;
import UseCase.BufferService;

public class Consumer implements Runnable {
    private final BufferService bufferService;
    private final String consumerName;

    public Consumer(BufferService bufferService, String consumerName) {
        this.bufferService = bufferService;
        this.consumerName = consumerName;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Bottle bottle = bufferService.removeBottle();
                System.out.println(consumerName + " behandler: " + bottle);

                Thread.sleep(1500);

                System.out.println(consumerName + " færdig med: " + bottle);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
