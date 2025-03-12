import java.time.LocalDate;

public class Trabajador extends Persona{

    protected String numeroSS;
    protected String email;
    protected String salario;
    protected Departamento departamento;
    protected boolean isOficina;
    
    public Trabajador(String nombre, String dni, LocalDate fechaNacimiento, String direccion, String numeroSS,
            String email, String salario, Departamento departamento) {
        super(nombre, dni, fechaNacimiento, direccion);
        this.numeroSS = numeroSS;
        this.email = email;
        this.salario = salario;
        this.departamento = departamento;
        this.isOficina = false;
    }

    public String getNumeroSS() {
        return numeroSS;
    }

    public void setNumeroSS(String numeroSS) {
        this.numeroSS = numeroSS;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
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
        sb.append("Trabajador:");
        sb.append("nombre:").append(nombre);
        sb.append(", dni:").append(dni);
        sb.append(", fechaNacimiento:").append(fechaNacimiento);
        sb.append(", direccion:").append(direccion);
        sb.append(", numeroSS:").append(numeroSS);
        sb.append(", email:").append(email);
        sb.append(", salario:").append(salario);
        sb.append(", departamento:").append(departamento);
        sb.append('.');
        return sb.toString();
    }
}
