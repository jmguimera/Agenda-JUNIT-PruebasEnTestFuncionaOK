package contacto;

import java.util.regex.Pattern;
/**
 * @author josem
 */
public class ExpReg {
    
    static String regexp[]={"([8][1-9])([0-9]){7}","([9][1-9])([0-9]){7}",
            "([6][1-9])([0-9]){7}","([7][1-9])([0-9])d{7}","([8][0])([0-9]){7}",
            "([9][0])([0-9]){7}","([1])([0-9]){3}","([1][1][8])([0-9]){2}"};
        //[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)*(\\.[\\w-]{2,})
    static String mail[]={"[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"};
        
    public ExpReg(){}
    
    public static boolean ok(String expresion,int opcion){
        boolean ok=false;

        switch (opcion){
            case 8:
                for(int i=0;i<regexp.length;i++){
                   ok=Pattern.matches(regexp[i],expresion);
                   System.out.println(ok);
                    if(ok){
                        break;
                    }
                 }
                break;
            case 9:
                for(int i=0;i<mail.length;i++){
                   ok=Pattern.matches(mail[i],expresion);
                   System.out.println(ok);
                    if(ok){
                        break;
                    }
                 }
                break;                
        }
    return ok;
    }
}
