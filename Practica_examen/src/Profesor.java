
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Profesor {
    private int cod;
    private String nombre;
    private String dni;
    private LocalDateTime fechaAlta;
    private Niveles asignacion;
    private static int contador = 1;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy hh:mm:ss");
    
    public Profesor(String nombre, String dni, Niveles asignacion) {
        this.cod = this.contador;
        this.contador++;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaAlta = LocalDateTime.now();
        this.asignacion = asignacion;
    }

    public int getCod() {
        return cod;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public Niveles getAsignacion() {
        return asignacion;
    }

    public String mostrarInfoProfesor(){
        String infoProfesor = String.format("Codigo del profesor: %s, Nombre: %s, DNI: %s Asignado a %s", this.cod, this.nombre, this.dni, this.asignacion);
        return infoProfesor;
    }
}
