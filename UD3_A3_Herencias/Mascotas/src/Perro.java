public class Perro extends Mascotas {
    private String raza;
    private boolean pulgas;
    
    public Perro(String nombre, int edad, String estado, String fechaNacimiento, String raza, boolean pulgas) {
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
        this.raza = raza;
        this.pulgas = pulgas;
    }
    
    @Override
    void muestra() {
        System.out.println("Perro - Nombre: " + nombre + ", Raza: " + raza);
    }
    
    @Override
    void cumpleaños() {
        edad++;
    }
    
    @Override
    void morir() {
        estado = "fallecido";
    }
    
    @Override
    void habla() {
        System.out.println("¡Guau guau!");
    }
}
