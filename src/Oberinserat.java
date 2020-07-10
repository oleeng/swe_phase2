import java.util.ArrayList;
import java.util.Arrays;

public class Oberinserat implements InseratComposite {
    private String name;
    private ArrayList<InseratComposite> inserateComposite = new ArrayList<InseratComposite>();

    private String[] stringFilterValues = {"Stadt"};
    private String[] zahlFilterValues = {"Größe", "Zimmerzahl"};

    public Oberinserat(String name){
        this.name = name;
    }

    public void add(InseratComposite inserat){
        this.inserateComposite.add(inserat);
    }

    public void print(){
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
        ArrayList<Inserat> ergebnisse = new ArrayList<>();

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
                int status;

                for (Filter f: filter){
                    if(Arrays.asList(stringFilterValues).contains(f.getName())){
                        status = stringFilter(i.getStandort().getStadt(), f);
                    }else if(Arrays.asList(zahlFilterValues).contains(f.getName())){
                        status = zahlFilter(i.getEigenschaft(f.getName()), f);
                    }else{
                        System.out.println("Invalid Filtername: "+f.getName());
                        status = -1;
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