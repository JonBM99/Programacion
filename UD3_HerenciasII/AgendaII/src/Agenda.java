public class Agenda {
    private Contactos [] contactosRegistrados = new Contactos[maxContactos];
    private int nContactos = 0;
    private static int maxContactos = 50;

    
    
    
    /** 
     * @param contacto
     * @return boolean
     */
    
    public boolean agregarContacto(Contactos contacto) {
        if (nContactos < maxContactos) {
            contactosRegistrados[nContactos] = contacto;
            nContactos++;
            return true;
        }
        return false;
    }

    public boolean eliminarContactoPersona(String nombre){
        for (int i = 0; i < nContactos; i++) {
            if (contactosRegistrados[i].getNombre().equals(nombre) && contactosRegistrados[i] instanceof ContactoPersona) {
                contactosRegistrados[i] = contactosRegistrados[nContactos - 1];
                nContactos--;
                return true;
            }
        }
        return false;
    }
    
    public boolean eliminarContactoEmpresa(String nombreEmpresa){
        for (int i = 0; i < nContactos; i++) {
            if (contactosRegistrados[i].getNombre().equals(nombreEmpresa) && contactosRegistrados[i] instanceof ContactoEmpresa) {
                contactosRegistrados[i] = contactosRegistrados[nContactos - 1];
                nContactos--;
                return true;
            }
        }
        return false;
    }
    
    public boolean existeContactoPersona(String nombre){
        for (int i = 0; i < nContactos; i++) {
            if (contactosRegistrados[i].getNombre().equals(nombre) && contactosRegistrados[i] instanceof ContactoPersona) {
                return true;
            }
        }
        return false;
    }

    public boolean existeContactoEmpresa(String nombreEmpresa){
        for (int i = 0; i < nContactos; i++) {
            if (contactosRegistrados[i].getNombre().equals(nombreEmpresa) && contactosRegistrados[i] instanceof ContactoEmpresa) {
                return true;
            }
        }
        return false;
    }

    public void listarContactos(){
        for (int i = 0; i < nContactos; i++) {
            System.out.println(contactosRegistrados[i]);
        }
    }

    public int buscarContactoPersona(String nombre){
        for (int i = 0; i < nContactos; i++) { 
            if (contactosRegistrados[i].getNombre().equals(nombre) && contactosRegistrados[i] instanceof ContactoPersona) {
                return i;
            }
        }
        return -1;
    }

    public int buscarContactoEmpresa(String nombreEmpresa){
        for (int i = 0; i < nContactos; i++) { 
            if (contactosRegistrados[i].getNombre().equals(nombreEmpresa) && contactosRegistrados[i] instanceof ContactoEmpresa) {
                return i;
            }
        }
        return -1;
    }

    public Contactos getContacto(int indice) {
        return contactosRegistrados[indice];
    }
}
