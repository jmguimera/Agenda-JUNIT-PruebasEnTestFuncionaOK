package contacto;

import static contacto.ExpReg.regexp;
import java.io.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

 

public class Agenda implements Serializable{

    public static Scanner teclado = new Scanner(System.in);

    public static PrintStream out = System.out;
    
    public static String fichero="contactosOK";
    
    public static ObjectOutputStream oos;

    public static void pausar(String mensage) {

        out.print(mensage + "\nPresione <ENTER> para continuar . . . ");

        teclado.nextLine();

        out.println();

    }
    
    public static boolean otroMas(String mensage) {

        boolean ok=true;
        String sino="";
        
            while(true) {
                
                try{
                   sino=JOptionPane.showInputDialog(null, mensage,"  * Escriba S para Si, N para No *",1).toUpperCase();
                   if(sino.equals(null)) sino="N";
                }catch(NullPointerException Ex){
                   sino="N";
                    }
                if(sino.equalsIgnoreCase("S")||sino.equalsIgnoreCase("N")){
                    
                      if(sino.equalsIgnoreCase("N")){ 
                          ok=false;
                      }
                      
                    break;
                 }
             }
        
        return ok;
    }    

    
    public static String leer_cadena(String mensaje, int opcion) {
        out.print(mensaje + ": ");
        return teclado.nextLine();
    }
    
    public static int leer_entero(String mensaje) {

        try {

            return Integer.parseInt(leer_cadena(mensaje,0));

        } catch (NumberFormatException e) {

            out.print("Escribe una opción entre 1 y 7.");

            return leer_entero(mensaje);

        }

    }

   public static String ruta = "contactos.tsv";

