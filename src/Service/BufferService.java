package Service;

import Model.Bottle;
import java.util.concurrent.LinkedBlockingQueue;

public class BufferService {
    private final LinkedBlockingQueue<Bottle> buffer;

    public BufferService(int capacity) {
        this.buffer = new LinkedBlockingQueue<>(capacity);
    }

    public void addBottle(Bottle bottle) throws InterruptedException {
        buffer.put(bottle); // Blokerer, hvis køen er fuld
        System.out.println("Producer: Tilføjede " + bottle);
    }

    public Bottle removeBottle() throws InterruptedException {
        Bottle bottle = buffer.take(); // Blokerer, hvis køen er tom
        System.out.println("Consumer: Fjernede " + bottle);
        return bottle;
    }
}
