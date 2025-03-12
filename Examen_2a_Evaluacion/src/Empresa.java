
import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;

public class Empresa {
    private String nombre;
    private String cif;
    private LocalDate fechaFundacion;
    private LinkedList<Trabajador>empleados;
    
    public Empresa(String nombre, String cif) {
        this.nombre = nombre;
        this.cif = cif;
        this.fechaFundacion = LocalDate.now();
        this.empleados = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCif() {
        return cif;
    }
    public void setCif(String cif) {
        this.cif = cif;
    }
    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }
    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }
    public LinkedList<Trabajador> getEmpleados() {
        return empleados;
    }
    public void setEmpleados(LinkedList<Trabajador> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empresa:");
        sb.append("nombre:").append(nombre);
        sb.append(", cif:").append(cif);
        sb.append(", fechaFundacion:").append(fechaFundacion);
        sb.append('.');
        return sb.toString();
    }

    public boolean registrarDirector(Director director) throws DirectorYaRegistradoException{
        for (Trabajador t: empleados) {
            if(director.getClass().equals(t.getClass())){
                throw new DirectorYaRegistradoException("Ya existe un director");
            }
        }
        empleados.add(director);
        return true;
    }

    public boolean registrarGerente(GerenteDep gerente) throws GerenteYaRegistradoException{
        for (Trabajador t: empleados) {
            if(gerente.getDepartamento().equals(t.getDepartamento())){
                throw new GerenteYaRegistradoException("Ya existe un gerente con este dni");
            }
        }
        empleados.add(gerente);
        return true;
    }

    public boolean registrarTrabajador(Trabajador trabajador) throws TrabajadorYaRegistradoException{
        for (Trabajador t: empleados) {
            if(trabajador.getDni().equals(t.getDni())){
                throw new TrabajadorYaRegistradoException("Ya existe un trabajador con este dni");
            }
        }
        empleados.add(trabajador);
        return true;
    }

    public boolean eliminarTrabajador(String dni){
        for (Trabajador trabajador: empleados) {
            if(trabajador.getDni().equals(dni)){
                empleados.remove(trabajador);
            }
        }
        return true;
    }

    public String mostrarTrabajadores(){
        Iterator<Trabajador> itera = empleados.iterator();
        StringBuilder resultado = new StringBuilder();
        while (itera.hasNext()) {
            Trabajador cadaTrabajador = itera.next();
            resultado.append(cadaTrabajador.toString()).append("\n");
        }
        return resultado.toString();
    }

/* Este metodo simplifica el mostrar trabajadores por departamento y el uso de otra 
linkedlist (aunque la haya creado) para agrupar los trabajadores por departamento 
y mostrar su informacion*/
    public String mostrarTrabajadoresPorDepartamento(Departamento departamento){ 
        Iterator<Trabajador> itera = empleados.iterator();
        StringBuilder resultado = new StringBuilder();
        while (itera.hasNext()) {
            Trabajador cadaTrabajador = itera.next();
            if(departamento.equals(cadaTrabajador.getDepartamento())){
                resultado.append(cadaTrabajador.toString()).append("\n");
            }
        }
        return resultado.toString();
    }
    
/*Con este metodo puedo sacar el numero de empleados sin necesidad de usar el numEmpleados de la clase GerenteDep */
    public String numeroEmpleados(){
        String numEmpleados = String.format("Numero de empleados total: %s", empleados.size());
        return numEmpleados;
    }

    public String mostrarTrabajadoresFuera(){
        Iterator<Trabajador> itera = empleados.iterator();
        StringBuilder resultado = new StringBuilder();
        while (itera.hasNext()) {
            Trabajador cadaTrabajador = itera.next();
            if (cadaTrabajador.isOficina == false) {
                resultado.append(cadaTrabajador.toString()).append("\n");
            }
            
        }
        return resultado.toString();
    }

    public String reunirEmpresa(){
        Iterator<Trabajador> itera = empleados.iterator();
        StringBuilder resultado = new StringBuilder();
        while (itera.hasNext()) {
            Trabajador cadaTrabajador = itera.next();
            if (cadaTrabajador.isOficina == true /*&& (director != null) Deberia ser algo asi pero no se como sacarlo*/) {
                resultado.append(cadaTrabajador.getNombre()).append("\n");
            } else{ 
                return"Vaya parece que estan de vacaciones";
            }
            
        }
        return "Se convoca una reunion a los siguientes trabajadores:" + resultado.toString();
    }
}

