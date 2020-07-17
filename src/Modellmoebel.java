public class Modellmoebel {
    private String id;
    private String beschreibung;
    private String groesse;

    public Modellmoebel(String beschreibung, String groesse){
        this.beschreibung = beschreibung;
        this.groesse = groesse;
        this.id = Helper.genId();
    }

    public void print(){
        System.out.println("+-----------------------------------------------");
        System.out.println("|Möbel-ID: "+id);
        System.out.println("|Beschreibung: "+beschreibung);
        System.out.println("|Größe: "+groesse);
        System.out.println("+-----------------------------------------------");
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
}
