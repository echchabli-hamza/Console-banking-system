package models.comptes;

import models.Compte;

public class CompteCourant extends Compte {


    private double decouvert;





    public CompteCourant(double solde   , double decouvert){

        super(solde);

        this.decouvert = decouvert ;



    }










    @Override
    public boolean retirer(double amount) {

        if (amount  > this.getSold() +decouvert || this.getSold()<=0 ) {
            return false;
        } else {
            setSold(getSold() - amount);
            return true;
        }
    }


    @Override
    public String afficherDetails(){

        return "your code : "+ this.getCode() + "your sold : " + this.getSold() + "your decouvert : " + this.decouvert;


    }


    @Override
     public void calculerInteret(){



     };


    @Override
    public String toString(){
        return super.toString() + this.decouvert;
    }


    @Override
    public boolean addAmount(double amount){

        setSold(getSold()+amount);
        return true;


    }




}
