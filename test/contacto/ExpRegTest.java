/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contacto;

import static contacto.ExpReg.regexp;
import static contacto.ExpReg.mail;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author josem
 */
public class ExpRegTest {
    
    public ExpRegTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ok method, of class ExpReg.
     */
    @Test
    public void testOk() {

        boolean ok=false;

        // String expresion = "522677980"; con este debe fallar
        // String expresion = "922546789"; // con este debe pasar
        // String expresion = "118779"; //debe fallar
        // String expresion = "11869"; // debe pasar
        // String expresion = "2925"; // debe fallar
         String expresion = "1922"; //debe pasar
        
        int opcion = 8; // este valor se pasa cuando se va a verificar telefonos
        boolean result=false; // valor que arrojará la evaluación         
        
        for (int i=0;i<regexp.length;i++){

                   ok=Pattern.matches(regexp[i],expresion);
                   System.out.println(ok);
                    if(ok){
                        result=ok;
                        break;
                    }
        }
        boolean expResult = true; // valor esperado

        assertEquals(expResult, result);
 }
            
}
    

