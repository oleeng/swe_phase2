import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Inserat implements InseratComposite{
    private String id;
    private String beschreibung;
    private Standort standort;
    private Rundgang rundgang;
    private ArrayList<Bild> bilder = new ArrayList<>();
    private HashMap<String, Double> eigenschaften = new HashMap<>();

    private String[] plichtEigenschaften = {"Preis"};

    public Inserat(String beschreibung, Standort standort, Double preis){
        this.beschreibung = beschreibung;
        this.standort = standort;
        this.id = HelperStuff.genId();

        eigenschaften.put("Preis", preis);
    }

    public void addRundgang(Rundgang rundgang){
        this.rundgang = rundgang;
    }

    public void addBild(Bild bild){
        this.bilder.add(bild);
    }

    public void addEigenschaft(String name, Double wert){
        eigenschaften.put(name, wert);
    }

    public void removeEigenschaft(String name){
        if(Arrays.asList(plichtEigenschaften).contains(name)){
            System.out.println("Du kannst die Eigenschaft "+name+" nicht löschen...");
        }else{
            eigenschaften.remove(name);
        }
    }

    public Double getEigenschaft(String name) {
        if(eigenschaften.get(name) == null){
            return null;
        }
        return eigenschaften.get(name);
    }

    public String getId() {
        return id;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public Standort getStandort() {
        return standort;
    }

    public void starteRundgang(){
        if(this.rundgang == null) {
            System.out.println("kein Rundgang verfügbar...");
        }else{
            this.rundgang.starteRundgang();
        }
    }

    public void printBilder(){
        if(bilder.isEmpty()){
            System.out.println("keine Bilder vorhanden....");
        }else{
            System.out.println("Das Inserat hat folgende Bilder:");
            for(Bild b: bilder){
                b.print();
                System.out.println("-----------");
            }
        }
    }

    public void printEigenschaften(){
        if(eigenschaften.isEmpty()){
            System.out.println("keine Eigenschaften vorhanden...");
        }else{
            System.out.println("Das Inserat hat folgende Eigenschaften:");
            for(String e: eigenschaften.keySet()){
                System.out.println("Name: "+e+", Wert: "+eigenschaften.get(e));
                System.out.println("-----------");
            }
        }
    }

    public void print(){
        print(0);
    }

    @Override
    public void print(int level) {
        System.out.println(HelperStuff.padding(" ", level)+"+-----------------------------------------------");
        System.out.println(HelperStuff.padding(" ", level)+"|"+"Inserat (id: "+id+")");
        System.out.println(HelperStuff.padding(" ", level)+"|"+"Beschreibung: "+beschreibung);
        System.out.println(HelperStuff.padding(" ", level)+"+-----------------------------------------------");
    }
}