    public static void main(String[] args) {

        Funcion<Contacto> imprimir = new Funcion<Contacto>() {

            @Override

            public void funcion(Contacto contacto, Object parametros) {

                out.println(contacto);

                int[] contador = (int[]) parametros;

                contador[0]++;

            }

        };

        Funcion<Contacto> imprimirEnArchivo = new Funcion<Contacto>() {

            @Override

            public void funcion(Contacto contacto, Object parametros) {

                PrintStream archivo = (PrintStream) parametros;

                archivo.print(contacto.getAlias() + "\t");

                archivo.print(contacto.getTelefono() + "\t");

                archivo.print(contacto.getCorreo() + "\n");

            }

        };

        // vamos a incluir en vector todos los contactos que están en el archivo
        // y sus campos de datos

        List<Contacto> vector = new ArrayList<Contacto>();

        int i, n;

        Contacto dato = null, contacto;

        int[] contador = {0};

        int opcion = 0, subopcion;

        String[] campos;
        List<String> telf = new ArrayList<String>();
        List<String> mail = new ArrayList<String>();
        List<String> telftmp = new ArrayList<String>();
        List<String> mailtmp = new ArrayList<String>();
        try {

            Scanner entrada = new Scanner(new FileReader(ruta));
            

            while (entrada.hasNextLine()) {

                campos = entrada.nextLine().split("\t");

                contacto = new Contacto();
               
                contacto.setAlias(campos[0]);

                  telftmp.add(campos[1]);

                contacto.setTelefonos(telftmp);

                mailtmp.add(campos[2]);
                contacto.setCorreo(mailtmp);

                telftmp.clear();;
                mailtmp.clear();

                vector.add(contacto);

            }

            entrada.close(); // cierra el archivo fisico donde estan los contactos

        } catch (FileNotFoundException e) {
                out.println("** No existe el archivo **!!!");
        }
 
        contacto = new Contacto();

        do {

            out.println("MENU");

            out.println("1.- Altas");

            out.println("2.- Consultas");

            out.println("3.- Modificacion");

            out.println("4.- Bajas");

            out.println("5.- Ordenar registros");

            out.println("6.- Listar registros");

            out.println("7.- Salir");

            do {

                opcion = leer_entero ("Seleccione una opcion");

                if(opcion<1 || opcion>7){

                    out.println("Opcion no valida.");
                }

            } while (opcion<1 || opcion>7);
   

            out.println();

            if (vector.isEmpty() && opcion!=1 && opcion!=7) {

                pausar("No hay registros.\n");

                continue;

            }

            if (opcion<5) {

                contacto.setAlias(leer_cadena ("Ingrese el nombre del contacto",1));

                  // busca el nombre en el vector y devuelve su posición
                i = vector.indexOf(contacto);

                // si la posicion < 0 significa que no existe
                // de lo contrario toma el valor objeto de la posicion indica por i
                // y lo asigna a dato
                dato = i<0 ? null : vector.get(i);

                if (dato!=null) { // dato no es nulo y procede a imprimir 

                    out.println();// salto de linea. no imprime nada
                    
                      // imprime los datos del contacto contenidos en dato
                    imprimir.funcion(dato, contador);

                }

            }
 
            if (opcion==1 && dato!=null)

                out.println("El registro ya existe.");

            else if (opcion>=2 && opcion<=4 && dato==null)

                out.println("Registro no encontrado.");

            else switch (opcion) {
     //**** Aqui ingresamos los numeros de telefonos y correos la primera vez             
            case 1:
                //Arreglos contendran el Nro telefonos q se agreguen al contacto
                //y tambine los corroes
               // telf = new ArrayList<String>();
               // mail = new ArrayList<String>();
                boolean t=true;
                String cadena="";
                    while(t){
 
                        cadena=leer_cadena("Ingrese número de teléfono: ",8);
                        
                        boolean letras=(Pattern.matches("[a-zA-Z&ñÑ%$@#!,;.*-/|<>_:?¿=]+",cadena));

                        // 8 para que valide telefonos
                        if(ExpReg.ok(cadena,8) && !letras) {
                            
                            if(!telefonoRepetido(telf,cadena)){
                            
                                telf.add(cadena);  
                                if(!otroMas("Desea incluir otro telefono? ")){
                                    break;
                                 }    

                            }else{
                            
                            out.println("Número de telefono repetido o formato no valido!!!");
                                
                            }

                          }else{
                                    out.println("Formato no valido del numero, ni letras estan permitidos");
                                   }
                             if(cadena.isEmpty()){
                                if(otroMas("Desea terminar y no incluir mas telefonos? ")){
                                      break;
                                 }                
                             }
                     }
                                
                    contacto.setTelefonos(telf);

                    out.println("telf: "+telf);
                    t=true;
                    while(t){
                 
                        cadena=leer_cadena("Ingrese correo electrónico: ",9);
                        // 9 para que valide correos
                        if(ExpReg.ok(cadena,9)) {mail.add(cadena);}
                        
                            if(!otroMas("Desea incluir otro correo? ")){
                                break; 
                            }
                     }                

                    contacto.setCorreo(mail);
                    
                    vector.add(contacto); 
                
                    out.println("\nRegistro agregado correctamente!!");
                    for(int j=0; j< vector.size(); j++) {
                      System.out.println(vector.get(j));
                     }
                break;

            case 3:

                out.println("Menu de modificacion");

                out.println("1.- telefonos");

                out.println("2.- correos");


                
                out.println("La modificacion no esta implementada ");

                break;

            case 4:

                vector.remove(dato);

                out.println("Registro borrado correctamente!!.");

                break;

            case 5:

                Collections.sort(vector);

                out.println("Registros ordenados correctamente!!.");

                break;

            case 6:

                n = vector.size();

                contador[0] = 0;

                for (i=0; i<n; i++){

                out.println(vector.get(i).getAlias());
                out.println(vector.get(i).getTelefono());
                out.println(vector.get(i).getCorreo());
               
                out.println("Total de registros: " + contador[0] + ".");

                //break;
                }

            }

            if (opcion<7 && opcion>=1)

             //   pausar("");
            contacto= new Contacto();
            telf.clear();
            mail.clear();

        } while (opcion!=7);

        try {

            PrintStream salida = new PrintStream(ruta);
            
            FileOutputStream salida2= new FileOutputStream(fichero,true);
            oos = new ObjectOutputStream(salida2); 
         // oos= new ObjectOutputStream(new FileOutputStream(fichero,true));
            n = vector.size();

            for (i=0; i<n; i++){
                
                imprimirEnArchivo.funcion(vector.get(i), salida);
            
             }
            salida.close();
            oos.writeObject(vector.addAll(vector));
            salida2.close();

        } catch (FileNotFoundException e) {}
          catch (IOException e){out.println("Hay problemas leyendo o grabando en el archivo!");}

    } // fin metodo main
    
    public static boolean telefonoRepetido(List<String> lista,String telefono){
        
        int i=(lista).indexOf(telefono);
        
        return(i>=0);

        }   

/*    public static void graba(){
       //     ObjectOutputStream oos;
        try {
            oos= new ObjectOutputStream(new FileOutputStream(fichero,true));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
*/
    
}// fin de la clase


interface Funcion<T extends Comparable<T>> {

    void funcion(T dato, Object parametros);

}

 
