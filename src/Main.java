import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Ausgabe Hello World!

        Oberinserat InserateContainer = new Oberinserat("Alle Inserate");
        Oberinserat OberklasseHaus = new Oberinserat("Häuser");
        Oberinserat OberklasseWohnung = new Oberinserat("Wohnungen");
        Oberinserat OberklasseBungalow = new Oberinserat("Bungalows");

        InserateContainer.addInserat(OberklasseHaus);
        InserateContainer.addInserat(OberklasseWohnung);
        InserateContainer.addInserat(OberklasseBungalow);

        Inserat inserat1 = new Inserat("Helle Wohnung in Berlin", new Standort("DE", "NRW", "Berlin", 10629, "Mommsenstraße 5"));
        inserat1.addEigenschaft("Größe", 120.0);
        inserat1.addEigenschaft("Zimmerzahl", 3.0);

        OberklasseWohnung.addInserat(inserat1);

        InserateContainer.printAll();

        ArrayList<Inserat> suchergebnisse = InserateContainer.suche(
                new Filter("Stadt", "Berlin", ""),
                new Filter("Größe", "100", "min"),
                new Filter("Größe", "150", "max"),
                new Filter("Zimmerzahl", "2", "min")
        );

        System.out.println();
        System.out.println();
        System.out.println();


        System.out.println("Suchergebnisse:");
        if(suchergebnisse == null){
            System.out.println("Fehlerhafte Filter");
            System.out.println("Siehe Konsolenausgabe für Gründe");
        }else{
            for(Inserat inserat: suchergebnisse){
                inserat.print(0);
            }
        }
    }
}