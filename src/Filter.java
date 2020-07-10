public class Filter {
    private String name;
    private String value;
    private String type;

    public Filter(String name, String value, String type){
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
