package models;

import java.time.LocalDate;
import java.util.UUID;

import java.time.LocalDateTime;


public class Operation {


    private UUID numero;
    private LocalDateTime date;
    private double montant;


    public Operation(double montant) {

        this.numero = UUID.randomUUID();

        this.date = LocalDateTime.now();

        this.montant = montant;


    }


    public UUID getNumero() {

        return this.numero;

    }

    public LocalDateTime getDate() {

        return this.date;

    }

    public double getMontant() {

        return this.montant;

    }


    @Override
    public String toString() {
        return "Operation{" +
                "numero=" + numero +
                ", date=" + date +
                ", montant=" + montant +
                '}';
    }
}
