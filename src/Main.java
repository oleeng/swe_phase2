import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        InseratContainer Container = new InseratContainer("Container");
        InseratContainer OberklasseHaus = new InseratContainer("Häuser");
        InseratContainer OberklasseWohnung = new InseratContainer("Wohnungen");
        InseratContainer OberklasseBungalow = new InseratContainer("Bungalows");

        Container.add(OberklasseHaus, OberklasseWohnung, OberklasseBungalow);

        Inserat inserat1 = new Inserat("Helle Wohnung in Berlin", new Standort("Deutschland", "NRW", "Berlin", "10629", "Mommsenstraße 5"), 500.0, "Wohnung", "mieten");
        inserat1.add(
                new Eigenschaft("Größe", 120.0),
                new Eigenschaft("Zimmerzahl", 3.0)
        );

        Inserat inserat2 = new Inserat("andere Wohnung", new Standort("Deutschland", "NRW", "Bochum", "10629", "Mommsenstraße 5"), 300.0, "Wohnung", "mieten");
        inserat2.add(
                new Eigenschaft("Größe", 90.0),
                new Eigenschaft("Zimmerzahl", 4.0)
        );

        Inserat haus1 = new Inserat("Testhaus", new Standort("Deutschland", "NRW", "Berlin", "10629", "Mommsenstraße 5"), 150000.0, "Haus", "kaufen");
        haus1.add(
                new Eigenschaft("Größe", 90.0),
                new Eigenschaft("Zimmerzahl", 4.0)
        );

        OberklasseWohnung.add(inserat1, inserat2, haus1);

        Container.remove(haus1);

        Container.print();

        System.out.println(Container.getPreis()+"€");

        InseratContainer suchergebnisse = Container.suche(
                new Filter("Stadt", "Berlin"),
                new Filter("Größe", 80.0, "min"),
                new Filter("Größe", 150.0, "max"),
                new Filter("Zimmerzahl", 2.0, "min"),
                new Filter("Preis", 1000.0, "max")
        );

        Bild b = null;
        try {
            b = new Bild("a", "img\\rub.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        b.anzeigen();

        Standort s1 = new Standort("DE", "NRW", "Bochum", "44789", "Königsallee 77-79");
        s1.printKarte(14);

        System.out.println("Suchergebnisse:");
        if(suchergebnisse == null){
            System.out.println("Fehlerhafte Filter");
            System.out.println("Siehe Konsolenausgabe für Gründe");
        }else{
            suchergebnisse.print();
        }
    }
}