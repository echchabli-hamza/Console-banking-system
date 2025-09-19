package models;

import java.util.ArrayList;

abstract public class Compte {

    private String code;
    private double solde;
    private static int count = 0;
    private ArrayList<Operation> listeOperations = new ArrayList<>();


    public Compte(double solde) {
        count++;
        this.code = this.getId();
        this.solde = solde;

    }

    private String getId() {

                 return String.format("CPT-%05d", count);

    }

    public String getCode() {
        return this.code;
    }

    public double getSold() {
        return this.solde;
    }

    public void setSold(double amount) {
        this.solde = amount;


    }


    public void addOperation(Operation op) {

        this.listeOperations.add(op);

    }

    public ArrayList<Operation> getOpList() {

        return this.listeOperations;


    }


    abstract public boolean retirer(double amount);

    abstract public boolean addAmount(double amount);

    abstract public String afficherDetails();

    abstract public void calculerInteret();


    @Override
    public String toString() {
        return "Compte{" +
                "solde=" + solde +
                "code=" + code;
    }


}
