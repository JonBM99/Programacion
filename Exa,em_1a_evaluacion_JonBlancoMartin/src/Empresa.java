import java.time.LocalDate;

public class Empresa {
    private String nombre;
    private String cif;
    private LocalDate fechaFundacion;
    private int maxTrabajadores;
    private Trabajador [] trabajadores;
    public int nTrabajadores;
    private Trabajador [] personas;
    private int nPersonas;

    public Empresa(String cif, String nombre) {
        this.cif = cif;
        this.fechaFundacion = LocalDate.now();
        this.maxTrabajadores = 20;
        this.nombre = nombre;
        this.trabajadores = new Trabajador[maxTrabajadores];
        this.nTrabajadores = 0;
        this.personas = new Trabajador[100];
        this.nPersonas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCif() {
        return cif;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public int getMaxTrabajadores() {
        return maxTrabajadores;
    }

    public Trabajador[] getTrabajadores() {
        return trabajadores;
    }

    public int getnTrabajadores() {
        return nTrabajadores;
    }

    public String mostrarInfoEmpresa(){
        String infoEmpresa = String.format("CIF: %s, Nombre: %s, Fecha de fundacion: %s", this.cif, this.nombre, this.fechaFundacion);
        return infoEmpresa;
    }

    public boolean registrarPersona(Trabajador p){
        boolean isAdd = false;
        if(p != null){
            this.personas[nPersonas] = p;
            nPersonas++;
        }
        return isAdd;
    }

    public boolean eliminarPersona(Trabajador p, int i){
        boolean isRemoved = false;
        if(p != null){
            this.posicionPersona(i);
            this.personas[nPersonas] = null;
            nPersonas--;
        }
        return isRemoved;
    }

    public void mostrarPersonas(){
            for (int i = 0; i < nPersonas; i++) {
                System.out.println(i + ". " + personas[i].mostrarInfoTrabajador());
        }
    }

    public Trabajador posicionPersona(int i){
        return this.personas[i];
    }


    public boolean registrarTrabajador(Trabajador p, int i){
        boolean isAdd = false;
        if(p != null && nTrabajadores<maxTrabajadores){
            this.posicionPersona(i);
            this.trabajadores[nTrabajadores] = p;
            nTrabajadores++;
            p.contratar();
        }
        return isAdd;
    }

    public void mostrarTrabajadores(){
        if(trabajadores !=  null){
            for (int i = 0; i < nTrabajadores; i++) {
                System.out.println(i + ". " + trabajadores[i].mostrarInfoTrabajador());
            }
        }
    }
    

    public boolean eliminarTrabajador(Trabajador p, String dni1){
        boolean isRemoved = false;
        if(p != null){
            int index = -1;
            for(int i = 0; i < nTrabajadores; i++){
                if(this.trabajadores[i] != null){
                    if(this.trabajadores[i].getDni().equalsIgnoreCase(p.getDni())){
                        index = i;
                        p.despedir();
                    }
                }
            }
            if(index != -1){
                this.trabajadores[index] = null;
                isRemoved = true;
                for(int i = index+1; i < nTrabajadores; i++){
                    this.trabajadores[i-1] = this.trabajadores[i];
                }
                this.trabajadores[nTrabajadores-1] = null;
                nTrabajadores--;
            }
        }
        return isRemoved;
    }

}
