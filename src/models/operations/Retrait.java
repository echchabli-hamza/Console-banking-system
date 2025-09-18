package models.operations;


import models.Operation;
import models.operations.variables.Destinations;


public class Retrait  extends Operation {


    private Destinations destination;

    public Retrait(double montant, Destinations destination) {
        super(montant);
        this.destination = destination;
    }


    public Destinations getDestination(){

        return this.destination ;


    }

    @Override
    public String toString() {
        return super.toString() +"Retrait{" +
                "destination=" + destination +
                '}';
    }
}

