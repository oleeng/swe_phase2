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

        Inserat inserat1 = new Inserat("Helle Wohnung in Berlin", new Standort("DE", "NRW", "Berlin", "10629", "Mommsenstraße 5"), 500.0);
        inserat1.addEigenschaften(
                new Eigenschaft("Größe", 120.0),
                new Eigenschaft("Zimmerzahl", 3.0)
        );

        Inserat inserat2 = new Inserat("andere Wohnung", new Standort("DE", "NRW", "Bochum", "10629", "Mommsenstraße 5"), 300.0);
        inserat2.addEigenschaften(
                new Eigenschaft("Größe", 90.0),
                new Eigenschaft("Zimmerzahl", 4.0)
        );

        Inserat haus1 = new Inserat("Testhaus", new Standort("DE", "NRW", "Berlin", "10629", "Mommsenstraße 5"), 150000.0);
        haus1.addEigenschaften(
                new Eigenschaft("Größe", 90.0),
                new Eigenschaft("Zimmerzahl", 4.0)
        );

        OberklasseWohnung.add(inserat1);
        OberklasseWohnung.add(inserat2);

        OberklasseHaus.add(haus1);

        InserateContainer.remove(haus1);

        InserateContainer.print();

        System.out.println(InserateContainer.getPreis()+"€");

        ArrayList<Inserat> suchergebnisse = InserateContainer.suche(
                new Filter("Stadt", "Berlin", ""),
                new Filter("Größe", "80", "min"),
                new Filter("Größe", "150", "max"),
                new Filter("Zimmerzahl", "2", "min"),
                new Filter("Preis", "1000", "max")
        );

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