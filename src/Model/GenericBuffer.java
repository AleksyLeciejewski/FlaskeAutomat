package Model;

import java.util.LinkedList;
import java.util.Queue;

public class GenericBuffer {
    private final Queue<Bottle> bottles;
    private final int CAPACITY;

    public GenericBuffer(int capacity) {
        this.CAPACITY = capacity;
        this.bottles = new LinkedList<>();
    }

    public synchronized void addBottle(Bottle bottle) throws InterruptedException {
        while (bottles.size() >= CAPACITY) {
            wait();
        }
        bottles.add(bottle);
        notifyAll();
    }

    public synchronized Bottle removeBottle() throws InterruptedException {
        while (bottles.isEmpty()) {
            wait();
        }
        Bottle bottle = bottles.poll();
        notifyAll(); 
        return bottle;
    }
}
