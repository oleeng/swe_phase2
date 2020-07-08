public class HelperStuff {
    static String genId(){
        String tmp = "";
        for(int i = 0; i < 64; i++){
            // r liegt zwischen 0 und 61 da 0<= Math.random<1
            int r = (int) Math.floor(Math.random() * 62);

            if(r<26){
                // A - Z
                r = r+65;
            }else if(r<52){
                // a - z
                r  = r+71;
            }else{
                // 0 - 9
                r = r-4;
            }

            tmp = tmp + (char)r;
        }

        return tmp;
    }
}
