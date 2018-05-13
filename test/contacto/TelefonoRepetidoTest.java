package contacto;

import java.util.ArrayList;import java.util.List;import org.junit.Test;
import static org.junit.Assert.*;import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;import org.junit.runners.Parameterized.Parameters;
/** * @author josem  */
@RunWith(value = Parameterized.class)
public class TelefonoRepetidoTest {
    private List<String> telf; 
    private String telefo;

    @Parameters
    public static Iterable<Object[]> getData(){

        List<Object[]> obj = new ArrayList<>();
        obj.add(new Object[]{"1234"});    
        obj.add(new Object[]{"922667788"});    
        obj.add(new Object[]{"928223344"});
        obj.add(new Object[]{"910112233"});
        obj.add(new Object[]{"936454545"});    
    
        return obj;
     }

    public TelefonoRepetidoTest(String telefo) {
        this.telf = new ArrayList<String>(); 
        this.telf.add("1234");telf.add("922667788");telf.add("928223344");
     
        this.telefo=telefo;
    }

    @Test
    public void telefonoRepetido(){
        // se espera true que el numero no está repetido
        boolean esperado=true; 
       
        int i=(telf).indexOf(telefo); // busca si existe telefo en telf 
        
        // si i es menor que 0 devuelve -1
        boolean resultado=(i<0);// si i=-1, resultado sera = true 
       
        assertEquals(esperado,resultado);
       
        }       
}