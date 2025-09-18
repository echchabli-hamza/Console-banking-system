package models.operations.variables;

public enum Sources {
    VIREMENT_EXTERNE,
    DEPOT_ESPECES,
    SALAIRE;


    public static Sources fromChoice(int choice) {
        if (choice >= 1 && choice <= Sources.values().length) {
            return Sources.values()[choice - 1];
        } else {
            return null;
        }
    }


}
