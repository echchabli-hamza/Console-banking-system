package controllers;

import models.Compte;
import models.Operation;
import models.comptes.CompteCourant;
import models.comptes.CompteEpargne;
import models.operations.Retrait;
import models.operations.Versement;
import models.operations.variables.Destinations;
import models.operations.variables.Sources;

import java.util.HashMap;
import java.util.Scanner;

public class AllFunctions {


    HashMap<String , Compte> liste = new HashMap<>();

    private Scanner sc = new Scanner(System.in);





    public void addCompte(){


        Compte c1 ;


        System.out.println("type de Compte : \n"+ "enter 1 pour Courant \n" + "enter 2 pour Epargne");

         int choix = sc.nextInt();

         if(choix==1){
             System.out.println("entre votre solde");

             double solde = sc.nextDouble();
             sc.nextLine();

             System.out.println("entre votre decouvert");

             double decouvert = sc.nextDouble();
             sc.nextLine();



              c1= new CompteCourant(solde , decouvert);

             System.out.println(c1.getCode());

             liste.put(c1.getCode(), c1);

         }else{
             System.out.println("entre votre solde");

             double solde = sc.nextDouble();
             sc.nextLine();

             System.out.println("entre votre tauxInteret");

             int tauxInteret = sc.nextInt();
             sc.nextLine();



              c1= new CompteEpargne(solde , tauxInteret);


             liste.put(c1.getCode(), c1);


         }


         System.out.println(c1.toString());



    }


    public void retrait(){


        Compte c1 ;


        System.out.println("enter votre numero the compte");

        String numero= sc.nextLine().trim();

        if (liste.containsKey(numero)){
            c1=liste.get(numero);


            Destinations result = checkDes();


            System.out.println("entrer le montant");
            double montant = sc.nextDouble();
            sc.nextLine();

            boolean res = c1.retirer(montant);

            if (res){
                System.out.println("votre solde aprés la opération est "+c1.getSold());

                Retrait operationR = new Retrait(montant , result);
                c1.addOperation(operationR);

            }else{

                System.out.println("you dont have enough solde , votre solde : " +c1.getSold());

            }




        }else{

            System.out.println("there is no account with this numero");

        }




    }


    public void virement(){

        Compte c1 ;


        System.out.println("enter votre numero the compte");

        String numero= sc.nextLine().trim();

        if (liste.containsKey(numero)){
            c1=liste.get(numero);

            Sources result = checkSource();

            System.out.println("entrer le montant");
            double montant = sc.nextDouble();
            sc.nextLine();

            boolean res = c1.addAmount(montant);

            Versement v = new Versement(montant , result);
            c1.addOperation(v);


                System.out.println("votre solde aprés la opération est "+c1.getSold());





        }else{

            System.out.println("there is no account with this numero");

        }



    }



    public void soldeDeCompte(){

        Compte c1 ;


        System.out.println("enter votre numero the compte");

        String numero= sc.nextLine().trim();

        if (liste.containsKey(numero)) {

            c1 = liste.get(numero);
            System.out.println(c1.getSold());

        }else{

            System.out.println("there is no account with this numero");

        }



    }




    public void listeDesOperations(){
        Compte c1 ;


        System.out.println("enter votre numero the compte");

        String numero= sc.nextLine().trim();

        if (liste.containsKey(numero)) {

            c1 = liste.get(numero);

            for (Operation o : c1.getOpList()){

                System.out.println(o.toString());

            }

        }else{

            System.out.println("there is no account with this numero");

        }

    }



    public void verment() {


        Compte c1;
        Compte c2;

        System.out.println("enter votre numero the compte");

        String numero1 = sc.nextLine().trim();

        if (liste.containsKey(numero1)) {

            c1 = liste.get(numero1);

            System.out.println("entrer le numero  de l'autre compte");

            String numero2 = sc.nextLine().trim();

            if (liste.containsKey(numero2)) {


                c2 = liste.get(numero2);





                System.out.println("entrer le montant");
                double montant = sc.nextDouble();
                sc.nextLine();

                boolean res = c1.retirer(montant);

                if (res) {
                    System.out.println("votre solde aprés la opération est " + c1.getSold());

                    Retrait operationR = new Retrait(montant, Destinations.VIREMENT_SORTANT);
                    c1.addOperation(operationR);





                     Boolean resDeVirment = c2.addAmount(montant);

                    Versement v = new Versement(montant , Sources.VIREMENT_EXTERNE);
                    c1.addOperation(v);

                } else {

                    System.out.println("you dont have enough solde , votre solde : " + c1.getSold());

                }





            } else {

                System.out.println("there is no account with this numero");

            }


        }

    }












  public Destinations checkDes(){

      boolean checkIfExist = false;
      Destinations destination = null;

      do {
          System.out.println("Enter the source of the money");

          System.out.println("Choisissez la destination :");
          System.out.println("1 - CHEQUE");
          System.out.println("2 - DISTRIBUTEUR_ATM");
          System.out.println("3 - VIREMENT_SORTANT");

          int choice = sc.nextInt();
          destination = Destinations.fromChoice(choice);

          if (destination != null) {
              checkIfExist = true; // valid choice → exit loop
          } else {
              System.out.println("Choix invalide, réessayez.");
          }

      } while (!checkIfExist);

      return destination;



  }



    public Sources checkSource() {
        Sources source = null;

        do {
            System.out.println("Enter the source of the money");

            System.out.println("Choisissez la source :");
            System.out.println("1 - VIREMENT_EXTERNE");
            System.out.println("2 - DEPOT_ESPECES");
            System.out.println("3 - SALAIRE");

            int choice = sc.nextInt();
            source = Sources.fromChoice(choice);

            if (source == null) {
                System.out.println("Choix invalide, réessayez.");
            }

        } while (source == null);

        return source;
    }






    public void display(){
        for(Compte c :liste.values()){

            System.out.println(c.afficherDetails());

        }

        for(String c :liste.keySet()){

            System.out.println(c);

        }
    }


//    public void addIntrest(){
//
//
//        for(Compte c :  liste.values()){
//
//
//            System.out.println(c.getSold());
//            c.calculerInteret();
//            System.out.println(c.getSold());
//
//            System.out.println("///////////////////////////////");
//
//
//        }
//
//
//
//
//    }

    public void addIntrest() {
        for (Compte c : liste.values()) {
            System.out.println("Before: " + c.getSold());
            c.calculerInteret();
            System.out.println("After: " + c.getSold());
            System.out.println("///////////////////////////////");
        }
    }


}
