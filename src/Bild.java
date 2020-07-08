public class Bild {
    private String id;
    private String beschreibung;
    private String datenBild;

    public Bild(String beschreibung, String datenBild){
        this.beschreibung = beschreibung;
        this.datenBild = datenBild;
        this.id = HelperStuff.genId();
    }

    public String getId() {
        return id;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public String getDatenBild() {
        return datenBild;
    }
}
