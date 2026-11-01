import java.util.Random;

public class Tamagotchi {
    private int age;
    private int dureeDeVie;
    private int maxEnergie;
    private int energie;
    private String nom;

    private static final Random alea = new Random();

    // Entier aléatoire entre min et max inclus
    private static int tirer(int min, int max) {
        return min + alea.nextInt(max - min + 1);
    }

    public Tamagotchi(String nom) {
        this.nom = nom;
        this.age = 0;
        this.dureeDeVie = tirer(9, 14);
        this.maxEnergie = tirer(5, 9);
        this.energie = tirer(3, maxEnergie);
      
    }

    public String getNom() {
        return nom;
    }

    public void parler() {
        if (energie > 3) {
            System.out.println(nom + " : tout va bien !");
        } else {
            System.out.println(nom + " : je suis affamé !");
        }
    }

    public void manger() {
        if (energie >= maxEnergie) {
            System.out.println(nom + " : je n'ai pas faim !!");
        } else {
            energie += tirer(1, 3);
            if (energie > maxEnergie) {
                energie = maxEnergie;
            }
            System.out.println(nom + " : Merci !");
        }
    }

    public boolean ageLimite() {
        return age == dureeDeVie;
    }

    public boolean vivre() {
        if (ageLimite()) {
            return true;
        }
        if (energie <= 0) {
            System.out.println(nom + " : je meurs... Arrrggh !");
            return false;
        }
        age++;
        energie--;
        if (ageLimite()) {
            System.out.println(nom + " : c'est gagné pour moi !");
        } else {
            parler();
        }
        return true;
    }
}