package contacto;

import static contacto.Agenda.out;
import static contacto.Agenda.ruta;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;import java.util.List;import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;import org.junit.runners.Parameterized.Parameters;
/** * @author josem  */
@RunWith(value = Parameterized.class)
public class CorreoRepetidoTest {
    private List<String> mail; 
    private String correo;
//    List<Contacto> vector;    

    @Parameters
    public static Iterable<Object[]> getData(){

        List<Object[]> obj = new ArrayList<>();
        obj.add(new Object[]{"primero@primero.com"});    
        obj.add(new Object[]{"segundo@segundo.com"});    
        obj.add(new Object[]{"tercero@tercero.com"});
        obj.add(new Object[]{"cuarto@cuarto.com"});
        obj.add(new Object[]{"quinto@quinto.com"});
        obj.add(new Object[]{"sexto@sexto.com"});

    
        return obj;
     }

    public CorreoRepetidoTest(String correo) {
        mail = new ArrayList<String>(); 
        mail.add("quinto@quinto.es");mail.add("cuarto@cuarto.com");
        mail.add("tercero@tercero.com");mail.add("primero@primero.com");
     
        this.correo=correo;
    }
 
    @Test
    public void CorreoRepetido(){
        // se espera true que el numero no está repetido
        boolean esperado=true; 
       
        int i=(mail).indexOf(correo); // busca si existe telefo en telf 
        
        // si i es menor que 0 devuelve -1
        boolean resultado=(i<0);// si i=-1, resultado sera = true 
       
        assertEquals(esperado,resultado);
       
        }       
}
