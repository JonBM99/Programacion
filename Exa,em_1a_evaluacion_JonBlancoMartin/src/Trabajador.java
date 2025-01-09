import java.time.LocalDate;

public class Trabajador {
    private String nombre;
    private LocalDate fechaNacimiento;
    private String dni;
    private String direccion;
    private String numeroSS;
    public boolean isContratado;

    final String patronnumeroSS = "[0-9]{10}";

    public Trabajador(String dni, String nombre, LocalDate fechaNacimiento, String direccion, String numeroSS) {
        this.direccion = direccion;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.numeroSS = numeroSS;
        this.isContratado = false;
    }


    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNumeroSS() {
        return numeroSS;
    }

    public boolean isContratado() {
        return isContratado;
    }

    public String mostrarInfoTrabajador(){
        String infoTrabajador = String.format("DNI: %s, Nombre: %s, Fecha de nacimiento: %s, Direccion: %s, NºSS: %s", this.dni, this.nombre, this.fechaNacimiento, this.direccion, this.numeroSS);
        return infoTrabajador;
    }

    public boolean contratar(){
        this.isContratado = true;
        numeroSS = MyUtils.comprobarPatronRepetidamente(patronnumeroSS, "Introduce el numero de la seguridad social que quieres asignar al trabajador:");
        return isContratado;
    }

    public boolean despedir(){
        numeroSS = "null";
        return isContratado;
    }
}
