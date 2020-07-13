import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Inserat implements InseratComposite{
    private String id;
    private String beschreibung;
    private Standort standort;
    private Rundgang rundgang;
    private ArrayList<Bild> bilder = new ArrayList<>();
    private HashMap<String, String> eigenschaften = new HashMap<>();

    private static HashMap<String, EigenschaftObj> erlaubteEigenschaften = new HashMap<>();
    static {
        erlaubteEigenschaften.put("Land", new EigenschaftObj(false, true, "String"));
        erlaubteEigenschaften.put("Bundesland", new EigenschaftObj(false, true, "String"));
        erlaubteEigenschaften.put("PLZ", new EigenschaftObj(false, true, "String"));
        erlaubteEigenschaften.put("Stadt", new EigenschaftObj(false, true, "String"));
        erlaubteEigenschaften.put("Straße", new EigenschaftObj(false, true, "String"));
        erlaubteEigenschaften.put("Preis", new EigenschaftObj(true, true, "Double"));
        erlaubteEigenschaften.put("Größe", new EigenschaftObj(true, false, "Double"));
        erlaubteEigenschaften.put("Zimmerzahl", new EigenschaftObj(true, false, "Double"));
    }

    private static class EigenschaftObj{
        private boolean veraenderlich;
        private boolean pflich;
        private String type;

        public EigenschaftObj(boolean veraenderlich, boolean pflicht, String type){
            this.veraenderlich = veraenderlich;
            this.pflich = pflicht;
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public boolean isVeraenderlich() {
            return veraenderlich;
        }

        public boolean isPflich() {
            return pflich;
        }
    }

    static HashMap<String,String> getErlaubteEigenschaften(){
        HashMap<String,String> tmp = new HashMap<>();
        for(String e: erlaubteEigenschaften.keySet()){
            tmp.put(e, erlaubteEigenschaften.get(e).getType());
        }
        return tmp;
    }

    public Inserat(String beschreibung, Standort standort, Double preis){
        this.beschreibung = beschreibung;
        this.standort = standort;
        this.rundgang = null;
        this.id = HelperStuff.genId();

        eigenschaften.put("Preis", String.valueOf(preis));
        eigenschaften.put("Land", standort.getLand());
        eigenschaften.put("Bundesland", standort.getBundesland());
        eigenschaften.put("PLZ", standort.getPLZ());
        eigenschaften.put("Stadt", standort.getStadt());
        eigenschaften.put("Straße", standort.getStrasse());
    }

    public void add(Rundgang rundgang){
        this.rundgang = rundgang;
    }

    public void removeRundgang(){
        this.rundgang = null;
    }

    public void add(Bild... bilder){
        this.bilder.addAll(Arrays.asList(bilder));
    }

    public void remove(Bild... bilder){
        this.bilder.removeAll(Arrays.asList(bilder));
    }

    public void add(Eigenschaft... eigenschaften){
        for(Eigenschaft e: eigenschaften){
            EigenschaftObj tmp = this.erlaubteEigenschaften.get(e.getName());
            if(tmp != null){
                if(tmp.getType().equals(e.getType()) && tmp.isVeraenderlich()){
                    this.eigenschaften.put(e.getName(), e.getValue());
                }else{
                    System.out.println("Die Eigenschaft "+e.getName()+" ist nicht veränderlich...");
                }
            }else{
                System.out.println("Die Eigenschaft "+e.getName()+" ist nicht erlaubt...");
            }
        }
    }

    public void remove(String... names){
        for (String s:names){
            EigenschaftObj tmp = this.erlaubteEigenschaften.get(s);
            if(tmp != null){
                if(tmp.isPflich()){
                    System.out.println("Du kannst die Eigenschaft "+s+" nicht löschen...");
                }else{
                    eigenschaften.remove(s);
                }
            }
        }
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
            }
        }
    }

    public void zeigeBilder(){
        if(bilder.isEmpty()){
            System.out.println("keine Bilder vorhanden....");
        }else{
            System.out.println("Das Inserat hat folgende Bilder:");
            for(Bild b: bilder){
                b.anzeigen();
            }
        }
    }

    public String getEigenschaft(String name) {
        return eigenschaften.get(name);
    }

    public void printEigenschaften(){
        if(eigenschaften.isEmpty()){
            System.out.println("keine Eigenschaften vorhanden...");
        }else{
            System.out.println("Das Inserat hat folgende Eigenschaften:");
            for(String e: eigenschaften.keySet()){
                System.out.println("Name: "+e+", Wert: "+eigenschaften.get(e));
            }
        }
    }

    @Override
    public void print(){
        print(0);
    }

    @Override
    public void print(int level) {
        String padding = HelperStuff.padding(" ", level);
        System.out.println(padding+"+-----------------------------------------------");
        System.out.println(padding+"|"+"Inserat (id: "+id+")");
        System.out.println(padding+"|"+"Beschreibung: "+beschreibung);
        System.out.println(padding+"+-----------------------------------------------");
    }

    @Override
    public Double getPreis() {
        return Double.parseDouble(eigenschaften.get("Preis"));
    }
}
