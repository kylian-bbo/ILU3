package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import tri.GestionCollectionMusicale;

public class InterfaceUtilisateur {
    private static final String ROUGE = "\033[31m";
    private static final String FIN_ROUGE = "\033[0m";

    private static Scanner scanner;
    private static int etat;
    private static GestionCollectionMusicale gestionCollectionMusicale;
    
    protected static void demarrage() {
        scanner = new Scanner(System.in);

        effacerTerminal();
        afficherLogo();

        System.out.print("Appuyez sur la touche Entrée pour commencer.");
        scanner.nextLine();

        etat = 0;
        gestionCollectionMusicale = new GestionCollectionMusicale(GenerationCollectionMusicale.genererCollectionMusicale());

        effacerTerminal();
        menu();
    }

    private static void menu() {
        afficherLogo();

        Boolean entreeCorrecte = false;

        while (!entreeCorrecte) {
            try {
                System.out.println(
                "Que souhaitez vous faire ? (Entrez 1,2 ou 3)\n"
                + "1 - Trier la collection musicale\n"
                + "2 - Afficher la collection musicale\n"
                + "3 - Quitter le programme.\n"
                );
                System.out.print("Votre choix : ");
                etat = scanner.nextInt();

                if (etat < 1 || etat > 3 || etat == '\n')
                    throw new InputMismatchException();

                entreeCorrecte = true;
            
            } catch (InputMismatchException exception) {
                effacerTerminal();
                afficherLogo();
                System.out.println(ROUGE + "Erreur : Entrée incorrecte, réessayez.\n" + FIN_ROUGE);
                scanner.nextLine();
            }
        }

        scanner.nextLine();
        effacerTerminal();

        menuSwitch();
    }
    
    private static void menuSwitch() {
        afficherLogo();
        switch(etat) {
            case 1:
                //TODO : Tri de la collection musicale
                System.out.println(ROUGE + "Erreur : Pas encore implémenté.\n" + FIN_ROUGE);
                afficherEntreePourRevenirAuMenu();
                break;
            case 2:
                System.out.println("Affichage de la collection musicale :\n");
                 gestionCollectionMusicale.afficherCollectionMusicale();
                afficherEntreePourRevenirAuMenu();
                break;
            case 3:
                finProgramme();
                return;
            default:
                System.out.println("Erreur : Problème swith(etat), retour au menu principal.");
                break;
         }
        menu();
    }

    public static void finProgramme() {
        scanner.close();
        effacerTerminal();
        System.out.println("Arrêt du programme.");
    }

    private static void afficherLogo() {
        String logo =
        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
        " _____  _      _   _  _____	      _____  _____   _____  _____  _____  _____\n" +
        "|_   _|| |    | | | ||___  |         |  _  ||  _  | |  _  ||__ __||  ___||__ __|\n" +
        "  | |  | |    | | | |   _| |  _____  | |_| || |_| | | | | |  | |  | |__    | |\n" +
        "  | |  | |    | | | |  |_  | |_____| |  ___||  _ |  | | | |  | |  |  __|   | |\n" +
        " _| |_ | |___ | |_| | ___| |         | |    | | \\ \\ | |_| | _| |  | |___   | |\n" +
        "|_____||_____| \\___/ |_____| 	     |_|    |_|  \\_\\|_____||___|  |_____|  |_|\n" +
        "\n\t\tGestion d'une collection musicale ~ Par ...\n\n" +
        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";

        System.out.println(logo);
    }

    private static void afficherEntreePourRevenirAuMenu() {
        System.out.print("Appuyez sur Entrée pour retourner au menu principal.");
        scanner.nextLine();
        effacerTerminal();
    }

    private static void effacerTerminal() {
        //Place le curseur en haut à gauche et efface le terminal
        System.out.print("\033[H\033[2J");
    }

    //Au cas-où
    //private static void effacerLigneTerminal() {
    //    //Place le curseur une ligne en arrière et efface la ligne
    //    System.out.println("\033[F\033[K");
    //}
}
