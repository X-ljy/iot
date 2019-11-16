import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Reverse{

    public static void main(String[] args) {

        byte a = 0x00;
        byte b = (byte) 0xec;

        System.out.println(Integer.toHexString(a));
        System.out.println(Integer.toHexString(b));

        String aa="";
        String bb="";

        if(Integer.toHexString(a).length() == 1){
            aa =  "0" + Integer.toHexString(a);
        }

        if(Integer.toHexString(b).length() > 2){
            bb = Integer.toHexString(b).substring(6);
        }

        System.out.println(aa+bb);

        String temp_start = String.valueOf(Integer.parseInt(aa+bb,16));
        System.out.println(temp_start);

        byte b1 = (byte) 0xff;
        System.out.println(b1 == 0xff);

    }
}