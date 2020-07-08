public class Eigenschaft {
    private String key;
    private String value;

    public Eigenschaft(String name, String wert){
        this.key = name;
        this.value = wert;
    }

    public String getName() {
        return key;
    }

    public String getWert() {
        return value;
    }
}
