package UseCase;

import Model.Bottle;
import java.util.concurrent.LinkedBlockingQueue;

public class BufferService {
    private final LinkedBlockingQueue<Bottle> buffer;

    public BufferService(int capacity) {
        this.buffer = new LinkedBlockingQueue<>(capacity);
    }

    public void addBottle(Bottle bottle) throws InterruptedException {
        buffer.put(bottle);
        System.out.println("Producer: Tilføjede " + bottle);
    }

    public Bottle removeBottle() throws InterruptedException {
        Bottle bottle = buffer.take();
        System.out.println("Consumer: Fjernede " + bottle);
        return bottle;
    }
}
