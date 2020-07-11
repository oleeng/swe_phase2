public class Eigenschaft {
    private String name;
    private Double value;

    public Eigenschaft(String name, Double value){
        this.name = name;
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
