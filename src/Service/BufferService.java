package Service;

import Model.Bottle;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.List;

public class BufferService {

    private LinkedBlockingQueue<Bottle> buffer;
    private List<Bottle> bottles;

    public BufferService(LinkedBlockingQueue<Bottle> buffer){
        this.buffer = buffer;
    }

    public synchronized void addBottle(Object object) throws InterruptedException {
        while(buffer.remainingCapacity() == 0){
            wait();
        }
        buffer.put(new Bottle());
        notifyAll();
    }
}
