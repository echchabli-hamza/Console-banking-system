package models.operations;

import models.Operation;
import models.operations.variables.Sources;


public class Versement extends Operation{

    private Sources source;


    public Versement(double montant, Sources source) {
        super(montant);
        this.source = source;
    }

    public Sources getSource(){

        return this.source;

    }

    @Override
    public String toString() {
        return super.toString()  +"Versement{" +
                "source=" + source +
                '}';
    }
}
