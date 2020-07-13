public class Standort {
    private String land;
    private String bundesland;
    private String stadt;
    private String plz;
    private String strasse;

    public Standort(String land, String bundesland, String stadt, String plz, String strasse){
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

    public String getPLZ() {
        return plz;
    }

    public String getStrasse() {
        return strasse;
    }

    public void printKarte(){
        /*URL url = new URL("http://example.com");
HttpURLConnection con = (HttpURLConnection) url.openConnection();
con.setRequestMethod("GET");*/
        System.out.println("gebe hier eine Karte der Location aus.....");
    }
}
