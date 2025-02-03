
import java.util.regex.Pattern;

public class Contactos {
    private String nombre;
    private String telefono;
    private String correo;

    Pattern patronnombre = Pattern.compile("[A-Z]+[a-z]");
    Pattern patrontelefono = Pattern.compile("[679]\\d{8}");
    Pattern patroncorreo = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");

    public Contactos(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public boolean validaciones (int op, String texto){
    switch(op){
        case 1:
            return patronnombre.matcher(nombre).matches();
        case 2:
            return patrontelefono.matcher(telefono).matches();
        case 3:
            return patroncorreo.matcher(correo).matches();
        }
        return false;
    }
    
    public void setNombre(String nombre) {
        if (validaciones(0, nombre)){
            this.nombre = nombre;
        }
    }

    public void setTelefono(String telefono) {
        if (validaciones(1, telefono)){
            this.telefono = telefono;
        }
    }

    public void setCorreo(String correo) {
        if (validaciones(2, correo)){
            this.correo = correo;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contactos{");
        sb.append("nombre=").append(nombre);
        sb.append(", telefono=").append(telefono);
        sb.append(", correo=").append(correo);
        sb.append('}');
        return sb.toString();
    }
}
