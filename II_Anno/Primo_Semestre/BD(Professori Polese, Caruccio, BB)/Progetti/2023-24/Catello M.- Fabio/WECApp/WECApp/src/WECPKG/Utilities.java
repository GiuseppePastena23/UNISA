package WECPKG;

import javax.swing.*;

public class Utilities {

    public static void error_message(Exception er){
        JOptionPane.showMessageDialog(null, "Errore: "+ er.getMessage(), er.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
    }

    public static void info_message(String text){
        JOptionPane.showMessageDialog(null, text, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void warn_message(String text){
        JOptionPane.showMessageDialog(null,text,"Warning", JOptionPane.WARNING_MESSAGE);
    }
    public static int tryIntParse(String s){
        try{
            return Integer.parseInt(s);
        } catch (Exception e) { /*error_message(e);*/ return 0;}
    }

    public static String tryCastToString(Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof String) {
            return (String) obj;
        } else {
            return null;
        }
    }

}
