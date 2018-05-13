package contacto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josem
 */
class Contacto implements Comparable<Contacto> {

 

    private String alias;

    private List<String> telefonos = new ArrayList();

    private List<String> correos = new ArrayList();
 

    @Override

    public boolean equals(Object contacto) {

        return this==contacto || (contacto instanceof Contacto && alias.equals(((Contacto)contacto).alias));

    }

 

    @Override

    public int compareTo(Contacto contacto) {

        return alias.compareTo(contacto.alias);

    }

 

    @Override

    public String toString() {

        return

            "Nombre     : " + alias + "\n" +

            "telefonos  : " + telefonos + "\n" +

            "correos    : " + correos + "\n";

    }

 

    public String getAlias() {

        return alias;

    }

 

    public void setAlias(String alias) {

        this.alias = alias;

    }

 

    public List<String> getTelefono() {

        return telefonos;

    }

 

    public void setTelefonos(List<String> telefonos) {

        this.telefonos = telefonos;

    }

    
    public List<String> getCorreo() {

        return correos;

    }

 

    public void setCorreo(List<String> correo) {

        this.correos = correo;

    }

}  // fin clase contacto
