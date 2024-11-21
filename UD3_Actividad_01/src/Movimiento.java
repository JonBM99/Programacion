import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimiento {
    private int id;
    private String fecha;
    private String tipo;
    private double cantidad;

    private static int nMovimientos = 0;
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:SS");

    public Movimiento(String tipo, double cantidad) {
        this.id = this.nMovimientos;
        this.nMovimientos++;
        
        this.fecha = LocalDateTime.now().format(formatter);
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public double getCantidad() {
        return cantidad;
    }
    
    public void mostrarInfoMovimiento(){
        System.out.println("La id del movimiento es: " + id);
        System.out.println("La fecha del movimiento es: " + fecha);
        System.out.println("El tipo de movimiento es: " + tipo);
        System.out.println("La cantidad es: " + cantidad);
    }

}
