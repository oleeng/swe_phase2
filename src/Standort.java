public class Standort {
    private String land;
    private String bundesland;
    private String stadt;
    private int plz;
    private String strasse;

    public Standort(String land, String bundesland, String stadt, int plz, String strasse){
        this.land = land;
        this.bundesland = bundesland;
        this.stadt = stadt;
        this.plz = plz;
        this.strasse = strasse;
    }

    public String getLand() {
        return land;
    }

    public String getBundesland() {
        return bundesland;
    }

    public String getStadt() {
        return stadt;
    }

    public int getPlz() {
        return plz;
    }

    public String getStrasse() {
        return strasse;
    }

    public void printKarte(){
        System.out.println("gebe hier eine Karte der Location aus.....");
    }
}
