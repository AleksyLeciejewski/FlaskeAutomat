package UseCase;

import Controllers.BottleControllers;
import UseCase.BottleBuilder;
import UseCase.Producer;
import UseCase.Consumer;
import UseCase.BufferService;

public class StartOperation {
    private final BufferService mainBuffer;
    private final BufferService beerBuffer;
    private final BufferService sodaBuffer;
    private final BottleBuilder bottleBuilder;
    private final BottleControllers splitter;
    private final Thread producerThread;
    private final Thread splitterThread;
    private final Thread beerConsumerThread;
    private final Thread sodaConsumerThread;

    public StartOperation() {
        mainBuffer = new BufferService(10);
        beerBuffer = new BufferService(10);
        sodaBuffer = new BufferService(10);
        bottleBuilder = new BottleBuilder();

        producerThread = new Thread(new Producer(mainBuffer, bottleBuilder));
        splitter = new BottleControllers(mainBuffer, beerBuffer, sodaBuffer);
        splitterThread = new Thread(splitter);
        beerConsumerThread = new Thread(new Consumer(beerBuffer, "Øl-Consumer"));
        sodaConsumerThread = new Thread(new Consumer(sodaBuffer, "Sodavands-Consumer"));
    }

    public void start() {
        producerThread.start();
        splitterThread.start();
        beerConsumerThread.start();
        sodaConsumerThread.start();
    }

    public void stop() {
        producerThread.interrupt();
        splitterThread.interrupt();
        beerConsumerThread.interrupt();
        sodaConsumerThread.interrupt();
    }
}
