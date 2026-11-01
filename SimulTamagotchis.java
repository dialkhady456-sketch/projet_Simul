import java.util.Scanner;

public class SimulTamagotchis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n est fourni au lancement : java SimulTamagotchis 3
        int n = 3;
        if (args.length > 0) {
            n = Integer.parseInt(args[0]);
        }

        Tamagotchi[] colonie = new Tamagotchi[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Quel nom pour le nouveau tamagotchi : ");
            colonie[i] = new Tamagotchi(sc.nextLine());
        }

        boolean perdu = false;
        boolean gagne = false;
        int cycle = 0;

        while (!perdu && !gagne) {
            cycle++;
            System.out.println("-------Cycle no " + cycle + "-------");

            // Un cycle de vie pour tous
            for (int i = 0; i < n && !perdu; i++) {
                if (!colonie[i].vivre()) {
                    perdu = true;
                }
            }

            // Victoire : tous ont atteint leur âge limite
            gagne = true;
            for (int i = 0; i < n; i++) {
                if (!colonie[i].ageLimite()) {
                    gagne = false;
                }
            }

            // Si la partie continue : on nourrit un tamagotchi encore en vie
            if (!perdu && !gagne) {
                for (int i = 0; i < n; i++) {
                    if (!colonie[i].ageLimite()) {
                        System.out.print("(" + i + ")" + colonie[i].getNom() + " ");
                    }
                }
                System.out.println();
                System.out.print("Nourrir quel tamagotchi ? ");
                int choix = sc.nextInt();
                if (choix >= 0 && choix < n && !colonie[choix].ageLimite()) {
                    colonie[choix].manger();
                } else {
                    System.out.println("Choix invalide.");
                }
            }
        }

        if (gagne) {
            System.out.println("GAGNÉ !!");
        } else {
            System.out.println("PERDU !!");
        }
        sc.close();
    }
}