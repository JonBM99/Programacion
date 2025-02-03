import java.util.HashMap;
import java.util.Map;

public class Agenda {
    Map<String, Contactos> contactos = new HashMap<>();

    public int añadirContacto(String nombre, String telefono, String correo) {
        Contactos contacto = new Contactos(nombre, telefono, correo);
        if (!contacto.validaciones(1, nombre)) {
            return 1;
        }
        if (!contacto.validaciones(2, telefono)) {
            return 2;
        }
        if (!contacto.validaciones(3, correo)) {
            return 3;
        }
        for (Contactos c : contactos.values()) {
            if (c.getNombre().equals(nombre)) {
                return 4;
            }
        }
        contactos.put(nombre, contacto);
        return 0;
    }

    public String buscaContacto(String nombre) {
        if (contactos.containsKey(nombre)) {
            return contactos.get(nombre).toString();
        } else {
            return "No se ha encontrado el contacto";
        }
    }

    public String eliminaContacto(String nombre) {
        if (contactos.containsKey(nombre)) {
            return contactos.remove(nombre).toString();
        } else {
            return "No se ha encontrado el contacto";
        }
    }

    public String visualizaAgenda(){
        String agenda = "";
        for (Map.Entry<String, Contactos> entry : contactos.entrySet()) {
            agenda += entry.getValue().toString();
        }
        return agenda;
    }
}
