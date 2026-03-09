/*
Crea un programa que simuli una batalla entre el teu heroi i un drac.
L’heroi comença amb 100 punts de vida i rep danys aleatoris entre 5 i 20 per torn.
Desa en un array la vida restant després de cada atac i mostra-la per pantalla.
Si la vida arriba a 0 o menys, mostra un missatge indicant que l’heroi ha estat derrotat
*/

public class RA6_A2_EX4 {
    public static void main(String[] args) { // 2check
        System.out.println("/// Arrays 2 | Exercici 4 | El combat contra el drac ///");

        int herohealth = 100;
        boolean battle = true;

        int[] afterbattle = new int[20]; // 20 és el n. de batalles màxim que pot sobreviure
        int battlenum = 0;

        while (battle) {
            battlenum++;
            int damage = (int) (Math.random()*15 + 5);

            System.out.println("El drac ha atacat a l'heroi!");
            herohealth -= damage;

            if (herohealth > 0) {
                System.out.println("L'heroi ha perdut [" + damage + "] de vida, li queda [" + herohealth + "] vida restants.");
                afterbattle[battlenum] = herohealth;
            } else {
                System.out.println("L'heroi ha perdut [" + damage + "] de vida, no li queda cap vida restant.");
                battle = false;
            }
            System.err.println(" / / ");
        }

        System.out.println("El heroi s'ha mort. Les seves batalles han sigut: ");
        for (int i = 0; i < afterbattle.length; i++) {
            if (afterbattle[i] > 0) {
                System.out.println("Després de la batalla [" + i + "], s'ha quedat amb [" + afterbattle[i] + "] de vida.");
            }
        }

    }
}
