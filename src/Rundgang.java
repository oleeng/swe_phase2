import java.util.ArrayList;

public class Rundgang {
    private String id;
    private String audiokommentar;
    private String dimensionen;
    private String datenRundgang;
    private ArrayList<Modellmoebel> moebel = new ArrayList<Modellmoebel>();

    public Rundgang(String audiokommentar, String dimensionen, String datenRundgang){
        this.audiokommentar = audiokommentar;
        this.dimensionen = dimensionen;
        this.datenRundgang = datenRundgang;
        this.id = HelperStuff.genId();
    }

    public String getId() {
        return id;
    }

    public void playAudiokommentar(){
        System.out.println(audiokommentar);
    }

    public String getDimensionen() {
        return dimensionen;
    }

    public void starteRundgang() {
        System.out.println("Starte Rundgang....");
        System.out.println(datenRundgang);
    }

    public void addMoebel(Modellmoebel moebelstueck){
        this.moebel.add(moebelstueck);
    }

    public void printAllMoebel(){
        System.out.println("In der Immobile befinden sich aktuell folgende Möbel.....");
        for (Modellmoebel m : moebel) {
            m.print();
            System.out.println("-----------------");
        }
    }
}
