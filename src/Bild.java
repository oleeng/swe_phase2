public class Bild {
    /*
    Die Klasse Bild repräsentiert ein Bild.
    Ein Bild verfügt über eine id eine Beschreibung, ein Dateiformat, einen Path und eine Größe in Bytes
    */
    private String id;
    private String beschreibung;
    private String dateiformat;
    private String path;
    private int dateigroesse;

    public Bild(String beschreibung, String dateiformat, String path, int dateigroesse){
        this.beschreibung = beschreibung;
        this.dateiformat = dateiformat;
        this.path = path;
        this.dateigroesse = dateigroesse;
        this.id = HelperStuff.genId();
    }

    public String getId() {
        return this.id;
    }

    public String getBeschreibung() {
        return this.beschreibung;
    }

    public String getDateiformat() {
        return this.dateiformat;
    }

    public String getPath() {
        return this.path;
    }

    public int getDateigroesse() {
        return this.dateigroesse;
    }

    public void print(){
        System.out.println("Id: "+this.id);
        System.out.println("Dateiformat: "+this.dateiformat);
        System.out.println("Path: "+this.path);
        System.out.println("Dateigröße: "+this.dateigroesse+" Byte");
        System.out.println("Beschreibung: "+this.beschreibung);
    }

    public void anzeigen(){
        System.out.println("Hier wird das Bild angezeigt");
        HelperStuff.printImage(this.path);
    }
}
