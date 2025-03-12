import java.time.LocalDate;

public class Director extends Trabajador{

    private String numTelefono;
    private boolean isReunido;
    private boolean isOficina;
    
    public Director(String nombre, String dni, LocalDate fechaNacimiento, String direccion, String numeroSS,
            String email, String salario, Departamento departamento, String numTelefono) {
        super(nombre, dni, fechaNacimiento, direccion, numeroSS, email, salario, departamento);
        this.numTelefono = numTelefono;
        this.isReunido = false;
        this.isOficina = false;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public boolean isReunido() {
        return isReunido;
    }

    public void setReunido(boolean isReunido) {
        this.isReunido = isReunido;
    }

    public boolean isOficina() {
        return isOficina;
    }

    public void setOficina(boolean isOficina) {
        this.isOficina = isOficina;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Director:");
        sb.append("nombre:").append(nombre);
        sb.append(", dni:").append(dni);
        sb.append(", fechaNacimiento:").append(fechaNacimiento);
        sb.append(", direccion:").append(direccion);
        sb.append(", numeroSS:").append(numeroSS);
        sb.append(", email:").append(email);
        sb.append(", salario:").append(salario);
        sb.append(", numTelefono:").append(numTelefono);
        sb.append('.');
        return sb.toString();
    }

    
}
