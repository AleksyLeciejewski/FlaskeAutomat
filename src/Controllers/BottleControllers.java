package Controllers;

import Model.Bottle;
import UseCase.BufferService;

public class BottleControllers implements Runnable {
    private final BufferService beerBuffer;
    private final BufferService sodaBuffer;
    private final BufferService mainBuffer;

    public BottleControllers(BufferService mainBuffer, BufferService beerBuffer, BufferService sodaBuffer) {
        this.mainBuffer = mainBuffer;
        this.beerBuffer = beerBuffer;
        this.sodaBuffer = sodaBuffer;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Bottle bottle = mainBuffer.removeBottle(); // Hent en flaske fra hovedbuffer
                System.out.println("BottleControllers behandler: " + bottle);
                processBottle(bottle);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("BottleControllers blev afbrudt.");
                break;
            }
        }
    }

    private void processBottle(Bottle bottle) {
        if (bottle == null || bottle.getName() == null) {
            System.out.println("Fejl: Flasken kan ikke behandles.");
            return;
        }

        int type = defineBottleType(bottle);
        bottle.setType(type);

        try {
            if (type == 1) {
                beerBuffer.addBottle(bottle);
                System.out.println(bottle.getName() + " sendt til Øl-buffer.");
            } else if (type == 2) {
                sodaBuffer.addBottle(bottle);
                System.out.println(bottle.getName() + " sendt til Sodavands-buffer.");
            } else {
                System.out.println("Ukendt flasketype: " + bottle.getName());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Flaskesortering afbrudt.");
        }
    }

    private int defineBottleType(Bottle bottle) {
        String name = bottle.getName().toLowerCase();
        if (name.contains("øl")) {
            return 1;
        } else if (name.contains("sodavand")) {
            return 2;
        }
        return 0;
    }
}
