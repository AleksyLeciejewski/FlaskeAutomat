package Service;

import Model.Bottle;

public class Consumer implements Runnable {

    @Override
    public void run() {
    while(true){
        try{
        Bottle bottle = bufferService.removeBottle();
        System.out.println("Consumer: Behandler " + bottle);
        Thread.sleep(1500);
            System.out.println("");

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }



    }

    public Consumer(BufferService bufferService){

    }



}
