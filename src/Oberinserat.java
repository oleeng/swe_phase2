import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Oberinserat implements InseratComposite {
    private String name;
    private ArrayList<InseratComposite> inserateComposite = new ArrayList<InseratComposite>();

    public Oberinserat(String name){
        this.name = name;
    }

    public void addInserat(InseratComposite inserat){
        this.inserateComposite.add(inserat);
    }

    public void printAll(){
        print(0);
    }

    @Override
    public void print(int level) {
        for (InseratComposite inserat: inserateComposite){
            if(inserat instanceof Oberinserat){
                System.out.println("-".repeat(level)+"Inseratcontainer: "+((Oberinserat) inserat).name);
            }
            inserat.print(level+1);
        }
    }

    public ArrayList<Inserat> suche(Filter... filter){
        ArrayList<Inserat> ergebnisse = new ArrayList<Inserat>();

        for (InseratComposite inserat: inserateComposite){
            if( inserat instanceof Oberinserat){
                // inserat ist kein Inserat sondern ein Container
                ArrayList<Inserat> tmp = ((Oberinserat) inserat).suche(filter);
                if(tmp == null){
                    return null;
                }
                ergebnisse.addAll(tmp);
            }else{
                // inserat ist ein einzelnes Inserat
                Inserat i = (Inserat) inserat;
                boolean erfuelltFilter = true;
                boolean error = false;
                int status = 99;

                for (Filter f: filter){
                    switch (f.getName()){
                        case "Stadt":
                            status = stringFilter(i.getStandort().getStadt(), f);
                            break;
                        case "Größe":
                            status = zahlFilter(i.getEigenschaft("Größe"), f);
                            break;
                        case "Zimmerzahl":
                            status = zahlFilter(i.getEigenschaft("Zimmerzahl"), f);
                            break;
                        default:
                            System.out.println("Invalid Filtername: "+f.getName());
                            status = -1;
                            break;
                    }
                    if(status == 0){
                        erfuelltFilter = false;
                        break;
                    }else if(status == -1){
                        return null;
                    }
                }

                if(erfuelltFilter){
                    ergebnisse.add((Inserat) inserat);
                }
            }
        }
        return ergebnisse;
    }

    private int stringFilter(String a, Filter f){
        if(a.equals(f.getValue())){
            return 1;
        }
        return 0;
    }

    private int zahlFilter(Double a, Filter f){
        if(a == null){
            return 0;
        }else{
            try{
                if(f.getType().equals("min")){
                    if(a < Integer.parseInt(f.getValue())){
                        return 0;
                    }
                }else if(f.getType().equals("max")){
                    if(a > Integer.parseInt(f.getValue())){
                        return 0;
                    }
                }else{
                    System.out.println("Invalid Filtertype: "+f.getType());
                    return -1;
                }
            }catch (NumberFormatException e) {
                System.out.println("Invalid Filterwert: " + f.getValue());
                return -1;
            }
        }
        return 1;
    }
}
