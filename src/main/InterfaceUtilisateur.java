package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import musiques.Musique;
import tri.Appreciation;
import tri.GestionCollectionMusicale;

public class InterfaceUtilisateur {
    private static final String ROUGE = "\033[31m";
    private static final String FIN_ROUGE = "\033[0m";
    private static final String BLEU = "\u001B[34m";
    private static final String FIN_BLEU = "\u001B[0m";
    private static final String VERT = "\033[32m";
    private static final String FIN_VERT = "\033[0m";


    private static Scanner scanner;
    private static int choix;
    private static GestionCollectionMusicale gestionCollectionMusicale;
    
    protected static void demarrage() {
        scanner = new Scanner(System.in);

        effacerTerminal();
        afficherLogo();

        System.out.print("Appuyez sur la touche Entrée pour commencer.");
        scanner.nextLine();

        gestionCollectionMusicale = new GestionCollectionMusicale(GenerationCollectionMusicale.genererCollectionMusicale());

        effacerTerminal();
        menu();
    }

    private static void menu() {
        choix = 0;
        Boolean entreeCorrecte = false;

        afficherLogo();

        while (!entreeCorrecte) {
            try {
                System.out.println(
                "Que souhaitez vous faire ? (Entrez 1,2 ou 3)\n\n"
                + "\t1 - Trier la collection musicale\n"
                + "\t2 - Afficher la collection musicale\n"
                + "\t3 - Quitter le programme.\n"
                );
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();

                if (choix < 1 || choix > 3 || choix == '\n')
                    throw new InputMismatchException();

                entreeCorrecte = true;
            
            } catch (InputMismatchException e) {
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
        switch(choix) {
            case 1:
                menuTri();
                break;
            case 2:
                afficherLogo();
                System.out.println("Affichage de la collection musicale :\n");
                 gestionCollectionMusicale.afficherCollectionMusicale();
                afficherEntreePourRevenirAuMenu();
                break;
            case 3:
                finProgramme();
                return;
            default:
                System.out.println("Erreur : Problème menuSwitch, retour au menu principal.");
                break;
         }
        menu();
    }

    private static void menuTri() {
        afficherLogo();

        choix = 0;
        Boolean entreeCorrecte = false;

        while (!entreeCorrecte) {
            try {
                System.out.println(
                    "Dans quel ordre souhaitez vous lire les musique ? (Entrez 1, 2, 3 ou 4)\n\n" +
                    "\t1 - Par ajout dans la collection.\n" +
                    "\t2 - Par titres.\n" +
                    "\t3 - Par nom d'artistes.\n" +
                    "\t4 - Par durée.\n"
                );
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();

                if (choix < 1 || choix > 4 || choix == '\n')
                    throw new InputMismatchException();

                entreeCorrecte = true;
            } catch (InputMismatchException e) {
                effacerTerminal();
                afficherLogo();
                System.out.println(ROUGE + "Erreur : Entrée incorrecte, réessayez.\n" + FIN_ROUGE);
                scanner.nextLine();
            }
        } 

        scanner.nextLine();
        effacerTerminal();

        menuTriMusiques(gestionCollectionMusicale.genererListeMusiques(choix));
    }

    private static void menuTriMusiques(Musique[] listeMusiques) {
        for (Musique musique : listeMusiques) {
            afficherLogo();

            choix = 0;
            Boolean entreeCorrecte = false;

            while (!entreeCorrecte) {
                try {
                    System.out.println("Musique en cours de lecture :\n");
                    System.out.println("\t" + BLEU + musique + FIN_BLEU);
                    System.out.println("\nQuelle appréciation donnez-vous à cette musique ? (Entrer 1, 2, 3, 4, 5)\n" +
                        "\n\t1 - " + Appreciation.UNE_ETOILE +
                        "\n\t2 - " + Appreciation.DEUX_ETOILES +
                        "\n\t3 - " + Appreciation.TROIS_ETOILES +
                        "\n\t4 - " + Appreciation.QUATRE_ETOILES +
                        "\n\t5 - " + Appreciation.CINQ_ETOILES
                    );
                    System.out.print("\nVotre choix : ");
                    choix = scanner.nextInt();
                    
                    if (choix < 1 || choix > 5 || choix == '\n')
                        throw new InputMismatchException();

                    entreeCorrecte = true;
                } catch (InputMismatchException e) {
                    effacerTerminal();
                    afficherLogo();
                    System.out.println(ROUGE + "Erreur : Entrée incorrecte, réessayez.\n" + FIN_ROUGE);
                    scanner.nextLine();
                }
            }
            
            if (!gestionCollectionMusicale.ajouterMusiqueNotee(musique, choix)) {
                System.out.println("Erreur : Problème menuSwitch, retour au menu principal.");
                return;
            }
            
            scanner.nextLine();
            effacerTerminal();
        }

        menuMusiqueTriees("Les musiques ont été notées avec succès.");
    }

    private static void menuMusiqueTriees(String messageSucces) {
        afficherLogo();

        choix = 0;
        Boolean entreeCorrecte = false;

        while (!entreeCorrecte) {
            if (messageSucces != null)
                System.out.println(VERT + messageSucces + FIN_VERT + '\n');

            try {
                System.out.println("Que souhaitez vous faire désormais ? (entrer 1, 2 ou 3)\n" + 
                    "\n\t1 - Afficher les musique en fonction de leur appréciation." +
                    "\n\t2 - Supprimer les musiques ayant une appréciation inférieure à X étoiles." +
                    "\n\t3 - Revenir au menu principal.\n"
                );
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();

                if (choix < 1 || choix > 3 || choix == '\n')
                    throw new InputMismatchException();

                entreeCorrecte = true;
            } 
            catch (InputMismatchException e) {
                effacerTerminal();
                afficherLogo();
                System.out.println(ROUGE + "Erreur : Entrée incorrecte, réessayez.\n" + FIN_ROUGE);
                scanner.nextLine();
            }

            scanner.nextLine();
            effacerTerminal();
        }
        
        menuSwitchMusiqueTriees();
    }

    private static void menuSwitchMusiqueTriees() {
        String messageSucces = null;

        switch(choix) {
            case 1:
                //Afficher les musique en fonction de leur appréciation
                afficherLogo();
                gestionCollectionMusicale.afficherMapMusique();

                System.out.print("\nAppuyez sur Entrée pour retourner au menu précédent.");
                scanner.nextLine();
                break;
            case 2:
                //Supprimer les musiques ayant une note inférieure à X
                messageSucces = menuSupprimerMusiquesNoteInfX();
                break;
            case 3:
                //Revenir au menu principal
                return;
            default:
                System.out.println("Erreur : Problème menuSwitchMusiqueTriees, retour au menu principal.");
                return;
        }

        effacerTerminal();
        menuMusiqueTriees(messageSucces);
    }

    private static String menuSupprimerMusiquesNoteInfX() {
        afficherLogo();

        choix = 0;
        Boolean entreeCorrecte = false;

        while (!entreeCorrecte) {
            try {
                System.out.print("Entrer le nombre minimum d'étoiles désiré (Entrer 2, 3, 4 ou 5): ");
                choix = scanner.nextInt();

                if (choix < 2 || choix > 5 || choix == '\n')
                    throw new InputMismatchException();

                entreeCorrecte = true;
            } 
            catch (InputMismatchException e) {
                effacerTerminal();
                afficherLogo();
                System.out.println(ROUGE + "Erreur : Entrée incorrecte, réessayez.\n" + FIN_ROUGE);
                scanner.nextLine();
            } 
        }

        scanner.nextLine();
        effacerTerminal();

        gestionCollectionMusicale.supprimerMusiquesNoteInfX(choix);
        return "Les musiques de moins de " + choix + " étoiles ont été supprimées avec succès";
    }

    private static void finProgramme() {
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
        "\n\t\t\tGestion d'une collection musicale\n\n" +
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