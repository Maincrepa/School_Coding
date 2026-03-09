/*
Escriu un programa en Java que realitzi la següent seqüència d'operacions amb variables:
1. Declaració inicial:
    Crea una variable x de tipus enter amb valor inicial 8
    Crea una variable y de tipus enter amb valor inicial 3

2. Executa les operacions en aquest ordre exacte:
    Incrementa el valor de x assignant-li el doble de y
    Multiplica y per el resultat de restar 1 a x
    Assigna a x el residu de dividir x entre la suma de y més 1
    Disminueix y assignant-li la divisió entera de x entre 2

3. Mostra per pantalla:
    Els valors de x i y després de cada operació
    Els resultats de les següents expressions amb els valors finals:
        (x + y) * 2.5
        La conversió a enter de (x * y / 3.0)
        Si x és major que y, i y és parell
        Si el doble de la suma és major que el triple de y ,o la diferència és menor que 5

REQUISITS:
    Utilitza operadors d'assignació composta
    Mostra tots els càlculs intermitjos
    Format de sortida clar i organitzat
*/

public class EJ6_Sequencia {

    public static void main(String[] args) {
        System.out.println("// Exercici 6 // Seqüència d'operacions amb variables");

        // 1. Declarar variables

        int x = 8;
        int y = 3;

        // 2. Realitzar operacions

        System.out.println("Valor inicial abans d'operacions: " + "x: " + x + ", y: " + y);

        x += 2 * y; // Incrementa el valor de x assignant-li el doble de y
        System.out.println("Valor inicial abans d'operacions: " + "x: " + x + ", y: " + y);

        y *= (x - 1); // Multiplica y per el resultat de restar 1 a x
        System.out.println("Resultat de la primera operació (x += 2 * y): " + "x: " + x + ", y: " + y);

        x %= (y + 1); // Assigna a x el residu de dividir x entre la suma de y més 1
        System.out.println("Resultat de la tercera operació (x %= (y + 1)): " + "x: " + x + ", y: " + y);

        y -= x / 2; // Disminueix y assignant-li la divisió entera de x entre 2
        System.out.println("Resultat de la quarta operació (y -= x / 2): " + "x: " + x + ", y: " + y);


        // 3. Mostrar extra amb valors finals

        System.out.println("Resultat de (x + y) * 2.5 és: " + (int)((x + y) * 2.5) );
        
        boolean MayorQue = (x > y); // Si x és major que y
        System.out.println("X és major que Y? "+ MayorQue);

        boolean Parell = (y % 2 == 0); // Si y es parell
        System.out.println("Y es parell? " + Parell);



        boolean Val1 = (x > y) && (y % 2 == 0); // Si X és major que Y AND si Y es parell
        System.out.println("X és major que Y i Y es parell? "+ Val1);



        boolean Val2 = ( (2*(x + y)) > (3 * y) ) || ( ((x - y) < 5) );

       System.out.println("El doble de la suma és major que el triple de Y OR la diferència és menor que 5? " + Val2);

    }
}
