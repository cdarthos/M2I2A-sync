package Exercice_3_producteurConsommateur;

public class ProducteurConsommateur {
    static Buffer buffer = new Buffer(40);

    public static void main (String[] args){
        Producteur producteur = new Producteur( buffer );
        Consommateur consommateur = new Consommateur( buffer );

        producteur.start();
        consommateur.start();

        try {
            producteur.join();
            consommateur.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Ends");
    }
}
