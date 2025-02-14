import java.time.LocalDate;

public class Cliente extends Persona{
    private String telefono;
    private String email;
    private String direccion;
    
    public Cliente(String nombre, String dni, LocalDate fechaNacimiento, String telefono, String email,
            String direccion) {
        super(nombre, dni, fechaNacimiento);
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente:");
        sb.append("nombre:").append(nombre);
        sb.append(", dni:").append(dni);
        sb.append(", fechaNacimiento:").append(fechaNacimiento);
        sb.append(", telefono:").append(telefono);
        sb.append(", email:").append(email);
        sb.append(", direccion:").append(direccion);
        sb.append('.');
        return sb.toString();
    }
}
