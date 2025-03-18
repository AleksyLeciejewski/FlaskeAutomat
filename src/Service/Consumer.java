package Service;

import Model.Bottle;

public class Consumer implements Runnable {
    private final BufferService bufferService; 

    public Consumer(BufferService bufferService) {
        this.bufferService = bufferService;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Bottle bottle = bufferService.removeBottle();
                System.out.println("Consumer: Behandler " + bottle);

                Thread.sleep(1500);

                System.out.println("Consumer: Færdig med " + bottle);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
