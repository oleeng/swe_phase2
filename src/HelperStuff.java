import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class HelperStuff {
    static String genId(){
        // erzeuge einen zufälligen 64 Zeichen langen ID-String
        String tmp = "";
        for(int i = 0; i < 64; i++){
            // r liegt zwischen 0 und 61 da 0<= Math.random<1
            int r = (int) Math.floor(Math.random() * 62);

            if(r<26){
                // A - Z
                r += 65;
            }
            else if(r<52){
                // a - z
                r += 71;
            }else{
                // 0 - 9
                r -= 4;
            }
            tmp += (char)r;
        }
        return tmp;
    }

    static String padding(String string, int count){
        return string.repeat(count);
    }

    static void printFile(String path){
        try{
            Scanner input = new Scanner(new File(path));
            while (input.hasNextLine())
            {
                System.out.println(input.nextLine());
            }
        }catch (FileNotFoundException e){
            System.out.println("the file "+path+" doesn't exist");
        }
    }

    static void printImage(String path){
        String pathURL = "";
        try {
            pathURL = Paths.get("").toAbsolutePath().toString()+"\\"+path;
            BufferedImage img = ImageIO.read(new File(pathURL));

            int width = img.getWidth();
            int steps;

            if(width <= 80){
                steps = 1;
            }else{
                steps = width/80;
            }

            for (int i = 0; i < img.getHeight(); i=i+steps) {
                for (int j = 0; j < img.getWidth(); j=j+steps) {
                    Color pixcol = new Color(img.getRGB(j, i));
                    double pixval = (((pixcol.getRed() * 0.30) + (pixcol.getBlue() * 0.59) + (pixcol.getGreen() * 0.11)));
                    System.out.print(strChar(pixval));
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Die Datei "+pathURL+" konnte nicht geladen werden....");
        }
    }

    private static String strChar(double g) {
        String str = " ";
        if (g >= 240) {
            str = " ";
        } else if (g >= 210) {
            str = ".";
        } else if (g >= 190) {
            str = "*";
        } else if (g >= 170) {
            str = "+";
        } else if (g >= 120) {
            str = "^";
        } else if (g >= 110) {
            str = "&";
        } else if (g >= 80) {
            str = "8";
        } else if (g >= 60) {
            str = "#";
        } else {
            str = "@";
        }
        return str;
    }
}
