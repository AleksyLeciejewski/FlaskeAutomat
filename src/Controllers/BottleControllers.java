package Controllers;

import Model.Bottle;

public class BottleControllers {




    public Bottle IdentifyBottle(Bottle bottle){
        if (bottle.name.contains("øl")){
        notify();
        }

        if(bottle.name.contains("sodavand")){
        notify();
        }

    return bottle;}



}
