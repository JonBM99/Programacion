

public class Escuela {
    private String nombre;
    private String localizacion;
    private JefeEstudios [] jefesEstudios;
    private Profesor [] profesores;
    public int nTrabajadores;
    private int nJefeEstudios;
    private int nProfes;
    
    public Escuela(String nombre, String localizacion) {
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.jefesEstudios = new JefeEstudios[3];
        this.profesores = new Profesor[96];
        this.nTrabajadores = 0;
        this.nJefeEstudios = 0;
        this.nProfes = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public JefeEstudios[] getJefesEstudios() {
        return jefesEstudios;
    }

    public Profesor[] getProfesores() {
        return profesores;
    }
    
    public int getnTrabajadores() {
        return nTrabajadores;
    }

    public String mostrarInfoEscuela(){
        String mostrarInfoEscuela = String.format("Nombre de la Escuela: %s, Localizacion: %s", this.nombre, this.localizacion);
        return mostrarInfoEscuela;
    }
    
    public boolean registarDirector(Director director){
        boolean isAdd = false;
        if(director!= null){
            nTrabajadores++;
        }
        return isAdd;
    }

    public boolean registrarJefeEstudios(JefeEstudios jefe){
        boolean isAdd = false;
        if(jefe != null){
            this.jefesEstudios [nJefeEstudios] = jefe;
            nJefeEstudios++;
            nTrabajadores++;
        }
        return isAdd;
    }

    public void mostrarJefeEstudios(){
        if(jefesEstudios !=  null){
            for (int i = 0; i < nJefeEstudios; i++) {
                System.out.println(i + ". " + jefesEstudios[i].mostrarInfoJefeEstudios());
            }
        }
    }

    public boolean eliminarJefeEstudios(JefeEstudios jefe, int cod){
        boolean isRemoved = false;
        if(jefe != null){
            this.jefesEstudios[cod] = null;
            for (int i = cod + 1; i < nJefeEstudios; i++) {
                this.jefesEstudios[i - 1] = this.jefesEstudios[i];
            }
            this.jefesEstudios[nJefeEstudios - 1] = null;
            nJefeEstudios--;
            isRemoved = true;
            System.out.println("Jefe de estudios eliminado correctamente");
        }
        return isRemoved;
    }

    public boolean registrarProfesores(Profesor p){
        boolean isAdd = false;
        if(p != null){
            this.profesores[nProfes] = p;
            nProfes++;
            nTrabajadores++;
        }
        return isAdd;
    }
    
    public void mostrarProfesores(){
        if(profesores !=  null){
            for (int i = 0; i < nProfes; i++) {
                System.out.println(i + ". " + profesores[i].mostrarInfoProfesor());
            }
        }
    }

    public boolean eliminarProfesor(Profesor profe, int cod){
        boolean isRemoved = false;
        if(profe != null){
            this.profesores[cod] = null;
            for (int i = cod + 1; i < nProfes; i++) {
                this.profesores[i - 1] = this.profesores[i];
            }
            this.profesores[nProfes - 1] = null;
            nProfes--;
            isRemoved = true;
            System.out.println("Profesor eliminado correctamente");
        }
        return isRemoved;
    }

    public void mostrarInfoNiveles(Niveles asignacion){
        System.out.println("Informacion del nivel: " + asignacion);
        System.out.println("Jefe de estudios:");
        for (JefeEstudios jefe : jefesEstudios){
            if(jefe != null && jefe.getAsignacion() == asignacion){
                System.out.println("-" + jefe.getNombre());
            }
        }
        System.out.println("Profesores:");
        for (Profesor profesor : profesores){
            if(profesor != null && profesor.getAsignacion() == asignacion){
                System.out.println("-" + profesor.getNombre());
            }
        }  
    }

}
