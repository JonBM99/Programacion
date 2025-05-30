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

    public boolean eliminarContacto(String nombre){
        for (int i = 0; i < nContactos; i++) {
            if (contactosRegistrados[i].getNombre().equals(nombre)) {
                contactosRegistrados[i] = contactosRegistrados[nContactos - 1];
                nContactos--;
                return true;
            }
        }
        return false;
    }
    
    public boolean existeContacto(String nombre){
        for (int i = 0; i < nContactos; i++) {
            if (contactosRegistrados[i].getNombre().equals(nombre)) {
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

    public int buscarContacto(String nombre){
        for (int i = 0; i < nContactos; i++) {
            if (contactosRegistrados[i].getNombre().equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public Contactos getContacto(int indice) {
        return contactosRegistrados[indice];
    }
}
