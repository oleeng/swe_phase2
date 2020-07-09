public class Bild {
    private String id;
    private String beschreibung;
    private String dateiformat;
    private int dateigroesse;

    public Bild(String beschreibung, String dateiformat, int dateigroesse){
        this.beschreibung = beschreibung;
        this.dateiformat = dateiformat;
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

    public int getDateigroesse() {
        return dateigroesse;
    }

    public void zeigeBild(){
        System.out.println("Id: "+id);
        System.out.println("Dateiformat: "+dateiformat);
        System.out.println("Dateigröße: "+dateigroesse);
        System.out.println("Beschreibung: "+beschreibung);
    }
}
