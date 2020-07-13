import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Standort {
    private String land;
    private String bundesland;
    private String stadt;
    private String plz;
    private String strasse;

    public Standort(String land, String bundesland, String stadt, String plz, String strasse){
        this.land = land;
        this.bundesland = bundesland;
        this.stadt = stadt;
        this.plz = plz;
        this.strasse = strasse;
    }

    public String getLand() {
        return land;
    }

    public String getBundesland() {
        return bundesland;
    }

    public String getStadt() {
        return stadt;
    }

    public String getPLZ() {
        return plz;
    }

    public String getStrasse() {
        return strasse;
    }

    public void printKarte(){
        URL url = null;
        try {
            String tmp = "https://image.maps.ls.hereapi.com/mia/1.6/mapview?apiKey=4t-sIBgXFePm5Azm8eAj1GxpbfvTMyRsnicw61CI1W8&co="+URLEncoder.encode(land, StandardCharsets.UTF_8)+"&ci="+URLEncoder.encode(stadt, StandardCharsets.UTF_8)+"&f=0&h=120&i=0&s="+URLEncoder.encode(strasse, StandardCharsets.UTF_8)+"&nocp=1&poithm=1&w=240&z=14&zi="+URLEncoder.encode(plz, StandardCharsets.UTF_8)+"&style=dreamworks";
            url = new URL(tmp);
            BufferedImage img = ImageIO.read(url);

            String[] str = {"#5A3194", "#CE5AE6", "#FF943A", "#FF523A", "#6B5AE6", "#000000"};

            for (int i = 0; i < img.getHeight(); i=i+3) {
                for (int j = 0; j < img.getWidth(); j=j+3) {
                    boolean s = false;
                    boolean marker = false;
                    for(int k = 0; k < 3; k++){
                        for(int m = 0; m < 3; m++){
                            Color pixcol = new Color(img.getRGB(j+k, i+m));
                            String c = "#"+Integer.toHexString(pixcol.getRGB()).substring(2).toUpperCase();
                            if(Arrays.asList(str).contains(c)){
                                s = true;
                            }else if(c.equals("#31AD42") || c.equals("#FFFFFF")){
                                marker = true;
                            }
                        }
                    }
                    if(s){
                        System.out.print("*");
                    }else if(marker){
                        System.out.print("#");
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL Format..."+url);
        } catch (IOException e) {
            System.out.println("Can't read file..."+url);
        }
    }
}
