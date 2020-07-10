public class Bild {
    private String id;
    private String beschreibung;
    private String dateiformat;
    private String path;
    // groesse in bytes
    private int dateigroesse;

    public Bild(String beschreibung, String dateiformat, String path, int dateigroesse){
        this.beschreibung = beschreibung;
        this.dateiformat = dateiformat;
        this.path = path;
        this.dateigroesse = dateigroesse;
        this.id = HelperStuff.genId();
    }

    public String getId() {
        return id;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public String getDateiformat() {
        return dateiformat;
    }

    public String getPath() {
        return path;
    }

    public int getDateigroesse() {
        return dateigroesse;
    }

    public void print(){
        System.out.println("Id: "+id);
        System.out.println("Dateiformat: "+dateiformat);
        System.out.println("Dateigröße: "+dateigroesse+" Byte");
        System.out.println("Beschreibung: "+beschreibung);
    }
}
