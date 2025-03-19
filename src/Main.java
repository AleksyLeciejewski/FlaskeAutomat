import UseCase.StartOperation;

public class Main {
    public static void main(String[] args) {
        StartOperation operation = new StartOperation();
        operation.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Stopper produktion");
        operation.stop();
    }
}
