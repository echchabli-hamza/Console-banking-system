package models.operations.variables;

public enum Destinations {
        DISTRIBUTEUR_ATM,
        CHEQUE,
        VIREMENT_SORTANT;



    public static Destinations fromChoice(int choice) {
        if (choice >= 1 && choice <= Destinations.values().length) {
            return Destinations.values()[choice - 1];
        } else {
            return null; // or throw IllegalArgumentException
        }
    }




}
