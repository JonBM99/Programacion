import java.time.LocalDate;

public class Persona {
    protected String nombre;
    protected String dni;
    protected LocalDate fechaNacimiento;
    protected String direccion;
    
    public Persona(String nombre, String dni, LocalDate fechaNacimiento, String direccion) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona:");
        sb.append("nombre:").append(nombre);
        sb.append(", dni:").append(dni);
        sb.append(", fechaNacimiento:").append(fechaNacimiento);
        sb.append(", direccion:").append(direccion);
        sb.append('.');
        return sb.toString();
    }


}
