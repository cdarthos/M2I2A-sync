package exclusion_mutuelle_synchronisation_3_5;

public class ModifDonnees extends Thread{

    static MesCoordonnees c;
    static int i = 0;

    String myName;
    String myAddress;

    private int me;

    ModifDonnees (String n, String a, int me){
        myName = n;
        myAddress = a;
        this.me = me;
    }

    @Override
    public void run() {
        c.maj(myName, myAddress, me);

        System.out.println( "Les donnees de " + me + " partages : " + c.name + " " + c .address);
    }

    public static void main (String args[]){
        Thread t1 = new ModifDonnees( "Cyann", "lit cabanne", 1);
        Thread t2 = new ModifDonnees("Neve", "lit bebe", 2);
        c = new MesCoordonnees();
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e){
            System.out.println(e);
        }

        System.out.println("Mes donnees courantes : " + c.name + " " + c.address);

    }

}
