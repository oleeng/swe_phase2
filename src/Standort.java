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

    public String getPlz() {
        return plz;
    }

    public String getStrasse() {
        return strasse;
    }

    public String getValue(String wert){
        String ret;
        switch (wert){
            case "Stadt":
                ret = stadt;
                break;
            case "Land":
                ret = land;
                break;
            case "Bundesland":
                ret = bundesland;
                break;
            case "PLZ":
                ret = plz;
                break;
            case "Straße":
                ret = strasse;
                break;
            default:
                ret = null;
                break;
        }
        return ret;
    }

    public void printKarte(){
        System.out.println("gebe hier eine Karte der Location aus.....");
    }
}
