public class Main {
    public static void main(String[] args) {
        Oberinserat InserateContainer = new Oberinserat("Container");
        Oberinserat OberklasseHaus = new Oberinserat("Häuser");
        Oberinserat OberklasseWohnung = new Oberinserat("Wohnungen");
        Oberinserat OberklasseBungalow = new Oberinserat("Bungalows");

        InserateContainer.add(OberklasseHaus, OberklasseWohnung, OberklasseBungalow);

        Inserat inserat1 = new Inserat("Helle Wohnung in Berlin", new Standort("DE", "NRW", "Berlin", "10629", "Mommsenstraße 5"), 500.0);
        inserat1.add(
                new Eigenschaft("Größe", 120.0),
                new Eigenschaft("Zimmerzahl", 3.0)
        );

        Inserat inserat2 = new Inserat("andere Wohnung", new Standort("DE", "NRW", "Bochum", "10629", "Mommsenstraße 5"), 300.0);
        inserat2.add(
                new Eigenschaft("Größe", 90.0),
                new Eigenschaft("Zimmerzahl", 4.0)
        );

        Inserat haus1 = new Inserat("Testhaus", new Standort("DE", "NRW", "Berlin", "10629", "Mommsenstraße 5"), 150000.0);
        haus1.add(
                new Eigenschaft("Größe", 90.0),
                new Eigenschaft("Zimmerzahl", 4.0)
        );

        OberklasseWohnung.add(inserat1, inserat2, haus1);

        InserateContainer.remove(haus1);

        InserateContainer.print();

        System.out.println(InserateContainer.getPreis()+"€");

        Oberinserat suchergebnisse = InserateContainer.suche(
                new Filter("Stadt", "Berlin"),
                new Filter("Größe", 80.0, "min"),
                new Filter("Größe", 150.0, "max"),
                new Filter("Zimmerzahl", 2.0, "min"),
                new Filter("Preis", 1000.0, "max")
        );

        Bild b = new Bild("a", "png", "src\\rub.png", 100);
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