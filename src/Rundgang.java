import java.util.ArrayList;
import java.util.Arrays;

public class Rundgang {
    private String id;
    private String audiokommentar;
    private String dimensionen;
    private ArrayList<Modellmoebel> moebel = new ArrayList<Modellmoebel>();

    public Rundgang(String audiokommentar, String dimensionen){
        this.audiokommentar = audiokommentar;
        this.dimensionen = dimensionen;
        this.id = Helper.genId();
    }

    public String getId() {
        return id;
    }

    public void playAudiokommentar(){
        System.out.println("Gebe den Audiokommentar wieder...");
        System.out.println(audiokommentar);
    }

    public String getDimensionen() {
        return dimensionen;
    }

    public void starteRundgang() {
        System.out.println("Starte Rundgang (id: "+id+")...");
    }

    public void addMoebel(Modellmoebel... moebelstueck){
        this.moebel.addAll(Arrays.asList(moebelstueck));
    }

    public void printAllMoebel(){
        System.out.println("In der Immobile befinden sich aktuell folgende Möbel.....");
        for (Modellmoebel m : moebel) {
            m.print();
        }
    }
}
