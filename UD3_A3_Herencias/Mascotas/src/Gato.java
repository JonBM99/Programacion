public class Gato extends Mascotas {
    private String color;
    private boolean peloLargo;
    
    public Gato(String nombre, int edad, String estado, String fechaNacimiento, String color, boolean peloLargo) {
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
        this.color = color;
        this.peloLargo = peloLargo;
    }
    
    @Override
    void muestra() {
        System.out.println("Gato - Nombre: " + nombre + ", Color: " + color);
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
        System.out.println("¡Miau miau!");
    }
}
