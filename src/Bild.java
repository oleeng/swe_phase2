import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Bild {
    /*
    Die Klasse Bild repräsentiert ein Bild.
    Ein Bild verfügt über eine id, eine Beschreibung, ein Dateiformat, einen Path und eine Größe in Bytes
    */
    private String id;
    private String beschreibung;
    private String dateiformat;
    private String path;
    private Integer dateigroesse;
    private String[] validFileTypes = {"png", "jpg"};

    public Bild(String beschreibung, String path) throws FileNotFoundException {
        File f = new File("src\\"+path);
        if(!f.exists() || !f.isFile()){
            throw new FileNotFoundException("Die Datei "+path+" existiert nicht!");
        }
        this.dateiformat = path.substring(path.lastIndexOf(".")+1).toLowerCase();
        if(!Arrays.asList(validFileTypes).contains(dateiformat)){
            throw new FileNotFoundException("Der Dateityp ."+dateiformat+" ist nicht erlaubt! Nur "+Arrays.toString(validFileTypes)+" sind gültige Dateitypen.");
        }
        this.dateigroesse = (int)f.length();
        this.beschreibung = beschreibung;
        this.path = f.getAbsolutePath();
        this.id = Helper.genId();
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

    public Integer getDateigroesse() {
        return this.dateigroesse;
    }

    public void print(){
        System.out.println("+------------------------------");
        System.out.println("|Id: "+this.id);
        System.out.println("|Dateiformat: "+this.dateiformat);
        System.out.println("|Path: "+this.path);
        System.out.println("|Dateigröße: "+this.dateigroesse+" Byte");
        System.out.println("|Beschreibung: "+this.beschreibung);
        System.out.println("+------------------------------");
    }

    public void anzeigen(){
        Helper.printImage(this.path);
    }
}
