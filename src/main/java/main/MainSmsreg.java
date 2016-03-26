package main;

import com.smsreg.Smsreg;

/**
 * Created by sh on 3/20/2016.
 */
public class MainSmsreg {
    public static void main(String[] args) {
        Smsreg smsreg = new Smsreg();
        smsreg.load();
        smsreg.setServise();
        //smsreg.setCountry();
        smsreg.getPhoneNumber();
    }
}
