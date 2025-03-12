
import java.time.LocalDate;
import java.util.LinkedList;

public class GerenteDep extends Trabajador{

    private int numTrabajadores;
    private int numTelefono;
    private LinkedList<Trabajador> trabajadoresDepartamento;
    /*Creo numTrabajadores y trabajadoresDepartamento porque lo pide el enunciado pero
    he creado un metodo en empresa que simplifica el uso de estos para prescindir de ellos y hacerlo mas sencillo*/
    
    public GerenteDep(String nombre, String dni, LocalDate fechaNacimiento, String direccion, String numeroSS,
            String email, String salario, Departamento departamento, int numTelefono) {
        super(nombre, dni, fechaNacimiento, direccion, numeroSS, email, salario, departamento);
        this.numTrabajadores = 0; 
        this.numTelefono = numTelefono;
        this.trabajadoresDepartamento = new LinkedList<>();
    }


    public int getNumTrabajadores() {
        return numTrabajadores;
    }


    public void setNumTrabajadores(int numTrabajadores) {
        this.numTrabajadores = numTrabajadores;
    }


    public int getNumTelefono() {
        return numTelefono;
    }


    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }


    public LinkedList<Trabajador> getTrabajadoresDepartamento() {
        return trabajadoresDepartamento;
    }


    public void setTrabajadoresDepartamento(LinkedList<Trabajador> trabajadoresDepartamento) {
        this.trabajadoresDepartamento = trabajadoresDepartamento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GerenteDep{");
        sb.append("nombre:").append(nombre);
        sb.append(", dni:").append(dni);
        sb.append(", fechaNacimiento:").append(fechaNacimiento);
        sb.append(", direccion:").append(direccion);
        sb.append(", numeroSS:").append(numeroSS);
        sb.append(", email:").append(email);
        sb.append(", salario:").append(salario);
        sb.append(", numTelefono:").append(numTelefono);
        sb.append(", departamento:").append(departamento);
        sb.append('.');
        return sb.toString();
    }
}
