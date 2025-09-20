package controllers;

import java.util.Scanner ;

public class Menu {

    private AllFunctions a ;


    public Menu( AllFunctions arg ){

        this.a = arg ;

    }






    public void index(){


        System.out.println(
                "\n=== Menu Principal ===\n" +
                        "1 : Créer un compte\n" +
                        "2 : Effectuer un retrait dans un compte\n" +
                        "3 : Effectuer un virement (ajout d’argent)\n" +
                        "4 : Afficher tous les comptes\n" +
                        "5 : Consulter le solde d’un compte\n" +
                        "6 : Consulter la liste des opérations\n" +
                        "7 : Effectuer un virement entre deux comptes\n" +
                        "0 : Quitter"
        );

        System.out.println("enter your choice");

        Scanner s = new Scanner(System.in);

        int choix = s.nextInt();
        System.out.println("Vous avez choisi : " + choix);

        this.process(choix);

        s.close(); // close the scanner


    }




    public void process(int choix){

        switch (choix){

            case 1 : a.addCompte();
            break ;
            case 2 : a.retrait();
                break ;
            case 3 : a.virement();
                break ;
            case 4 : a.display();
                break ;
            case 5 : a.soldeDeCompte();
                break ;
            case 6 : a.listeDesOperations();
                break ;
            case 7 : a.verment();
            break ;
            case 0: System.out.println("✅ Fin du programme.");
                System.exit(0);

            break;
            default:
                System.out.println("❌ Choix invalide ! Veuillez entrer un nombre entre 1 et 7.");

        }
        this.index();
    }
}
