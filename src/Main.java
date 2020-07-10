import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Oberinserat InserateContainer = new Oberinserat("Container");
        Oberinserat OberklasseHaus = new Oberinserat("Häuser");
        Oberinserat OberklasseWohnung = new Oberinserat("Wohnungen");
        Oberinserat OberklasseBungalow = new Oberinserat("Bungalows");

        InserateContainer.add(OberklasseHaus);
        InserateContainer.add(OberklasseWohnung);
        InserateContainer.add(OberklasseBungalow);

        Inserat inserat1 = new Inserat("Helle Wohnung in Berlin", new Standort("DE", "NRW", "Berlin", "10629", "Mommsenstraße 5"));
        inserat1.addEigenschaft("Größe", 120.0);
        inserat1.addEigenschaft("Zimmerzahl", 3.0);

        Inserat inserat2 = new Inserat("andere Wohnung", new Standort("DE", "NRW", "Bochum", "10629", "Mommsenstraße 5"));
        inserat2.addEigenschaft("Größe", 90.0);
        inserat2.addEigenschaft("Zimmerzahl", 4.0);

        OberklasseWohnung.add(inserat1);
        OberklasseWohnung.add(inserat2);

        InserateContainer.print();

        ArrayList<Inserat> suchergebnisse = InserateContainer.suche(
                new Filter("Stadt", "Berlin", ""),
                new Filter("Größe", "80", "min"),
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
                inserat.print();
            }
        }
    }
}