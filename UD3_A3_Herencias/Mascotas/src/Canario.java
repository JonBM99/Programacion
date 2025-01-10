public class Canario extends Aves {
    private String color;
    private boolean canta;
    
    public Canario(String nombre, int edad, String estado, String fechaNacimiento, String pico, String vuela, String color, boolean canta) {
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
        this.pico = pico;
        this.vuela = vuela;
        this.color = color;
        this.canta = canta;
    }
    
    @Override
    void muestra() {
        System.out.println("Canario - Nombre: " + nombre + ", Color: " + color);
    }
    
    @Override
    void volar() {
        System.out.println("El canario está volando");
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
        System.out.println("¡Pío pío!");
    }
}
