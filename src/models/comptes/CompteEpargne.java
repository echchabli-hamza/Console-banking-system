package models.comptes;

import models.Compte;

public class CompteEpargne extends Compte {

    public int tauxInteret = 20;


    public CompteEpargne(double solde, int taux) {
        super(solde);
        this.tauxInteret = taux;
    }

    @Override
    public String afficherDetails() {
        return "your code : " + this.getCode() + "your sold : " + this.getSold();

    }

    @Override
    public void calculerInteret() {

        double newSold = getSold() + (getSold() * tauxInteret) / 100;

        setSold(newSold);

    }


    @Override
    public boolean retirer(double amount) {

        if (this.getSold() <= amount) {
            return false;
        } else {
            setSold(getSold() - amount);
            return true;
        }
    }


    @Override
    public boolean addAmount(double amount) {

        setSold(getSold() + amount);
        return true;


    }


}
