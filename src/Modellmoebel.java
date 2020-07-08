public class Modellmoebel {
    private String id;
    private String beschreibung;
    private String groesse;
    private String datenMoebel;

    public Modellmoebel(String beschreibung, String groesse, String datenMoebel){
        this.beschreibung = beschreibung;
        this.groesse = groesse;
        this.datenMoebel = datenMoebel;
        this.id = HelperStuff.genId();
    }

    public void print(){
        System.out.println("Möbel-ID: "+id);
        System.out.println("Beschreibung: "+beschreibung);
        System.out.println("Größe: "+groesse);
        System.out.println("Daten: "+datenMoebel);
    }

    public String getId() {
        return id;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public String getGroesse() {
        return groesse;
    }

    public String getDatenMoebel() {
        return datenMoebel;
    }
}
