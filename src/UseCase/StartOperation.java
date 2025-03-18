package UseCase;

import java.nio.Buffer;

public class StartOperation {

    BufferService bufferService = new BufferService(10);
    BottleBuilder bottleBuilder = new BottleBuilder();
    Thread producer = new Thread(new Producer(bufferService, bottleBuilder));
    Thread consumer = new Thread(new Consumer(bufferService));


    public StartOperation(){
    producer.start();
    consumer.start();
    }
}
