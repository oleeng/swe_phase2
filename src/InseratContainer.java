import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class InseratContainer implements InseratComposite {
    private String name;
    private ArrayList<InseratComposite> inserateComposite = new ArrayList<>();

    private HashMap<String, String> erlaubteFilter = new HashMap<>();

    public InseratContainer(String name){
        this.name = name;
        erlaubteFilter = Inserat.getErlaubteEigenschaften();
    }

    public void add(InseratComposite... inserate){
        this.inserateComposite.addAll(Arrays.asList(inserate));
    }

    public void add(ArrayList<Inserat> inserate){
        this.inserateComposite.addAll(inserate);
    }

    public boolean remove(InseratComposite inserat){
        boolean found = false;
        if(!inserateComposite.remove(inserat)){
            // inserat kannte in der Liste nicht gefunden werden
            for(InseratComposite i: inserateComposite){
                if(i instanceof InseratContainer){
                    if(((InseratContainer) i).remove(inserat)){
                        found = true;
                        break;
                    }
                }
            }
        }else{
            // inserat konnte gelöscht werden
            found = true;
        }
        return found;
    }

    @Override
    public void print(){
        print(0);
    }

    @Override
    public void print(Integer level) {
        for (InseratComposite inserat: inserateComposite){
            if(inserat instanceof InseratContainer){
                System.out.println(Helper.padding("-", level)+"Inseratcontainer: "+((InseratContainer) inserat).name);
            }
            inserat.print(level+1);
        }
    }

    public InseratContainer suche(Filter... filter){
        //InseratContainer ergebnisse = new InseratContainer("Suchergebnisse");
        ArrayList<Inserat> ergebnisse = sucheIntern(filter);
        if(ergebnisse == null){
            return null;
        }else{
            InseratContainer tmp = new InseratContainer("Suchergebnisse");
            tmp.add(ergebnisse);
            return tmp;
        }
    }

    private ArrayList<Inserat> sucheIntern(Filter... filter){
        ArrayList<Inserat> ergebnisse = new ArrayList<>();

        for (InseratComposite inserat: inserateComposite){
            if( inserat instanceof InseratContainer){
                // inserat ist kein Inserat sondern ein Container
                ArrayList<Inserat> tmp = ((InseratContainer) inserat).sucheIntern(filter);
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
                    if(erlaubteFilter.get(f.getName()) != null){
                        if(erlaubteFilter.get(f.getName()).equals(f.getType())){
                            if(f.getType().equals("String")){
                                status = stringFilter(i.getEigenschaft(f.getName()), f);
                            }else{
                                status = zahlFilter(Double.parseDouble(i.getEigenschaft(f.getName())), f);
                            }
                        }else{
                            System.out.println("Invalid Filtertyp: "+f.getType());
                            status = -1;
                        }
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
            if(f.getMethod().equals("min")){
                if(a < Double.parseDouble(f.getValue())){
                    return 0;
                }
            }else if(f.getMethod().equals("max")){
                if(a > Double.parseDouble(f.getValue())){
                    return 0;
                }
            }else{
                System.out.println("Invalid Filtermethod: "+f.getType());
                return -1;
            }
        }
        return 1;
    }

    @Override
    public Double getPreis() {
        Double gesamtpreis = 0.0;
        for(InseratComposite i: inserateComposite){
            gesamtpreis += i.getPreis();
        }
        return gesamtpreis;
    }
}
