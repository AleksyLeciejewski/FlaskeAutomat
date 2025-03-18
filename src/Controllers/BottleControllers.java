package Controllers;

import Model.Bottle;

public class BottleControllers {

    public Bottle IdentifyBottle(Bottle bottle){
        if (bottle.name.contains("øl")){
        notifyAll();
        }

        if(bottle.name.contains("sodavand")){
        notifyAll();
        }

    return bottle;}



}
