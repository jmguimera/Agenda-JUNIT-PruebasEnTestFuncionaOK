/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contacto;

import static contacto.Agenda.leer_cadena;
import static contacto.Agenda.out;
import static contacto.Agenda.ruta;
import static contacto.Agenda.teclado;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
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
public class AgendaTest {
    Contacto contacto;
    List<Contacto> vector;
    Contacto contacto1;
    List<String>telf;
    public static Scanner teclado = new Scanner(System.in);    
    
    public AgendaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
     
       vector = new ArrayList<Contacto>();
        
        int i, n;

        int[] contador = {0};

        int opcion = 0, subopcion;

        String[] campos;
//        List<String> telf = new ArrayList<String>();
        telf = new ArrayList<String>(); 
        telf.add("1234");telf.add("922667788");telf.add("928223344");
        List<String> mail = new ArrayList<String>();

        try {

            Scanner entrada = new Scanner(new FileReader(ruta));
            

            while (entrada.hasNextLine()) {

                campos = entrada.nextLine().split("\t");

                contacto1 = new Contacto();

                contacto1.setAlias(campos[0]);

                vector.add(contacto1); 

            }

            entrada.close(); // cierra el archivo fisico donde estna los contactos

        } catch (FileNotFoundException e) {
                out.println("** No existe el archivo **!!!");
        }
        
    }
    

@Test
public void yaExiste(){
/*** Esta fraccion de codigo está en Agenda principal y quiero testear ***/ 
/*       
                contacto.setAlias(leer_cadena ("Ingrese el nombre del contacto",1));

                  // busca el nombre en el vector y devuelve su posición
                i = vector.indexOf(contacto);

                // si la posicion < 0 significa que no existe
                // de lo contrario toma el valor objeto de la posicion indica por i
                // y lo asigna a dato
                dato = i<0 ? null : vector.get(i);

                if (dato!=null) { // dato no es nulo y procede a imprimir datos
                                  // del contacto  
                    out.println();// salto de linea. no imprime nada
                    
                      // imprime los datos del contacto contenidos en dato
                    imprimir.funcion(dato, contador);

                }   */

    /*            if (opcion==1 && dato!=null)

                out.println("El registro ya existe.");

            else if (opcion>=2 && opcion<=4 && dato==null)

                out.println("\nRegistro no encontrado.");

            else switch (opcion) { .......}      */
            Contacto dato=null;
            contacto=new Contacto();
            
            contacto.setAlias(JOptionPane.showInputDialog(null,
                    "Escriba el nombre del contacto",
                    "Testeado de busqueda de clientes", 1));

               // busca el nombre en el vector y devuelve su posición
               int i = vector.indexOf(contacto);

                // si la posicion es < 0 significa que no existe y asigna null
                // de lo contrario toma el objeto de la posicion i

                boolean ok = i<0 ? true : false;
                
                dato = i<0 ? null : vector.get(i);

                if (dato!=null) { // dato no es nulo y procede a imprimir 
                            out.println();// salto de linea. 
                            // imprime los datos del contacto contenidos en dato
                            out.println("Contacto: "+dato+" ya existe!!");
                 }else{
                        out.println("Este contacto es nuevo");
                  }
            assertTrue(ok); 
    }
    
/*    @Test
    public void telefonoRepetido(){
    
    //    String telefono="922667788";
    //    String telefono="928223344";        
    //    String telefono="1234";
        String telefono="910112233";

        // si es true el numero no está repetido
        boolean esperado=true; 
       
        int i=(telf).indexOf(telefono);
       
        boolean resultado=(i<0);
        
        assertEquals(esperado,resultado);
        

        }    */
 
}
