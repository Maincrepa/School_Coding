/*
Crea un array de 10 enters que representi la vida dels enemics.
Assigna a cada posició un valor aleatori entre 1 i 100.
Mostra quants enemics són febles (vida < 30), normals (30–70) i forts (>70).
Indica també la vida màxima i mínima trobades
*/

public class RA6_A2_EX3 {
    public static void main(String[] args) { // finished
        System.out.println("/// Arrays 2 | Exercici 3 | Els enemics ///");

        final int LOWHEALTHTH = 10; // constant (configuration)
        final int HIGHHEALTHTH = 70; // constant (configuration)
        final int slots = 15; // constant (configuration)

        int[] enemy_health = new int[slots]; // create table

        for (int i = 0; i < slots; i++) {
            enemy_health[i] = (int) ((Math.random() * 100) + 1); // assign rand 1-100
            System.out.println("El monstre [" + (i+1) + "] té " + enemy_health[i] + " HP."); 
        }

        int maxhealthpos = 0; // posició de l'enemic amb més vida
        int minhealthpos = 0; // posició de l'enemic amb menys vida
        int lastmax = 0; // variable per contar el int més gran
        int lastmin = 100; // variable per contar el int més petit

        // contar quants de cada tipus hi ha
        int lownum = 0;
        int midnum = 0;
        int highnum = 0;

        for (int v = 0; v < slots; v++) {
            // check if current is more than last
            if (enemy_health[v] > lastmax) { // comprovem si enemic té més vida que l'ultim
                maxhealthpos = v;
                lastmax = enemy_health[v];
            }
            if (enemy_health[v] < lastmin) { // comprovem si enemic té menys vida que l'ultim
                minhealthpos = v;
                lastmin = enemy_health[v];
            }
            // check per veure a quina categoria de vida entra el enemic
            if (enemy_health[v] < LOWHEALTHTH) {
                lownum++;
            } else if (enemy_health[v] > LOWHEALTHTH && enemy_health[v] < HIGHHEALTHTH) {
                midnum++;
            } else if (enemy_health[v] > HIGHHEALTHTH) {
                highnum++;
            }
        }

        System.out.println(" / / / ");

        System.out.println("El monstre [" + (maxhealthpos+1) + "] és el monstre amb més vida [" + enemy_health[maxhealthpos] + "]");
        System.out.println("El monstre [" + (minhealthpos+1) + "] és el monstre amb menys vida [" + enemy_health[minhealthpos] + "]");

        System.out.println("Quantitat de monstres amb poca vida: " + lownum);
        System.out.println("Quantitat de monstres amb vida normal: " + midnum);
        System.out.println("Quantitat de monstres amb molta vida: " + highnum);


    }
}
