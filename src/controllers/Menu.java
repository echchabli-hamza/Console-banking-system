package controllers;

import java.util.Scanner ;

public class Menu {


    private AllFunctions a = new AllFunctions();



    public void index(){


        System.out.println(
          "1 : Créer un compte \n"+
          "2 : Effectuer un retrait dans un compte \n"+
          "3 : Effectuer un verment d'un compte \n"+
          "4 : Effectuer un virement entre comptes \n"+
          "5 : Consulter le solde du compte \n"+
          "6 : Consulter la liste des opérations "
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

        }
        this.index();
    }
}
