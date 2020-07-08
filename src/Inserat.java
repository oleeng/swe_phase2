import java.util.ArrayList;

public class Inserat {
    private String id;
    private String beschreibung;
    private Standort standort;
    private Rundgang rundgang;
    private ArrayList<Bild> bilder = new ArrayList<Bild>();
    private ArrayList<Eigenschaft> eigenschaften = new ArrayList<Eigenschaft>();

    public Inserat(String beschreibung, Standort standort){
        this.beschreibung = beschreibung;
        this.standort = standort;
        this.id = HelperStuff.genId();
    }

    public void addRundgang(Rundgang rundgang){
        this.rundgang = rundgang;
    }

    public void addBild(Bild bild){
        this.bilder.add(bild);
    }

    public void addEigenschaft(Eigenschaft eigenschaft){
        this.eigenschaften.add(eigenschaft);
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

    public void zeigeBilder(){
        if(bilder.isEmpty()){
            System.out.println("keine Bilder vorhanden....");
        }else{
            for(Bild b: bilder){
                b.zeigeBild();
                System.out.println("-----------");
            }
        }
    }

    public ArrayList<Eigenschaft> getEigenschaften() {
        if(eigenschaften.isEmpty()){
            return null;
        }else{
            return eigenschaften;
        }
    }

    public void printEigenschaften(){
        if(eigenschaften.isEmpty()){
            System.out.println("keine Eigenschaften vorhanden...");
        }else{
            for(Eigenschaft e: eigenschaften){
                e.print();
                System.out.println("-----------");
            }
        }
    }
}
